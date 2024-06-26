package org.member.clothController;

import org.core.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothUseridRepository extends JpaRepository<ClothVO, MemberVO>{

    List<ClothVO> findAllByMemberVO(MemberVO memberVO);
}
