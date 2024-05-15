package org.member.clothController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.member.ClothDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClothController {

    public final ClothService clothService;

    //옷 불러오기 메서드
    @PostMapping("/selectAllClothes")
    public List<ClothDTO> selectAllClothes(Integer userid){
        return clothService.findAllByUserid(userid);
    }

    //옷 추가하기 메서드
    @PostMapping("/updateCloth")
    public void updateCloth(ClothDTO updatedCloth){
        clothService.updateClothes(updatedCloth);
    }

    //옷 삭제하기 메서드
    @PostMapping("/deleteCloth")
    public void deleteClothes(Integer id) {
        clothService.deleteClothes(id);
    }
}
