package org.member.clothController;

import org.member.ClothDTO;
import org.member.ClothVO;
import org.member.MemberVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClothService {

    public final ClothRepository clothRepository;

    public ClothService(ClothRepository clothRepository) {
        this.clothRepository = clothRepository;
    }

    //옷 불러오기 메서드
    public List<ClothDTO> selectAllClothes() {
        List<ClothVO> clothVOList = new ArrayList<>(clothRepository.findAll());
        List<ClothDTO> clothDTOList = new ArrayList<>(clothVOList.size());
        for (ClothVO clothVO : clothVOList) {
              ClothDTO clothDTO = new ClothDTO();
                clothDTO.setId(clothVO.getId());
                clothDTO.setUserid(clothVO.getMemberVO().getId());
                clothDTO.setCategory(clothVO.getCategory());
                clothDTO.setClothdata(clothVO.getClothdata());
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
