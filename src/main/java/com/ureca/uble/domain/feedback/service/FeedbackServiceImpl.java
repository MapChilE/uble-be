package com.ureca.uble.domain.feedback.service;

import com.ureca.uble.domain.feedback.dto.request.CreateFeedbackReq;
import com.ureca.uble.domain.feedback.repository.FeedbackRepository;
import com.ureca.uble.domain.users.repository.UserRepository;
import com.ureca.uble.entity.Feedback;
import com.ureca.uble.entity.User;
import com.ureca.uble.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ureca.uble.domain.users.exception.UserErrorCode.USER_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    @Override
    public Long createFeedback(Long userId, CreateFeedbackReq req) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GlobalException(USER_NOT_FOUND));

        Feedback feedback = Feedback.of(
                user,
                req.getTitle(),
                req.getContent(),
                req.getScore()
        );

        Feedback saved = feedbackRepository.save(feedback);
        return saved.getId();
    }
}
