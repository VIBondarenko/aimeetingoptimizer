

package io.github.vibondarenko.aimeetingoptimizer.repository;

import io.github.vibondarenko.aimeetingoptimizer.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
	// Можно добавить кастомные методы поиска при необходимости
}
