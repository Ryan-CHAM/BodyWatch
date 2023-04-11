package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.Activity;
import com.cs411.bodywatchbackend.model.ActivityId;
import com.cs411.bodywatchbackend.repository.ActivityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void createActivity(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public void updateActivity(Activity activity) {

        Optional<Activity> activityDb = activityRepository.findById(
                new ActivityId(activity.getStartTime(), activity.getUserId(), activity.getExercise())
        );

        if (activityDb.isPresent()) {
            activityRepository.save(activity);
        }
        else {
            throw new ResourceNotFoundException(
                    "Activity not found with user id: " + activity.getUserId() +
                            ", start time: " + activity.getStartTime() +
                            ", exercise: " + activity.getExercise()
            );
        }
    }

    @Override
    public List<Activity> getAllActivityByUserId(int userId) {
        return activityRepository.findAllActivityByUserId(userId);
    }

    @Override
    public void deleteActivity(ActivityId id) {

        Optional<Activity> activityDb = activityRepository.findById(id);

        if (activityDb.isPresent()) {
            activityRepository.delete(activityDb.get());
        }
        else {
            throw new ResourceNotFoundException(
                    "Activity not found with user id: " + id.getUserId() +
                            ", start time: " + id.getStartTime() +
                            ", exercise: " + id.getExercise()
            );
        }
    }

}
