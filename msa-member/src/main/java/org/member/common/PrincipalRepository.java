package org.member.common;

import org.core.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrincipalRepository extends JpaRepository<MemberVO, Long> {
    MemberVO findByUsername(String username);
}
