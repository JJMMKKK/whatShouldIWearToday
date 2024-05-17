package org.core;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CoreService {

    private final CoreRepository memberVORepository;

    public UseMemberDataDTO findById(Integer userid) {
        Optional<MemberVO> optionalMemberVO = memberVORepository.findById(userid);
        if (optionalMemberVO.isPresent()) {
            MemberVO memberVO = optionalMemberVO.get();
            UseMemberDataDTO useMemberDataDTO = new UseMemberDataDTO();
            BeanUtils.copyProperties(memberVO, useMemberDataDTO);
            return useMemberDataDTO;
        } else {
            throw new IllegalArgumentException("User with id " + userid + " not found");
        }
    }

}
