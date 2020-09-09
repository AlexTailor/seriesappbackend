package com.codecool.seriesapp.service;

import com.codecool.seriesapp.model.entity.FavouriteSeries;
import com.codecool.seriesapp.model.generated.EpisodesItem;
import com.codecool.seriesapp.model.generated.Series;
import com.codecool.seriesapp.model.generated.people.People;
import com.codecool.seriesapp.repository.FavouriteSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesApiService {

    @Autowired
    RemoteURLReader remoteURLReader;

    @Autowired
    FavouriteSeriesRepository favouriteSeriesRepository;

    public Series[] getSeries() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Series[]> seriesResponseEntity =
                template.getForEntity("http://api.tvmaze.com/shows", Series[].class);
        return seriesResponseEntity.getBody();
    }

    public String getSeasonsBySeriesId(String id) throws IOException {
        String url = "http://api.tvmaze.com/shows/" + id + "/seasons";
        String result = remoteURLReader.readFromUrl(url);
        return result;
    }


    public Series getSeriesById(String id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Series> seriesResponseEntity = template.exchange("http://api.tvmaze.com/shows/" + id + "?embed[]=episodes&embed[]=cast", HttpMethod.GET, null, Series.class);
        return seriesResponseEntity.getBody();
    }

    public List<EpisodesItem> getSeriesEpisodesById(String id) {
        List<EpisodesItem> episodes = getSeriesById(id)
                .getEmbedded()
                .getEpisodes();
        return episodes;
    }

    public List<EpisodesItem> getEpisodesBySeasonNum(String id, String num) {
        List<EpisodesItem> episodeOfTheGivenSeason = new ArrayList<>();
        List<EpisodesItem> episodes = getSeriesById(id)
                .getEmbedded()
                .getEpisodes();
        for (EpisodesItem episode : episodes) {
            if (Integer.parseInt(num) == episode.getSeason()) {
                episodeOfTheGivenSeason.add(episode);
            }
        }
        return episodeOfTheGivenSeason;
    }

    public People getPeopleById(String id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<People> seriesResponseEntity = template.exchange("http://api.tvmaze.com/people/" + id, HttpMethod.GET, null, People.class);
        return seriesResponseEntity.getBody();
    }

    public List<Series> searchSeries(String value) {
        List<Series> searchedSeries = new ArrayList<>();
        Series[] allSeries = getSeries();
        for (Series series : allSeries) {
            if (series.getName().contains(value)) {
                searchedSeries.add(series);
            }
        }
        return searchedSeries;
    }

    public List<Series> getFavouriteSeries(Long id) {
        List<FavouriteSeries> favouriteSeries = favouriteSeriesRepository.getFavouriteSeriesByMember_Id(id);
        List<Series> result = new ArrayList<>();
        for (FavouriteSeries series : favouriteSeries) {
            result.add(getSeriesById(String.valueOf(series.getShowId())));
        }
        return result;

    }

}
