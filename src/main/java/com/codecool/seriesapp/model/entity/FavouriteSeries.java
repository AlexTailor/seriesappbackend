package com.codecool.seriesapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FavouriteSeries {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false , unique = true)
    private int showId;
}
