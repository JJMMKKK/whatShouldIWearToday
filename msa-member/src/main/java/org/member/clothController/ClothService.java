package org.member.clothController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.member.ClothDTO;
import org.member.ClothVO;
import org.member.MemberVO;
import org.member.memberController.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClothService {

    private final ClothRepository clothRepository;
    private final ClothUseridRepository idRepository;

    //옷 불러오기 메서드
    public List<ClothDTO> findAllByUserid(Integer userid) {
        MemberVO member = new MemberVO();
            member.setId(userid);
        List<ClothVO> clothVOList = idRepository.findAllByMemberVO(member);
        List<ClothDTO> clothDTOList = new ArrayList<>(clothVOList.size());
        for (ClothVO clothVO : clothVOList) {
            ClothDTO clothDTO = new ClothDTO();
            BeanUtils.copyProperties(clothVO, clothDTO);
            clothDTOList.add(clothDTO);
        }
        return clothDTOList;
    }

//    public List<ClothVO> selectClothes(Integer id, String category) {
//        Map<String, String> map = new HashMap<>();
//            map.put("id", id.toString());
//            map.put("category", category);
//        return null;
//    }

    //옷 추가하기 메서드
    public void updateClothes(ClothDTO updatedCloth) {
        ClothVO clothVO = new ClothVO();

        MemberVO memberVO = new MemberVO();
        memberVO.setId(updatedCloth.getUserid());
        clothVO.setMemberVO(memberVO);

        clothVO.setCategory(updatedCloth.getCategory());
        clothVO.setClothdata(updatedCloth.getClothdata());

        clothRepository.save(clothVO);
    }

    //옷 삭제하기 메서드
    public void deleteClothes(Integer id) {
        clothRepository.deleteById(id);
    }

}
