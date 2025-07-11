package com.ureca.uble.domain.auth.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.ureca.uble.domain.auth.dto.response.KakaoLoginRes;
import com.ureca.uble.domain.auth.dto.response.KakaoUserRes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class KakaoOauthClient {

	@Value("${kakao.client-id}")
	private String clientId;

	@Value("${kakao.redirect-uri}")
	private String redirectUri;

	private final WebClient kakaoAuthWebClient;
	private final WebClient kakaoApiWebClient;

	public String getAccessToken(String code) {
		return kakaoAuthWebClient.post()
			.uri(uriBuilder -> uriBuilder
				.path("/oauth/token")
				.queryParam("grant_type", "authorization_code")
				.queryParam("client_id", clientId)
				.queryParam("redirect_uri", redirectUri)
				.queryParam("code", code)
				.build())
			.retrieve()
			.bodyToMono(Map.class)
			.map(res -> (String)res.get("access_token"))
			.block();
	}

	public KakaoUserRes getUserInfo(String accessToken){
		return kakaoApiWebClient.get()
			.uri("/v2/user/me")
			.headers(headers -> headers.setBearerAuth(accessToken))
			.retrieve()
			.bodyToMono(KakaoUserRes.class)
			.block();
	}
}
