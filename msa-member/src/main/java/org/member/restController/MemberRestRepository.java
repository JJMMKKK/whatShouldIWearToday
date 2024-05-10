package org.member.restController;

import org.member.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRestRepository extends JpaRepository<MemberVO, Long> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
