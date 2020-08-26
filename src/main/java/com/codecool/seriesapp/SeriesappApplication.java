package com.codecool.seriesapp;

import com.codecool.seriesapp.model.entity.FavouriteSeries;
import com.codecool.seriesapp.model.entity.User;
import com.codecool.seriesapp.repository.FavouriteSeriesRepository;
import com.codecool.seriesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeriesappApplication {

    @Autowired
    FavouriteSeriesRepository favouriteSeriesRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SeriesappApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            FavouriteSeries teszt = FavouriteSeries.builder()
                    .showId(5)
                    .build();

            User alex = User.builder()
                    .username("Alex")
                    .series(teszt)
                    .build();

            teszt.setUser(alex);
            userRepository.save(alex);


        };
    }

}
