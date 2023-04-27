package com.cs411.bodywatchbackend.repository;

import com.cs411.bodywatchbackend.model.Goal;
import com.cs411.bodywatchbackend.model.Activity;
import com.cs411.bodywatchbackend.model.ActivityId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface Leaderboard extends JpaRepository<Activity, ActivityId> {
    @Query(value = "SELECT user_id, SUM(calories_burned) " +
            "FROM Goals LEFT JOIN Activities USING (user_id) " +
            "WHERE Goals.timeline LIKE \"%Daily\" " +
            "GROUP BY user_id " +
            "ORDER BY SUM(calories_burned) DESC LIMIT 10;", nativeQuery = true)
    List<List<Integer>> createLeaderboard();
}
