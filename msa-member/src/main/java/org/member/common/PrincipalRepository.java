package org.member.common;

import org.member.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrincipalRepository extends JpaRepository<MemberVO, Long> {
    MemberVO findByUsername(String username);
}
