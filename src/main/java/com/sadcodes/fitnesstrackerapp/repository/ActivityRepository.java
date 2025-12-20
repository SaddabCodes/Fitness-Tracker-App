package com.sadcodes.fitnesstrackerapp.repository;

import com.sadcodes.fitnesstrackerapp.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,String> {

    List<Activity> findByUserId(String userId);
}
