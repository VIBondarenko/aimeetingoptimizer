package io.github.vibondarenko.aimeetingoptimizer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Getter
    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "tokenExpired", nullable = false)
    private boolean tokenExpired;

    public String getPassword() {
        return password;
    }
}