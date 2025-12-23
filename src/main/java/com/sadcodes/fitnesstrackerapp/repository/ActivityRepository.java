package com.sadcodes.fitnesstrackerapp.repository;

import com.sadcodes.fitnesstrackerapp.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, String> {

    // FIX: use nested property
    List<Activity> findByUser_Id(String userId);
}
