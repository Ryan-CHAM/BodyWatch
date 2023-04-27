package com.cs411.bodywatchbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Goals")
@Getter
@Setter
@IdClass(GoalId.class)
public class Goal {

    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Id
    @Column(name = "timeline", length = 20, nullable = false)
    private String timeline;

    @Column(name = "calories_goal", nullable = false)
    private int caloriesGoal;

    @Column(name = "steps_goal",  nullable = false)
    private int stepsGoal;

    @Column(name = "weight_goal",  nullable = false)
    private int weightGoal;

    @Column(name = "protein_goal", nullable = false)
    private int proteinGoal;

    @Column(name = "carb_goal", nullable = false)
    private int carbGoal;

    @Column(name = "fat_goal", nullable = false)
    private int fatGoal;

}
