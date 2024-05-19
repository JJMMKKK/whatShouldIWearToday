package org.member.common;

import jakarta.transaction.Transactional;
import org.core.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrincipalRepository extends JpaRepository<MemberVO, Long> {
    MemberVO findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
