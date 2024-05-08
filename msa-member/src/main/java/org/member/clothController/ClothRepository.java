package org.member.clothController;

import org.member.MemberDTO;
import org.member.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothRepository extends JpaRepository<MemberVO, Long>{

    void delete(MemberDTO memberDTO);
}
