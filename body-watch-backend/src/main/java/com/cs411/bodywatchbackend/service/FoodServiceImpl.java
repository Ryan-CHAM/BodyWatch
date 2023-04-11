package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.Food;
import com.cs411.bodywatchbackend.repository.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> getAllFood() {
        return foodRepository.findAllFood();
    }

    @Override
    public List<Food> getFoodByName(String prodName) {
        return foodRepository.findFoodByName(prodName);
    }
}
