package com.cs411.bodywatchbackend.controller;

import com.cs411.bodywatchbackend.model.Activity;
import com.cs411.bodywatchbackend.model.ActivityId;
import com.cs411.bodywatchbackend.model.Food;
import com.cs411.bodywatchbackend.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/activities/{userId}")
    public ResponseEntity<List<Activity>> getAllActivityByUserId(@PathVariable int userId) {
        return ResponseEntity.ok().body(activityService.getAllActivityByUserId(userId));
    }

    @PostMapping("/activities")
    public HttpStatus createActivity(@RequestBody Activity activity) {
        activityService.createActivity(activity);
        return HttpStatus.OK;
    }

    @PutMapping("/activities/{startTime}&{userId}&{exercise}")
    public HttpStatus updateActivity(@PathVariable String startTime,
                                     @PathVariable int userId,
                                     @PathVariable String exercise,
                                     @RequestBody Activity activity) {
        if (!activity.getStartTime().equals(startTime)
                || activity.getUserId() != userId
                || !activity.getExercise().equals(exercise)) {
            return HttpStatus.BAD_REQUEST;
        }
        else {
            activityService.updateActivity(activity);
            return HttpStatus.OK;
        }
    }

    @DeleteMapping("/activities/{startTime}&{userId}&{exercise}")
    public HttpStatus deleteActivity(@PathVariable String startTime,
                                     @PathVariable int userId,
                                     @PathVariable String exercise) {
        activityService.deleteActivity(new ActivityId(startTime, userId, exercise));
        return HttpStatus.OK;
    }

    @GetMapping("/activities/leaderboard")
    public ResponseEntity<List<List<Integer>>> createLeaderboard() {
        return ResponseEntity.ok().body(activityService.createLeaderboard());
    }

}
