package com.codecool.seriesapp.repository;

import com.codecool.seriesapp.model.entity.FavouriteSeries;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FavouriteSeriesRepository extends JpaRepository<FavouriteSeries, Long> {

    boolean existsByShowId(int showId);

}
