package com.codecool.seriesapp.controller;

import com.codecool.seriesapp.model.generated.EpisodesItem;
import com.codecool.seriesapp.model.generated.Series;
import com.codecool.seriesapp.service.SeriesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
@CrossOrigin("*")
public class SeriesController {

    @Autowired
    private SeriesApiService seriesApiService;

    @GetMapping("/{id}")
    public Series getSeriesById(@PathVariable("id") int id){
        return seriesApiService.getSeriesById(id);
    }

    @GetMapping("/{id}/episodes")
    public List<EpisodesItem> getSeriesEpisodesById(@PathVariable("id") int id){
        return seriesApiService
                .getSeriesById(id)
                .getEmbedded()
                .getEpisodes();
    }

}
