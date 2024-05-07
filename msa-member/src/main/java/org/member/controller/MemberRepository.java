package com.wiw.whatShouldIWearToday.member.controller;

import com.wiw.whatShouldIWearToday.member.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Long> {

    public MemberVO findByUsernameAndPassword(String username, String password);
    public MemberVO findByEmail(String email);

    public boolean existsByUsername(String username);
    public boolean existsByEmail(String email);
}
