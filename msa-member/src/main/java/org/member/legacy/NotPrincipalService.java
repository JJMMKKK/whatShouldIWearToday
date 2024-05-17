//package org.member.legacy;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.core.dto.UseMemberDataDTO;
//import org.member.MemberVO;
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Slf4j
//@Service
//public class NotPrincipalService {
//
//    private final NotPrincipalRepository principalRepository;
//
//    public UseMemberDataDTO findByUsername(String username) {
//        MemberVO memberVO = principalRepository.findByUsername(username);
//        UseMemberDataDTO useMemberDataDTO = new UseMemberDataDTO();
//            BeanUtils.copyProperties(memberVO, useMemberDataDTO);
//        return useMemberDataDTO;
//    }
//}
