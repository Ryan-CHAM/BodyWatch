package com.cs411.bodywatchbackend.repository;

import com.cs411.bodywatchbackend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT id FROM Users", nativeQuery = true)
    List<Integer> findAllUserId();

}