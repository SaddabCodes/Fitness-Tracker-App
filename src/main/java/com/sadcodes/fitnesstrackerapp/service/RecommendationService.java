package com.sadcodes.fitnesstrackerapp.service;

import com.sadcodes.fitnesstrackerapp.dto.RecommendationRequest;
import com.sadcodes.fitnesstrackerapp.model.Activity;
import com.sadcodes.fitnesstrackerapp.model.Recommendation;
import com.sadcodes.fitnesstrackerapp.model.User;
import com.sadcodes.fitnesstrackerapp.repository.ActivityRepository;
import com.sadcodes.fitnesstrackerapp.repository.RecommendationRepository;
import com.sadcodes.fitnesstrackerapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("User not found: " + request.getId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("User not found: " + request.getId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestion())
                .safety(request.getSafety())
                .build();

        return recommendationRepository.save(recommendation);

    }

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}
