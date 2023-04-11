package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.*;

import java.util.List;

public interface HealthService{

    void createHealth(Health health);

    void updateHealth(Health health);

    void deleteHealth(HealthId id);

    List<Health> getAllHealthByUserId(Integer userId);

}
