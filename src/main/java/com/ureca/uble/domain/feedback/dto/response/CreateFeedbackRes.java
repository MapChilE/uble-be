package com.ureca.uble.domain.feedback.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "서비스 피드백 생성 응답 DTO")
public class CreateFeedbackRes {

    @Schema(description = "생성된 피드백 ID", example = "123")
    private final Long feedbackId;

    public CreateFeedbackRes(Long feedbackId) {
        this.feedbackId = feedbackId;
    }
}
