package com.codecool.seriesapp.repository;

import com.codecool.seriesapp.model.entity.FavouriteSeries;
import com.codecool.seriesapp.model.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AllRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void saveUserWithFavouriteSeries() {
        FavouriteSeries teszt = FavouriteSeries.builder()
                .showId(5)
                .build();

        Member alex = Member.builder()
                .username("Alex")
                .series(teszt)
                .build();

        teszt.setMember(alex);
        memberRepository.save(alex);

        List<Member> members = memberRepository.findAll();
        assertThat(members).hasSize(1);
    }

}