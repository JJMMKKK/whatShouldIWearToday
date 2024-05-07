package org.member.controller;

import org.member.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Long> {

    MemberVO findByUsernameAndPassword(String username, String password);
    MemberVO findByEmail(String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
