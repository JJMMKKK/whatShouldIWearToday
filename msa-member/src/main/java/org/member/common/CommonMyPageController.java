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

    //마이페이지
    @GetMapping("/MemberPage")
    public ModelAndView MemberPage(Principal principal) {
        UseMemberDataDTO useMemberDataDTO = principalService.findByUsername(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("useMemberDataDTO", useMemberDataDTO);
            modelAndView.setViewName("Member/MemberPage");
        return modelAndView;
    }

    //마이페이지-옷장
    @PostMapping("/MyClothUpdatePage")
    public ModelAndView MyClothUpdatePage(Principal principal) {
        UseMemberDataDTO useMemberDataDTO = principalService.findByUsername(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("useMemberDataDTO", useMemberDataDTO);
            modelAndView.setViewName("Member/MyClothUpdatePage");
        return modelAndView;
    }

    //회원 탈퇴
    @PostMapping("/withdrawByUsername")
    public String withdrawByUsername(Principal principal) {
        principalService.deleteByUsername(principal.getName());
        return "redirect:/LoginPage";
    }

    // 비밀번호 변경 페이지로 이동
    @PostMapping("/ChangePassword")
    public ModelAndView ChangePassword(Principal  principal) {
        UseMemberDataDTO useMemberDataDTO = principalService.findByUsername(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("useMemberDataDTO", useMemberDataDTO);
            modelAndView.setViewName("Member/ChangePasswordPage");
        return modelAndView;
    }

    // 이메일 변경 페이지로 이동
    @PostMapping("/ChangeEmail")
    public ModelAndView ChangeEmail(Principal  principal) {
        UseMemberDataDTO useMemberDataDTO = principalService.findByUsername(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("useMemberDataDTO", useMemberDataDTO);
            modelAndView.setViewName("Member/ChangeEmailPage");
        return modelAndView;
    }

    // 비밀번호 변경
    @PostMapping("/UpdatePasswordByUsername")
    public String UpdatePasswordByUsername(Principal  principal, String newPassword) {
        Boolean changeSuccess = principalService.UpdatePasswordByUsername(principal.getName(), newPassword);
        return "redirect:/logout";
    }

    //회원 이메일 변경
    @PostMapping("/UpdateEmailByUsername")
    public String UpdateEmailByUsername(Principal  principal, String newEmail) {
        Boolean changeSuccess = principalService.UpdateEmailByUsername(principal.getName(), newEmail);
        return "redirect:/logout";
    }

}
