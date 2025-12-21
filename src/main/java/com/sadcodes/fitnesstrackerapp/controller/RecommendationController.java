package com.sadcodes.fitnesstrackerapp.controller;

import com.sadcodes.fitnesstrackerapp.dto.RecommendationRequest;
import com.sadcodes.fitnesstrackerapp.model.Recommendation;
import com.sadcodes.fitnesstrackerapp.service.RecommendationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
