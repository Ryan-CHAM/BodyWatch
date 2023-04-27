package com.cs411.bodywatchbackend.controller;

import com.cs411.bodywatchbackend.model.Food;
import com.cs411.bodywatchbackend.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/foods")
    public ResponseEntity<List<Food>> getAllFood() {
        return ResponseEntity.ok().body(foodService.getAllFood());
    }

    @GetMapping("/foods/{prodName}")
    public ResponseEntity<List<Food>> getFoodByName(@PathVariable String prodName) {
        return ResponseEntity.ok().body(foodService.getFoodByName(prodName));
    }

    @GetMapping("/foods/suggestion")
    public ResponseEntity<List<List<String>>> getFoodSuggestion() {
        return ResponseEntity.ok().body(foodService.suggestFood());
    }

}

