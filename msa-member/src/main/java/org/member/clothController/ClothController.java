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
    public List<ClothDTO> selectAllClothes(Integer userid, HttpSession session){
        
        //현재 유저의 옷 가져오기
        List<ClothDTO> clothDTOS = clothService.findAllByUserid(userid);
        log.info(clothDTOS.toString());

        return clothDTOS;
    }

//    @PostMapping("/selectClothes")
//    public List<ClothVO> selectClothes(Integer id, String category){
//        return clothService.selectClothes(id, category);
//    }

    //옷 추가하기 메서드
    @PostMapping("/updateCloth")
    public void updateCloth(ClothDTO updatedCloth, HttpSession session){
        //log.info("updateCloth {}", updatedCloth);
        clothService.updateClothes(updatedCloth);
    }

    //옷 삭제하기 메서드
    @PostMapping("/deleteCloth")
    public void deleteClothes(Integer id) {
        clothService.deleteClothes(id);
    }
}
