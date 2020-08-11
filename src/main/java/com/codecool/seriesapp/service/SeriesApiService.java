package com.codecool.seriesapp.service;

import com.codecool.seriesapp.model.generated.Series;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SeriesApiService {

    public Series getSeriesById(String id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Series> seriesResponseEntity = template.exchange("http://api.tvmaze.com/shows/" + id + "?embed[]=episodes&embed[]=cast", HttpMethod.GET, null, Series.class);
        return seriesResponseEntity.getBody();
    }


}
