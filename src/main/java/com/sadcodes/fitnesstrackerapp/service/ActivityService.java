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

    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public ActivityResponse trackActivity(ActivityRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User with id:" + request.getUserId() + " is not available"));

        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurn(request.getCaloriesBurn())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();
        Activity savedActivity = activityRepository.save(activity);
        return mapToResponse(savedActivity);
    }

    public List<ActivityResponse> trackActivity() {
        return activityRepository.findAll()
                .stream()
                .map((activity -> new ActivityResponse(activity.getId(), activity.getUser().getId(),
                        activity.getType(), activity.getAdditionalMetrics(), activity.getDuration()
                        , activity.getCaloriesBurn(), activity.getStartTime(), activity.getCreatedAt()
                        , activity.getUpdatedAt()
                ))).toList();

    }

    public ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUser().getId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurn(activity.getCaloriesBurn());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        return response;
    }


}
