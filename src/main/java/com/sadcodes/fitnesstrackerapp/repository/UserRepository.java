package com.sadcodes.fitnesstrackerapp.repository;

import com.sadcodes.fitnesstrackerapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
