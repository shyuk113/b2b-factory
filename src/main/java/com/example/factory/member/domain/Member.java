package com.example.factory.member.domain;

import com.example.factory.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uk_member_username", columnNames = "username"),
        @UniqueConstraint(name = "uk_member_email", columnNames = "email")
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleName role;

    private boolean active;

    @Builder(access = AccessLevel.PRIVATE)
    private Member(String username, String password, String email, RoleName role, boolean active) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    public static Member createMember(String username, String password, String email, RoleName role, boolean active) {
        return Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .role(role)
                .active(active)
                .build();
    }

    public void updateProfile(String email) {
        this.email = email;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeRole(RoleName role) {
        this.role = role;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}
