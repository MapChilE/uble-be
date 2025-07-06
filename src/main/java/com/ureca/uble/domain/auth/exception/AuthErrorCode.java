package com.ureca.uble.domain.auth.exception;

import org.springframework.http.HttpStatus;

import com.ureca.uble.global.exception.ResultCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ResultCode {
	INVALID_TOKEN(HttpStatus.UNAUTHORIZED, 1000, "유효하지 않은 토큰입니다."),
	REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, 1001, "Refresh token이 존재하지 않습니다."),
	UNAUTHORIZED_ACCESS(HttpStatus.UNAUTHORIZED, 1002, "인가되지 않은 접근입니다.");

	private final HttpStatus status;
	private final int code;
	private final String message;
}
