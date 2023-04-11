package com.cs411.bodywatchbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Activities")
@Getter
@Setter
@IdClass(ActivityId.class)
public class Activity {

    @Id
    @Column(name = "start_time", length = 20, nullable = false)
    private String startTime;

    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Id
    @Column(name = "exercise", length = 100, nullable = false)
    private String exercise;

    @Column(name = "end_time", length = 20, nullable = false)
    private String endTime;

    @Column(name = "date", length = 20, nullable = false)
    private String date;

    @Column(name = "calories_burned", nullable = false)
    private int caloriesBurned;

    @Column(name = "steps", nullable = false)
    private int steps;

    @Column(name = "avg_heart_rate", nullable = false)
    private int avgHeartRate;

}
