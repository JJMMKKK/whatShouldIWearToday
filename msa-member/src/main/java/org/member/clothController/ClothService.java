package org.member.clothController;

import org.member.MemberDTO;
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

    public List<MemberVO> selectAllClothes() {
        return new ArrayList<MemberVO>(clothRepository.findAll());
    }

    public List<MemberVO> selectClothes(Long id, String category) {
        Map<String, String> map = new HashMap<>();
            map.put("id", id.toString());
            map.put("category", category);
        return null;
    }

    public void updateClothes(List<MemberVO> updatedClothes) {
        clothRepository.saveAll(updatedClothes);
    }

    public void deleteClothes(MemberDTO memberDTO) {
        clothRepository.delete(memberDTO);
    }

}
