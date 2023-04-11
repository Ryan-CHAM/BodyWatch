package com.cs411.bodywatchbackend.repository;

import com.cs411.bodywatchbackend.model.Activity;
import com.cs411.bodywatchbackend.model.ActivityId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ActivityRepository extends JpaRepository<Activity, ActivityId> {

    @Query(value = "SELECT * FROM Activities WHERE user_id = ?1", nativeQuery = true)
    List<Activity> findAllActivityByUserId(int userId);

}
