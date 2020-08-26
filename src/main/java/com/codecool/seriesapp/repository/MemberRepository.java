package com.codecool.seriesapp.repository;

import com.codecool.seriesapp.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
