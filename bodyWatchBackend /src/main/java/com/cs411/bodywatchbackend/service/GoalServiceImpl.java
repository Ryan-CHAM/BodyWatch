package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.*;
import com.cs411.bodywatchbackend.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Override
    public void createGoal(Goal goal) {
        goalRepository.save(goal);
    }

    @Override
    public void updateGoal(Goal goal) {

        Optional<Goal> goalsDb = goalRepository.findById(
                new GoalId(goal.getUserId(), goal.getTimeline())
        );

        if (goalsDb.isPresent()) {
            goalRepository.save(goal);
        }
        else {
            throw new ResourceNotFoundException(
                    "Goal not found with user id: " + goal.getUserId() + ",  timeline: " + goal.getTimeline()
            );
        }
    }

    @Override
    public void deleteGoal(GoalId id) {

        Optional<Goal> goalsDb = goalRepository.findById(id);

        if (goalsDb.isPresent()) {
            goalRepository.delete(goalsDb.get());
        }
        else {
            throw new ResourceNotFoundException(
                    "Goal not found with user id: " + id.getUserId() + ",  timeline: " + id.getTimeline()
            );
        }
    }

    @Override
    public List<Goal> getAllGoalByUserId(Integer userId) {
        return goalRepository.findAllGoalByUserId(userId);
    }

}
