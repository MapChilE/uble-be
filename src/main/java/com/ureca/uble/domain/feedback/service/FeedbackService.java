package com.ureca.uble.domain.feedback.service;

import com.ureca.uble.domain.feedback.dto.request.CreateFeedbackReq;

public interface FeedbackService {
    Long createFeedback(Long userId, CreateFeedbackReq req);
}
