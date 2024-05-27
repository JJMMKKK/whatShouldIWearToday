package org.member.clothController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClothController {

    public final ClothService clothService;

    //옷 불러오기 메서드
    @PostMapping("/selectAllClothes")
    public List<ClothDTO> selectAllClothes(Integer userid, String categoryFilter){
        List<ClothDTO> clothDTOList = clothService.findAllByUserid(userid);
        if(Objects.equals(categoryFilter, "기본")){
            return clothDTOList;
        }
        List<ClothDTO> resultClothDTOList = new ArrayList<>();
        for (ClothDTO clothDTO : clothDTOList) {
            if(Objects.equals(clothDTO.category, categoryFilter)){
                resultClothDTOList.add(clothDTO);
            }
        }
        return resultClothDTOList;
    }

    //옷 추가 및 수정하기 메서드
    @PostMapping("/updateCloth")
    public void updateCloth(ClothDTO updatedCloth){
        clothService.updateClothes(updatedCloth);
    }

    //옷 삭제하기 메서드
    @PostMapping("/deleteCloth")
    public void deleteClothes(Integer id) {
        clothService.deleteClothes(id);
    }

    //질문용 옷 불러오기 메서드
    public List<CQ> selectClothDataForQuestionToGPT(Integer userid){
        return clothService.selectClothDataForQuestionToGPT(userid);
    }
}
