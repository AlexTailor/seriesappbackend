package com.codecool.seriesapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class VotedSeries {

    @Id
    @GeneratedValue
    private long id;

    private int showId;

    @Transient
    private double resultRating;

    private double seriesRating;

    public void calculateResultRating(double number) {
        resultRating = seriesRating + number;
    }

    public double getDifference() {
        return resultRating - seriesRating;
    }
}
