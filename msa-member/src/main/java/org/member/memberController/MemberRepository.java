package org.member.memberController;

import org.core.MemberVO;
import org.member.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Long> {

    MemberVO findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    //    MemberDTO findByEmail(String email);
}
