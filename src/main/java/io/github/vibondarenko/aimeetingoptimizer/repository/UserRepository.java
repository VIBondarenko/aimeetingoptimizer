package io.github.vibondarenko.aimeetingoptimizer.repository;

import io.github.vibondarenko.aimeetingoptimizer.entity.User;
import org.springframework.data.jpa.repository.*;

public interface UserRepository  extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}
