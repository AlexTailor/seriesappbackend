package com.codecool.seriesapp.controller;

import com.codecool.seriesapp.model.generated.CastItem;
import com.codecool.seriesapp.model.generated.EpisodesItem;
import com.codecool.seriesapp.model.generated.Person;
import com.codecool.seriesapp.model.generated.Series;
import com.codecool.seriesapp.model.generated.people.People;
import com.codecool.seriesapp.service.PeopleSearchApi;
import com.codecool.seriesapp.service.SeriesApiService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/shows")
@CrossOrigin("*")
public class SeriesController {

    @Autowired
    private SeriesApiService seriesApiService;

    @Autowired
    private PeopleSearchApi peopleSearchApi;

    @GetMapping
    public Series[] getSeries() {
        return seriesApiService.getSeries();
    }

    @GetMapping("/searchresult/{value}")
    public List<Series> getSeries(@PathVariable("value") String value) {
        List<Series> searchedSeries = new ArrayList<Series>();
        Series[] allSeries = seriesApiService.getSeries();
        for (Series series : allSeries) {
            if (series.getName().contains(value)) {
                searchedSeries.add(series);
            }
        }
        return searchedSeries;
    }


    @GetMapping("/{id}")
    public Series getSeriesById(@PathVariable("id") String id) {
        return seriesApiService.getSeriesById(id);
    }

    @GetMapping("/{id}/episodes")
    public List<EpisodesItem> getSeriesEpisodesById(@PathVariable("id") String id) {
        List<EpisodesItem> episodes = seriesApiService
                .getSeriesById(id)
                .getEmbedded()
                .getEpisodes();
        return episodes;
    }

    @GetMapping("/{id}/season/{num}/episode")
    public List<EpisodesItem> getEpisodesByTheGivenSeasonNum(@PathVariable String id, @PathVariable String num) {
        List<EpisodesItem> episodeOfTheGivenSeason = new ArrayList<>();
        List<EpisodesItem> episodes = seriesApiService
                .getSeriesById(id)
                .getEmbedded()
                .getEpisodes();
        for (EpisodesItem episode: episodes) {
            if (Integer.parseInt(num) == episode.getSeason()) {
                episodeOfTheGivenSeason.add(episode);
            }
        }
        return episodeOfTheGivenSeason;
    }

    @GetMapping("/{id}/staff")
    public List<CastItem> getStaffbyId(@PathVariable("id") String id) {
        return seriesApiService.getSeriesById(id).getEmbedded().getCast();
    }

    @GetMapping("/{id}/season")
    public String getSeaonsByShowId(@PathVariable("id") String id) throws IOException {
        return peopleSearchApi.getSeasonsBySeriesId(id);
    }


}
