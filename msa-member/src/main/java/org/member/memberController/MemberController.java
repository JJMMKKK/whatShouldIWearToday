package org.member.memberController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.member.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
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

    //회원 이메일 변경 업데이트
    @PostMapping("/updateMember")
    public void updateMember(Long id, String email) throws Exception {
        //이메일 중복 검사
        if (!memberService.existsByEmail(email)) {
            throw new Exception();
        }
        //데이터 변경 진행
        memberService.updateMember(id, email);
    }

    //회원 삭제
    @PostMapping("/deleteMember")
    public void deleteMember(Long id) {
        memberService.deleteMember(id);
    }

}
