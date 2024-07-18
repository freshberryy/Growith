package com.example.growith.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
//    Optional<Member> findByUsername(String username);
    Optional<Member> findByEmail(String email);
}
