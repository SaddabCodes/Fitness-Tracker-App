package com.sadcodes.fitnesstrackerapp.controller;

import com.sadcodes.fitnesstrackerapp.dto.ActivityRequest;
import com.sadcodes.fitnesstrackerapp.dto.ActivityResponse;
import com.sadcodes.fitnesstrackerapp.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request) {
        return new ResponseEntity<>(activityService.trackActivity(request), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader(value = "X-User-ID") String userId) {
        return new ResponseEntity<>(activityService.getUserActivities(userId), HttpStatus.OK);
    }


}
