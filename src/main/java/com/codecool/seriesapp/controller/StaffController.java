package com.codecool.seriesapp.controller;

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

    int start;
    int end;

    @Autowired
    SeriesApiService seriesApiService;

    @Autowired
    PeopleSearchApi peopleSearchApi;


    @GetMapping("/page/{page}")
    public List<People> getStaff(@PathVariable("page") String page) {
        List<People> persons = new ArrayList<>();
        if (page.equals("first")) {
            start = 1;
            end = 24;
        } else if (page.equals("next")) {
            end = start + 23;
        } else if (page.equals("prev") && start > 25) {
            start = start - 48;
            end = start + 23;
        } else if (page.equals("prev") && start == 25) {
            start = 1;
            end = 24;
        }
        while (start <= end) {
            String str = String.valueOf(start);
            persons.add(seriesApiService.getPeopleById(str));
            start++;
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
