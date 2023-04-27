package com.cs411.bodywatchbackend.repository;

import com.cs411.bodywatchbackend.model.Health;
import com.cs411.bodywatchbackend.model.HealthId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface HealthRepository extends JpaRepository<Health, HealthId> {

    @Query(value = "SELECT * FROM Health WHERE user_id = ?1", nativeQuery = true)
    List<Health> findAllHealthByUserId(int userId);

}