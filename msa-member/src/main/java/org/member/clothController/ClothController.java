package org.member.clothController;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.member.ClothDTO;
import org.member.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class ClothController {

    public final ClothService clothService;

    public ClothController(ClothService clothService){
        this.clothService = clothService;
    }

    //옷 불러오기 메서드
    @PostMapping("/selectAllClothes")
    public List<ClothDTO> selectAllClothes(HttpSession session){
        
        //전체 옷 가져오기
        List<ClothDTO> clothDTOS = clothService.selectAllClothes();

        // 현재 로그인한 유저의 옷만 출력
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberDTO");
        List<ClothDTO> memberClothes = new ArrayList<>();
        for (ClothDTO clothDTO : clothDTOS) {
            if (clothDTO.getUserid().equals(memberDTO.getId())) {
                memberClothes.add(clothDTO);
            }
        }
        return memberClothes;
    }

//    @PostMapping("/selectClothes")
//    public List<ClothVO> selectClothes(Integer id, String category){
//        return clothService.selectClothes(id, category);
//    }

    //옷 추가하기 메서드
    @PostMapping("/updateCloth")
    public void updateCloth(ClothDTO updatedCloth, HttpSession session){
        MemberDTO member = (MemberDTO) session.getAttribute("memberDTO");
            updatedCloth.setUserid(member.getId());
        clothService.updateClothes(updatedCloth);
    }

    //옷 삭제하기 메서드
    @PostMapping("/deleteCloth")
    public void deleteClothes(Integer id) {
        clothService.deleteClothes(id);
    }
}
