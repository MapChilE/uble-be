package com.ureca.uble.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name="token")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "expiry_date", nullable = false)
    private LocalDateTime expiryDate;

    @Builder(access = PRIVATE)
    private Token(User user, String refreshToken, LocalDateTime expiryDate) {
        this.user = user;
        this.refreshToken = refreshToken;
        this.expiryDate = expiryDate;
    }

    public static Token of (User user, String refreshToken, LocalDateTime expiryDate) {
        return Token.builder()
            .user(user)
            .refreshToken(refreshToken)
            .expiryDate(expiryDate)
            .build();
    }

    public void updateRefreshToken(String refreshToken, LocalDateTime expiryDate) {
        this.refreshToken = refreshToken;
        this.expiryDate = expiryDate;
    }
}
