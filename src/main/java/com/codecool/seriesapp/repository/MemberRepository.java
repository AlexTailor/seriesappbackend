package com.codecool.seriesapp.repository;

import com.codecool.seriesapp.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    @Query("select m.id from Member m where m.username = :username")
    Long getMemberIdByUserName(@Param("username") String username);
}
