package com.cs411.bodywatchbackend.repository;

import com.cs411.bodywatchbackend.model.Food;
import com.cs411.bodywatchbackend.model.Activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface FoodSuggestions extends JpaRepository<Food, Integer> {

    @Query(value = "SELECT * FROM (SELECT IFNULL(GenericName, ProdName) as FoodName, " +
            "IFNULL(ServSize, Quantity) as ServingSize, Energy100g FROM Foods " +
            "WHERE Energy100g < " +
            "((" +
            "SELECT SUM(calories_burned) " +
            "FROM Activities " +
            "WHERE Date LIKE \"%06/09/2022%\" GROUP BY user_id " +
            "HAVING user_id = 1 " +          //need to get the user id of the person currently logged in
            ") " +
            "-" +
            " (" +
            "SELECT calories_goal " +
            "FROM Goals " +
            "WHERE Goals.timeline LIKE \"%Daily%\" AND user_id = 1 " +   //also need to get user id of person currently logged in
            "))) " +
            "AS temp " +
            "WHERE temp.FoodName IS NOT NULL AND temp.FoodName != \"\" " +
            ";", nativeQuery = true)
    List<List<String>> suggestFood();
}
