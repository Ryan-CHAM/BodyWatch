package com.cs411.bodywatchbackend.repository;

import com.cs411.bodywatchbackend.model.Goal;
import com.cs411.bodywatchbackend.model.GoalId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface GoalRepository extends JpaRepository<Goal, GoalId> {

    @Query(value = "SELECT * FROM Goals WHERE user_id = ?1", nativeQuery = true)
    List<Goal> findAllGoalByUserId(int userId);

}