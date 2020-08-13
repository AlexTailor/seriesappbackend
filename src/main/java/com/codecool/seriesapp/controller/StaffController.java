package com.codecool.seriesapp.controller;

import com.codecool.seriesapp.model.generated.Series;
import com.codecool.seriesapp.model.generated.people.People;
import com.codecool.seriesapp.service.PeopleSearchApi;
import com.codecool.seriesapp.service.SeriesApiService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/staff")
@CrossOrigin("*")
public class StaffController {

    @Autowired
    SeriesApiService seriesApiService;

    @Autowired
    PeopleSearchApi peopleSearchApi;


    @GetMapping()
    public List<People> getStaff() {
        List<People> persons = new ArrayList<>();
        int i = 1;
        while (i < 49) {
            String str = String.valueOf(i);
            persons.add(seriesApiService.getPeopleById(str));
            i++;
        }
        return persons;
    }

    @GetMapping("/{id}")
    public People getStaffById(@PathVariable("id") String id) {
        return seriesApiService.getPeopleById(id);
    }


    @GetMapping("/search/{name}")
    public String getStaffByName(@PathVariable("name") String name) throws IOException, JSONException {
        return peopleSearchApi.getPeople(name);
    }

    @GetMapping("/castcredit/{id}")
    public String getCastCredit(@PathVariable("id") String id) throws IOException {
        return peopleSearchApi.getCastCredit(id);
    }

}
