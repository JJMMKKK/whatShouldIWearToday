package org.member.clothController;

import org.member.ClothVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothRepository extends JpaRepository<ClothVO, Integer>{

}
