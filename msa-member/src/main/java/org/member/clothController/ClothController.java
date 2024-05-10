package org.member.clothController;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.member.ClothDTO;
import org.member.ClothVO;
import org.member.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping
public class ClothController {

    public final ClothService clothService;

    public ClothController(ClothService clothService){
        this.clothService = clothService;
    }

    @PostMapping("/selectAllClothes")
    public List<ClothDTO> selectAllClothes(HttpSession session){
        log.info("selectAllClothes");
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberDTO");
        List<ClothDTO> clothDTOS = clothService.selectAllClothes();
        List<ClothDTO> memberClothes = new ArrayList<>();
        for (ClothDTO clothDTO : clothDTOS) {
            if (clothDTO.getUserid().equals(memberDTO.getId())) {
                memberClothes.add(clothDTO);
            }
        }
        return memberClothes;
    }

    @PostMapping("/selectClothes")
    public List<ClothVO> selectClothes(Integer id, String category){
        return clothService.selectClothes(id, category);
    }

    @PostMapping("/updateCloth")
    public void updateCloth(ClothDTO updatedCloth, HttpSession session){
        MemberDTO member = (MemberDTO) session.getAttribute("memberDTO");
            updatedCloth.setUserid(member.getId());
        clothService.updateClothes(updatedCloth);
    }

    @PostMapping("/deleteCloth")
    public void deleteClothes(Integer id) {
        clothService.deleteClothes(id);
    }


///////////////////////////////////////////////////////////////////////////////////
//    //옷 리스트 메서드
//    @PostMapping("/selectHat")
//    public List<MemberVO> selectHat(String selectedHat){
//        return clothService.selectHat(selectedHat);
//    }
//    @PostMapping("/selectOuter")
//    public List<MemberVO> selectOuter(String selectedOuter){
//        return clothService.selectOuter(selectedOuter);
//    }
//    @PostMapping("/selectTop")
//    public List<MemberVO> selectTop(String selectedTop){
//        return clothService.selectTop(selectedTop);
//    }
//    @PostMapping("/selectBottom")
//    public List<MemberVO> selectBottom(String selectedBottom){
//        return clothService.selectBottom(selectedBottom);
//    }
//    @PostMapping("/selectSocks")
//    public List<MemberVO> selectSocks(String selectedSocks){
//        return clothService.selectSocks(selectedSocks);
//    }
//    @PostMapping("/selectShoes")
//    public List<MemberVO> selectShoes(String selectedShoes){
//        return clothService.selectShoes(selectedShoes);
//    }
//    //옷 추가 메서드 종료
//
//    //옷 추가 메서드
//    @PostMapping("/addHat")
//    public void updateHat(String addedHat){
//        clothService.updateHat(addedHat);
//    }
//    @PostMapping("/addOuter")
//    public void updateOuter(String addedOuter){
//        clothService.updateOuter(addedOuter);
//    }
//    @PostMapping("/addTop")
//    public void updateTop(String addedTop){
//        clothService.updateTop(addedTop);
//    }
//    @PostMapping("/addBottom")
//    public void updateBottom(String addedBottom){
//        clothService.updateBottom(addedBottom);
//    }
//    @PostMapping("/addSocks")
//    public void updateSocks(String addedSocks){
//        clothService.updateSocks(addedSocks);
//    }
//    @PostMapping("/addShoes")
//    public void updateShoes(String addedShoes){
//        clothService.updateShoes(addedShoes);
//    }
//    //옷 추가 메서드 종료
//
//    //옷 삭제 메서드
//    @PostMapping("/deleteHat")
//    public void deleteHat(String deletedHat){
//        clothService.deleteHat(deletedHat);
//    }
//    @PostMapping("/deleteOuter")
//    public void deleteOuter(String deletedOuter){
//        clothService.deleteOuter(deletedOuter);
//    }
//    @PostMapping("/deleteTop")
//    public void deleteTop(String deletedTop){
//        clothService.deleteTop(deletedTop);
//    }
//    @PostMapping("/deleteBottom")
//    public void deleteBottom(String deletedBottom){
//        clothService.deleteBottom(deletedBottom);
//    }
//    @PostMapping("/deleteSocks")
//    public void deleteSocks(String deletedSocks){
//        clothService.deleteSocks(deletedSocks);
//    }
//    @PostMapping("/deleteShoes")
//    public void deleteShoes(String deletedShoes){
//        clothService.deleteShoes(deletedShoes);
//    }
//    //옷 삭제 메서드 종료

}
