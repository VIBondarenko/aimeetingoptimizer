

package io.github.vibondarenko.aimeetingoptimizer.repository;

import io.github.vibondarenko.aimeetingoptimizer.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
	// Можно добавить кастомные методы поиска при необходимости
}
