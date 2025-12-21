package com.sadcodes.fitnesstrackerapp.controller;

import com.sadcodes.fitnesstrackerapp.dto.RecommendationRequest;
import com.sadcodes.fitnesstrackerapp.model.Recommendation;
import com.sadcodes.fitnesstrackerapp.service.RecommendationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;

    }

    @PostMapping
    public ResponseEntity<Recommendation> generateRecommendation(@RequestBody RecommendationRequest request) {
        Recommendation recommendation = recommendationService.generateRecommendation(request);
        return new ResponseEntity<>(recommendation, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userId){
        return new ResponseEntity<>(recommendationService.getUserRecommendation(userId),HttpStatus.OK);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(@PathVariable String activityId){
        return new ResponseEntity<>(recommendationService.getActivityRecommendation(activityId),HttpStatus.OK);
    }

}
