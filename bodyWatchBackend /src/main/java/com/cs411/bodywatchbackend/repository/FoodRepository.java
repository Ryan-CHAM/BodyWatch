package com.cs411.bodywatchbackend.repository;

import com.cs411.bodywatchbackend.model.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query(value = "SELECT * FROM Foods LIMIT 200", nativeQuery = true)
    List<Food> findAllFood();

    @Query(value = "SELECT * FROM Foods WHERE ProdName = ?1", nativeQuery = true)
    List<Food> findFoodByName(String prodName);

}