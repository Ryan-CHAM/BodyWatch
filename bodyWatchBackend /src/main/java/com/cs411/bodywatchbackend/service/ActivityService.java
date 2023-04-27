package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.Activity;
import com.cs411.bodywatchbackend.model.ActivityId;

import java.util.List;

public interface ActivityService {

    void createActivity(Activity activity);

    void updateActivity(Activity activity);

    List<Activity> getAllActivityByUserId(int userId);

    void deleteActivity(ActivityId id);

    List<List<Integer>> createLeaderboard();

}
