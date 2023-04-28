package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.Health;
import com.cs411.bodywatchbackend.model.HealthId;
import com.cs411.bodywatchbackend.repository.HealthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HealthServiceImpl implements HealthService{

    @Autowired
    private HealthRepository healthRepository;

    @Override
    public void createHealth(Health health) {
        healthRepository.save(health);
    }

    @Override
    public void updateHealth(Health health) {

        Optional<Health> healthDb = healthRepository.findById(
                new HealthId(health.getUserId(), health.getDate())
        );

        if (healthDb.isPresent()) {
            healthRepository.save(health);
        }
        else {
            throw new ResourceNotFoundException(
                    "Health not found with user id: " + health.getUserId() + ", date: " + health.getDate()
            );
        }
    }

    @Override
    public void deleteHealth(HealthId id) {

        Optional<Health> healthDb = healthRepository.findById(id);

        if (healthDb.isPresent()) {
            healthRepository.delete(healthDb.get());
        }
        else {
            throw new ResourceNotFoundException(
                    "Health not found with user id: " + id.getUserId() + ", date: " + id.getDate()
            );
        }
    }

    @Override
    public List<Health> getAllHealthByUserId(Integer userId) {
        return healthRepository.findAllHealthByUserId(userId);
    }

    @Override
    public int getRanking(int user_id, String date) {
        return healthRepository.getRanking(user_id, date);
    }

}
