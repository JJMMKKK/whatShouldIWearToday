package org.member.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.dto.UseMemberDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommonClothController {

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
}
