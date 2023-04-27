package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.Goal;
import com.cs411.bodywatchbackend.model.GoalId;

import java.util.List;

public interface GoalService {

    void createGoal(Goal goal);

    void updateGoal(Goal goal);

    void deleteGoal(GoalId id);

    List<Goal> getAllGoalByUserId(Integer userId);

}
