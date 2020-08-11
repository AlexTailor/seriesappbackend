package com.codecool.seriesapp.service;

import com.codecool.seriesapp.model.RemoteURLReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SeriesApiService {
    RemoteURLReader remoteURLReader;

    public SeriesApiService(RemoteURLReader remoteURLReader) {
        this.remoteURLReader = remoteURLReader;
    }

    private final String apiPath = "http://api.tvmaze.com/shows";

    public JSONObject getDataFromApi() throws JSONException, IOException {
        String url = apiPath;
        String result = remoteURLReader.readFromUrl(url);
        JSONObject json = new JSONObject(result);
        return json;
    }

}
