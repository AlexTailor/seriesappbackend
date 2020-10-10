package com.codecool.seriesapp.repository;

import com.codecool.seriesapp.model.entity.FavouriteSeries;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface FavouriteSeriesRepository extends JpaRepository<FavouriteSeries, Long> {

    boolean existsByShowId(int showId);

    List<FavouriteSeries> getFavouriteSeriesByMember_Id(Long memberId);
}
