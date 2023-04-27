package com.cs411.bodywatchbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityId implements Serializable {

    private String startTime;

    private int userId;

    private String exercise;

}
