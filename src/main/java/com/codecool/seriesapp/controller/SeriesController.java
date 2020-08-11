package com.codecool.seriesapp.controller;

import com.codecool.seriesapp.service.SeriesApiService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/shows")
@CrossOrigin("*")
public class SeriesController {

    @Autowired
    SeriesApiService seriesApiService;

    @GetMapping
    public String isSeries() throws IOException, JSONException {
        return seriesApiService.getDataFromApi();
    }
}
