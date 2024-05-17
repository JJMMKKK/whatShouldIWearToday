package org.member.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.MemberVO;
import org.core.UseMemberDataDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class PrincipalService {

    private final PrincipalRepository principalRepository;

    public UseMemberDataDTO findByUsername(String username) {
        MemberVO memberVO = principalRepository.findByUsername(username);
        UseMemberDataDTO useMemberDataDTO = new UseMemberDataDTO();
            BeanUtils.copyProperties(memberVO, useMemberDataDTO);
        return useMemberDataDTO;
    }
}
