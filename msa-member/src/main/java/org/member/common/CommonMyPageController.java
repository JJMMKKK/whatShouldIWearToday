package org.member.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.dto.UseMemberDataDTO;
import org.core.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommonMyPageController {

    private final PrincipalService principalService;

    @GetMapping("/MemberPage")
    public ModelAndView MemberPage(Principal principal) {
        UseMemberDataDTO useMemberDataDTO = principalService.findByUsername(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("useMemberDataDTO", useMemberDataDTO);
        modelAndView.setViewName("Member/MemberPage");
        return modelAndView;
    }

    @PostMapping("/MyClothUpdatePage")
    public ModelAndView MyClothUpdatePage(Principal principal) {
        UseMemberDataDTO useMemberDataDTO = principalService.findByUsername(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("useMemberDataDTO", useMemberDataDTO);
            modelAndView.setViewName("Member/MyClothUpdatePage");
        return modelAndView;
    }

//    //회원 삭제
//    @PostMapping("/deleteMember")
//    public void deleteMember(Long id) {
//        memberService.deleteMember(id);
//    }
//
//    // 비밀번호 변경
//    @PostMapping("/UpdatePasswordById")
//    public void deleteMember(Principal  principal) {
//        memberService.deleteMember(id);
//    }
//
//    //회원 이메일 정보 변경
//    public void updateMember(Long id, String email) {
//        MemberVO updateMember = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
//        updateMember.setEmail(email);
//        memberRepository.save(updateMember);
//    }

}
