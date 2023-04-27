package com.cs411.bodywatchbackend.controller;

import com.cs411.bodywatchbackend.model.Goal;
import com.cs411.bodywatchbackend.model.GoalId;
import com.cs411.bodywatchbackend.service.GoalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping("/goals/{userId}")
    public ResponseEntity<List<Goal>> getAllGoalByUserId(@PathVariable int userId){
        return ResponseEntity.ok().body(goalService.getAllGoalByUserId(userId));
    }

    @PostMapping("/goals")
    public HttpStatus createGoal(@RequestBody Goal goal) {
        goalService.createGoal(goal);
        return HttpStatus.OK;
    }

    @PutMapping("/goals/{userId}&{timeline}")
    public HttpStatus updateGoal(@PathVariable int userId,
                                 @PathVariable String timeline,
                                 @RequestBody Goal goal){
        if (goal.getUserId() != userId || !goal.getTimeline().equals(timeline)) {
            return HttpStatus.BAD_REQUEST;
        }
        else {
            goalService.updateGoal(goal);
            return HttpStatus.OK;
        }
    }

    @DeleteMapping("/goals/{userId}&{timeline}")
    public HttpStatus deleteGoal(@PathVariable int userId, @PathVariable String timeline){
        goalService.deleteGoal(new GoalId(userId, timeline));
        return HttpStatus.OK;
    }

}
