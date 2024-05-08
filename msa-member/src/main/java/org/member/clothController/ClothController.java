package org.member.clothController;

import org.member.MemberDTO;
import org.member.MemberVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClothController {

    public final ClothService clothService;

    public ClothController(ClothService clothService){
        this.clothService = clothService;
    }

    @PostMapping("/selectAllClothes")
    public List<MemberVO> selectAllClothes(){
        return clothService.selectAllClothes();
    }


    @PostMapping("/selectClothes")
    public List<MemberVO> selectClothes(Long id, String category){
        return clothService.selectClothes(id, category);
    }

    @PostMapping("/updateClothes")
    public void updateClothes(List<MemberVO> updatedClothes){
        clothService.updateClothes(updatedClothes);
        clothService.selectClothes(updatedClothes.getId(), updatedClothes.getCategory());
    }

    @PostMapping("/deleteClothes")
    public void deleteClothes(MemberDTO memberDTO) {
        clothService.deleteClothes(memberDTO);
        clothService.selectClothes(memberDTO.getId(), memberDTO.getCategory());
    }


///////////////////////////////////////////////////////////////////////////////////
    //옷 리스트 메서드
    @PostMapping("/selectHat")
    public List<MemberVO> selectHat(String selectedHat){
        return clothService.selectHat(selectedHat);
    }
    @PostMapping("/selectOuter")
    public List<MemberVO> selectOuter(String selectedOuter){
        return clothService.selectOuter(selectedOuter);
    }
    @PostMapping("/selectTop")
    public List<MemberVO> selectTop(String selectedTop){
        return clothService.selectTop(selectedTop);
    }
    @PostMapping("/selectBottom")
    public List<MemberVO> selectBottom(String selectedBottom){
        return clothService.selectBottom(selectedBottom);
    }
    @PostMapping("/selectSocks")
    public List<MemberVO> selectSocks(String selectedSocks){
        return clothService.selectSocks(selectedSocks);
    }
    @PostMapping("/selectShoes")
    public List<MemberVO> selectShoes(String selectedShoes){
        return clothService.selectShoes(selectedShoes);
    }
    //옷 추가 메서드 종료

    //옷 추가 메서드
    @PostMapping("/addHat")
    public void updateHat(String addedHat){
        clothService.updateHat(addedHat);
    }
    @PostMapping("/addOuter")
    public void updateOuter(String addedOuter){
        clothService.updateOuter(addedOuter);
    }
    @PostMapping("/addTop")
    public void updateTop(String addedTop){
        clothService.updateTop(addedTop);
    }
    @PostMapping("/addBottom")
    public void updateBottom(String addedBottom){
        clothService.updateBottom(addedBottom);
    }
    @PostMapping("/addSocks")
    public void updateSocks(String addedSocks){
        clothService.updateSocks(addedSocks);
    }
    @PostMapping("/addShoes")
    public void updateShoes(String addedShoes){
        clothService.updateShoes(addedShoes);
    }
    //옷 추가 메서드 종료

    //옷 삭제 메서드
    @PostMapping("/deleteHat")
    public void deleteHat(String deletedHat){
        clothService.deleteHat(deletedHat);
    }
    @PostMapping("/deleteOuter")
    public void deleteOuter(String deletedOuter){
        clothService.deleteOuter(deletedOuter);
    }
    @PostMapping("/deleteTop")
    public void deleteTop(String deletedTop){
        clothService.deleteTop(deletedTop);
    }
    @PostMapping("/deleteBottom")
    public void deleteBottom(String deletedBottom){
        clothService.deleteBottom(deletedBottom);
    }
    @PostMapping("/deleteSocks")
    public void deleteSocks(String deletedSocks){
        clothService.deleteSocks(deletedSocks);
    }
    @PostMapping("/deleteShoes")
    public void deleteShoes(String deletedShoes){
        clothService.deleteShoes(deletedShoes);
    }
    //옷 삭제 메서드 종료

}
