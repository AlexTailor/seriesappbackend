package com.codecool.seriesapp.controller;

import com.codecool.seriesapp.model.entity.FavouriteSeries;
import com.codecool.seriesapp.model.entity.VotedSeries;
import com.codecool.seriesapp.model.generated.CastItem;
import com.codecool.seriesapp.model.generated.EpisodesItem;
import com.codecool.seriesapp.model.generated.Series;
import com.codecool.seriesapp.repository.FavouriteSeriesRepository;
import com.codecool.seriesapp.repository.MemberRepository;
import com.codecool.seriesapp.repository.VotedSeriesRepository;
import com.codecool.seriesapp.security.JwtTokenFilter;
import com.codecool.seriesapp.service.SeriesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.codecool.seriesapp.service.VotedSeriesService.round;

@RestController
@RequestMapping("/shows")
@CrossOrigin("*")
public class SeriesController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    private FavouriteSeriesRepository favouriteSeriesRepository;

    @Autowired
    private SeriesApiService seriesApiService;

    @Autowired
    private VotedSeriesRepository votedSeriesRepository;

    @GetMapping
    public Series[] getSeries() {
        return seriesApiService.getSeries();
    }

    @GetMapping("/searchresult/{value}")
    public List<Series> getSeries(@PathVariable("value") String value) {
        return seriesApiService.searchSeries(value);
    }


    @GetMapping("/{id}")
    public Series getSeriesById(@PathVariable("id") String id) {
        return seriesApiService.getSeriesById(id);
    }

    @GetMapping("/{id}/episodes")
    public List<EpisodesItem> getSeriesEpisodesById(@PathVariable("id") String id) {
        return seriesApiService.getSeriesEpisodesById(id);
    }

    @GetMapping("/{id}/season/{num}/episode")
    public List<EpisodesItem> getEpisodesByTheGivenSeasonNum(@PathVariable String id, @PathVariable String num) {
        return seriesApiService.getEpisodesBySeasonNum(id, num);
    }

    @GetMapping("/{id}/staff")
    public List<CastItem> getStaffbyId(@PathVariable("id") String id) {
        return seriesApiService.getSeriesById(id).getEmbedded().getCast();
    }

    @PostMapping("/firstPost")
    public void getFirstPost(@RequestBody FavouriteSeries id) {
        if (jwtTokenFilter.getAuth() != null) {
            Long memberId  = memberRepository.getMemberIdByUserName(jwtTokenFilter.getAuth().getPrincipal().toString());

            if (!favouriteSeriesRepository.existsByShowId(id.getShowId())) {
                id.setMember(memberRepository.getOne(memberId));
                favouriteSeriesRepository.saveAndFlush(id);
            }
        }
    }

    @GetMapping("/favourites")
    public List<Series> getFavouriteSeries() {
        if (jwtTokenFilter.getAuth() != null) {
            Long id  = memberRepository.getMemberIdByUserName(jwtTokenFilter.getAuth().getPrincipal().toString());
            return seriesApiService.getFavouriteSeries(id);
        }
       return Arrays.asList(seriesApiService.getSeries());
    }

    @GetMapping("/{id}/season")
    public String getSeasonsByShowId(@PathVariable("id") String id) throws IOException {
        return seriesApiService.getSeasonsBySeriesId(id);
    }

    @PostMapping("/vote/{vote}")
    public double updateVotes(@PathVariable("vote") String vote, @RequestBody VotedSeries votedSeries) {
        if (!votedSeriesRepository.existsByShowId(votedSeries.getShowId())) votedSeriesRepository.save(votedSeries);
        if (vote.equals("up")) votedSeriesRepository.setSeriesRating(votedSeries.getShowId(), 0.1);
        if (vote.equals("down")) votedSeriesRepository.setSeriesRating(votedSeries.getShowId(), -0.1);
        return round(votedSeriesRepository.getSeriesRatingByShowId(votedSeries.getShowId()),1);
    }


}
