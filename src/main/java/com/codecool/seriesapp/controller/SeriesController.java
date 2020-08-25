package com.codecool.seriesapp.controller;

import com.codecool.seriesapp.model.generated.CastItem;
import com.codecool.seriesapp.model.generated.EpisodesItem;
import com.codecool.seriesapp.model.generated.Series;
import com.codecool.seriesapp.service.SeriesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/shows")
@CrossOrigin("*")
public class SeriesController {

    @Autowired
    private SeriesApiService seriesApiService;

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
    public void getFirstPost(@RequestBody String id) {
        System.out.println(id);
    }

    @GetMapping("/{id}/season")
    public String getSeasonsByShowId(@PathVariable("id") String id) throws IOException {
        return seriesApiService.getSeasonsBySeriesId(id);
    }


}
