package com.codecool.seriesapp.repository;

import com.codecool.seriesapp.model.entity.VotedSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VotedSeriesRepository extends JpaRepository<VotedSeries, Long> {

    boolean existsByShowId(int showId);

    @Transactional
    @Modifying
    @Query("UPDATE VotedSeries v SET v.seriesRating = (v.seriesRating + :num) WHERE v.showId = :showId")
    void setSeriesRating(@Param("showId") int showId, @Param("num") double num);

    @Query("select v.seriesRating from VotedSeries v where v.showId = :showId")
    double getSeriesRatingByShowId(@Param("showId") int showId);

}
