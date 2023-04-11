package com.cs411.bodywatchbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Health")
@Getter
@Setter
@IdClass(HealthId.class)
public class Health {

    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "calories_burned", nullable = false)
    private int calories_burned;

    @Column(name = "steps", nullable = false)
    private int steps;

    @Id
    @Column(name = "date", length = 50, nullable = false)
    private String date;

    @Column(name = "avg_heart_rate", nullable = false)
    private int avgHeartRate;

}
