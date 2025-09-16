
package io.github.vibondarenko.aimeetingoptimizer.audio;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Service for recording audio from microphone (WAV format) чанками и параллельной отправкой в транскриптор.
 */
public class AudioRecorderService {

    private TargetDataLine line;
    private final AudioFormat format = new AudioFormat(16000, 16, 1, true, true);
    private boolean recording = false;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    private final int chunkSeconds = 15; // длина чанка в секундах

    public void startRecording(String basePath) throws LineUnavailableException {
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        line = (TargetDataLine) AudioSystem.getLine(info);
        line.open(format);
        line.start();
        recording = true;

        Thread thread = new Thread(() -> {
            int chunkIndex = 0;
            int bufferSize = (int) format.getSampleRate() * format.getFrameSize() * chunkSeconds;
            byte[] buffer = new byte[bufferSize];
            while (recording) {
                int bytesRead = line.read(buffer, 0, buffer.length);
                if (bytesRead > 0) {
                    String chunkFile = basePath + "_chunk" + chunkIndex + ".wav";
                    saveChunk(buffer, bytesRead, chunkFile);
                    // Параллельно отправляем чанк в транскриптор
                    int finalChunkIndex = chunkIndex;
                    executor.submit(() -> transcribeChunk(chunkFile, finalChunkIndex));
                    chunkIndex++;
                }
            }
        });
        thread.start();
    }

    public void stopRecording() {
        recording = false;
        if (line != null) {
            line.stop();
            line.close();
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isRecording() {
        return recording;
    }

    private void saveChunk(byte[] buffer, int bytesRead, String filePath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(buffer, 0, bytesRead)) {
            try (AudioInputStream ais = new AudioInputStream(bais, format, bytesRead / format.getFrameSize())) {
                AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File(filePath));
            }
        } catch (IOException e) {
            // TODO: логировать ошибку
        }
    }

    // Заглушка для параллельной отправки чанка в транскриптор (Whisper)
    private void transcribeChunk(String chunkFile, int chunkIndex) {
        // TODO: интеграция с Whisper или другим сервисом транскрипции
        // Пример: отправить chunkFile через REST API и получить текст
        // Сохранить результат в БД или файл
    }
}
