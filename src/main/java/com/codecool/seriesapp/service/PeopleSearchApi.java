package com.codecool.seriesapp.service;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PeopleSearchApi {

    @Autowired
    RemoteURLReader remoteURLReader;

    public String getPeople(String name) throws IOException, JSONException {
        String url = "http://api.tvmaze.com/search/people?q=" + name;
        String result = remoteURLReader.readFromUrl(url);
        return result;
    }

    public String getCastCredit(String id) throws IOException {
        String url = "http://api.tvmaze.com/people/" + id + "/castcredits?embed=show";
        String result = remoteURLReader.readFromUrl(url);
        return result;
    }
}
