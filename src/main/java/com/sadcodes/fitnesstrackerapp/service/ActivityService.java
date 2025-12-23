package com.sadcodes.fitnesstrackerapp.service;

import com.sadcodes.fitnesstrackerapp.dto.ActivityRequest;
import com.sadcodes.fitnesstrackerapp.dto.ActivityResponse;
import com.sadcodes.fitnesstrackerapp.model.Activity;
import com.sadcodes.fitnesstrackerapp.model.User;
import com.sadcodes.fitnesstrackerapp.repository.ActivityRepository;
import com.sadcodes.fitnesstrackerapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityService(ActivityRepository activityRepository,
                           UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public ActivityResponse trackActivity(ActivityRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurn(request.getCaloriesBurn())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity saved = activityRepository.save(activity);
        return mapToResponse(saved);
    }

    public List<ActivityResponse> getUserActivities(String userId) {
        return activityRepository.findByUser_Id(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse res = new ActivityResponse();
        res.setId(activity.getId());
        res.setUserId(activity.getUser().getId());
        res.setType(activity.getType());
        res.setDuration(activity.getDuration());
        res.setCaloriesBurn(activity.getCaloriesBurn());
        res.setStartTime(activity.getStartTime());
        res.setAdditionalMetrics(activity.getAdditionalMetrics());
        res.setCreatedAt(activity.getCreatedAt());
        res.setUpdatedAt(activity.getUpdatedAt());
        return res;
    }
}
