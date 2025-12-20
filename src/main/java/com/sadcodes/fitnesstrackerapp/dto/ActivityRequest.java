package com.sadcodes.fitnesstrackerapp.dto;

import com.sadcodes.fitnesstrackerapp.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {

    private String userId;
    private ActivityType type;
    private Map<String, Object> additionalMetrics;
    private Integer duration;
    private Integer caloriesBurn;
    private LocalDateTime startTime;
}
