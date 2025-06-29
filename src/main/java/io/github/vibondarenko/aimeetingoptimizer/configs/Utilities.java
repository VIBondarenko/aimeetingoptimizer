package io.github.vibondarenko.aimeetingoptimizer.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Year;

@Configuration
public class Utilities {

    @Bean(name = "getCurrentYear")
    public String getCurrentYear() {
        return Year.now().toString();
    }

    @Bean(name = "getAppName")
    public String getAppName() {
        return "";
    }

}
