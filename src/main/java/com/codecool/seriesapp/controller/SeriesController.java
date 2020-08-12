package com.codecool.seriesapp.controller;

import com.codecool.seriesapp.model.generated.CastItem;
import com.codecool.seriesapp.model.generated.EpisodesItem;
import com.codecool.seriesapp.model.generated.Person;
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

    @GetMapping
    public Series[] getSeries(){
        return seriesApiService.getSeries();
    }

    @GetMapping("/{id}")
    public Series getSeriesById(@PathVariable("id")  String id){
        return seriesApiService.getSeriesById(id);
    }

    @GetMapping("/{id}/episodes")
    public List<EpisodesItem> getSeriesEpisodesById(@PathVariable("id") String id){
        return seriesApiService
                .getSeriesById(id)
                .getEmbedded()
                .getEpisodes();
    }

    @GetMapping("/{id}/staff")
    public List<CastItem> getStaffbyId(@PathVariable("id") String id){
        return seriesApiService.getSeriesById(id).getEmbedded().getCast();
    }

}
