package org.member.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.vo.MemberVO;
import org.core.dto.UseMemberDataDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class PrincipalService {

    private final PrincipalRepository principalRepository;
    private final PasswordEncoder passwordEncoder;

    public UseMemberDataDTO findByUsername(String username) {
        MemberVO memberVO = principalRepository.findByUsername(username);
        UseMemberDataDTO useMemberDataDTO = new UseMemberDataDTO();
            BeanUtils.copyProperties(memberVO, useMemberDataDTO);
        return useMemberDataDTO;
    }

    public void deleteByUsername(String name) {
        principalRepository.deleteByUsername(name);
    }

    public Boolean UpdatePasswordByUsername(String username, String newPassword) {
        MemberVO memberVO = principalRepository.findByUsername(username);
        if (memberVO != null) {
            memberVO.setPassword(passwordEncoder.encode(newPassword));
            principalRepository.save(memberVO);
            return true;
        }
        return false;
    }

    public Boolean UpdateEmailByUsername(String username, String newEmail) {
        MemberVO memberVO = principalRepository.findByUsername(username);
        if (memberVO != null) {
            memberVO.setEmail(newEmail);
            principalRepository.save(memberVO);
            return true;
        }
        return false;
    }

}
