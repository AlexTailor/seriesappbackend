package com.codecool.seriesapp.repository;

import com.codecool.seriesapp.model.entity.FavouriteSeries;
import com.codecool.seriesapp.model.entity.Member;
import com.codecool.seriesapp.model.entity.VotedSeries;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AllRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    VotedSeriesRepository votedSeriesRepository;

    @Autowired
    FavouriteSeriesRepository favouriteSeriesRepository;


    @Test
    public void saveMember() {
        Member csaba = Member.builder()
                .birthDate(LocalDate.of(2000, 6, 15))
                .email("szabbo87@gmail.com")
                .username("Csaba")
                .build();
        memberRepository.save(csaba);
        assertThat(memberRepository.findAll()).hasSize(1);
        memberRepository.delete(csaba);
    }

    @Test
    public void saveFavouriteSeries() {
        FavouriteSeries series = FavouriteSeries.builder()
                .showId(11)
                .build();
        favouriteSeriesRepository.save(series);
        assertThat(favouriteSeriesRepository.findAll()).hasSize(1);
        favouriteSeriesRepository.delete(series);
    }

    @Test
    public void saveMemberWithFavouriteSeries() {
        FavouriteSeries teszt = FavouriteSeries.builder()
                .showId(5)
                .build();

        Member alex = Member.builder()
                .username("Alex")
                .series(teszt)
                .build();

//        teszt.setMember(alex);
        memberRepository.save(alex);

        List<Member> members = memberRepository.findAll();
        assertThat(members).hasSize(1);
        memberRepository.delete(alex);
    }

    @Test
    public void saveVotedSeries() {
        VotedSeries votedSeries = VotedSeries.builder().showId(5).seriesRating(9.1).build();
        votedSeriesRepository.save(votedSeries);
        assertThat(votedSeriesRepository.findAll()).hasSize(1);

    }

    @Test
    public void setVotedSeriesRating() {
        VotedSeries votedSeries = VotedSeries.builder().showId(1).seriesRating(7.0).build();
        votedSeriesRepository.save(votedSeries);
        votedSeriesRepository.setSeriesRating(1, 0.1);
        assertThat(votedSeriesRepository.getSeriesRatingByShowId(1)).isEqualTo(7.1);

    }

    @Test
    public void saveUniqueFieldTwice() {
        FavouriteSeries series1 = FavouriteSeries.builder()
                .showId(10)
                .build();

        favouriteSeriesRepository.saveAndFlush(series1);
        FavouriteSeries series2 = FavouriteSeries.builder()
                .showId(10)
                .build();

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            favouriteSeriesRepository.saveAndFlush(series2);
        });
        favouriteSeriesRepository.delete(series1);
        favouriteSeriesRepository.delete(series2);
    }

    @Test
    public void memberIsPeristedWithFavouriteSeries() {
        FavouriteSeries fav = FavouriteSeries.builder()
                .showId(100)
                .build();

        Member member = Member.builder()
                .username("Joci")
                .series(fav)
                .build();

        memberRepository.saveAndFlush(member);

        List<FavouriteSeries> favs = favouriteSeriesRepository.findAll();
        assertThat(favs)
                .hasSize(1)
                .allMatch(fav1 -> fav1.getId() > 0L);
        memberRepository.delete(member);
        favouriteSeriesRepository.delete(fav);
    }
}