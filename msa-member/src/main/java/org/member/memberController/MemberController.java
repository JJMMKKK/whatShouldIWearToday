package org.member.memberController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.member.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.Instant;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @PostMapping("/create")
    public ModelAndView createMember(MemberDTO createMemberData) throws Exception{
        //아이디 중복 검사
        if (memberService.existsByUsername(createMemberData.getUsername())) {
            throw new Exception();
        }
        //이메일 중복 검사
        if (memberService.existsByEmail(createMemberData.getEmail())) {
            throw new Exception();
        }

        //회원가입 진행
        createMemberData.setPassword(passwordEncoder.encode(createMemberData.getPassword()));
        Instant registerDate = Timestamp.from(Instant.now()).toInstant();
        createMemberData.setRegisterdate(registerDate);
        log.info("Create member: " + createMemberData);

        memberService.createMember(createMemberData);

        ModelAndView view = new ModelAndView();
            view.addObject("message", "회원가입 성공");
            view.setViewName("Member/LoginPage");
        return view;
    }

    // 아이디 찾기
    @PostMapping("/FindUsernameByEmail")
    public ModelAndView FindUsernameByEmail(String email) {
        String username = memberService.FindUsernameByEmail(email);
        ModelAndView view = new ModelAndView();
            view.addObject("username", username);
            view.setViewName("Member/ViewUsername");
        return view;
    }

    // 임시 비밀번호로 변경
    @PostMapping("/UpdatePasswordByEmail")
    public String FindUsernameByEmail(String username, String email) {
        String foundedUsername = memberService.UpdatePasswordByEmail(username, email);
        return "redirect:/prgForUpdatePasswordByEmail?username=" + foundedUsername;
    }   //prg Pattern
    @GetMapping("/prgForUpdatePasswordByEmail")
    public ModelAndView PrgForUpdatePasswordByEmail(String username) {
        ModelAndView view = new ModelAndView();
        view.addObject("username", username);
        view.setViewName("Member/ChangeToTemporaryPassword");
        return view;
    }

}
