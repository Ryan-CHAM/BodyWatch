package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.Food;

import java.util.List;

/**
 * should Foods table contain CRUD? or only view foods
 */
public interface FoodService {

    List<Food> getAllFood();

    List<Food> getFoodByName(String prodName);

}
