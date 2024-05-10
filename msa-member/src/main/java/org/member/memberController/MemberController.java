package org.member.memberController;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.member.MemberDTO;
import org.member.MemberDTO;
import org.member.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create")
    public ModelAndView createMember(MemberDTO createMemberData, HttpSession session) throws Exception{

        log.info(createMemberData.toString());

        //아이디 중복 검사
        if (memberService.existsByUsername(createMemberData.getUsername())) {
            throw new Exception();
        }
        //이메일 중복 검사
        if (memberService.existsByEmail(createMemberData.getEmail())) {
            throw new Exception();
        }
        //회원가입 진행
        memberService.createMember(createMemberData);

        ModelAndView view = new ModelAndView();
            view.addObject("message", "회원가입 성공");
            session.setAttribute("memberDTO", createMemberData);
            view.setViewName("Member/MemberPage");
        return view;
    }

    public List<MemberDTO> readAllMembers() {
        return memberService.readAllMembers().stream()
                .map(memberVO -> new MemberDTO(memberVO.getId(), memberVO.getUsername(), memberVO.getPassword(), memberVO.getEmail()))
                .collect(Collectors.toList());
    }


    public Optional<MemberDTO> readMemberById(Long memberId) {
        Optional<MemberVO> memberVO = memberService.readMemberById(memberId);
        MemberDTO memberDTO = new MemberDTO(memberVO.get().getId(), memberVO.get().getUsername(), memberVO.get().getPassword(), memberVO.get().getEmail());
        return Optional.of(memberDTO);
    }

    @PostMapping("/login")
    public ModelAndView readMemberByUsernmaeAndPassword(String username, String password, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<MemberDTO> member = memberService.readMemberByUsernameAndPassword(username, password);
        if(member.isPresent()){
            MemberDTO memberDTO = new MemberDTO(member.get().getId(), member.get().getUsername(), member.get().getPassword(), member.get().getEmail());
            session.setAttribute("memberDTO", memberDTO);
            modelAndView.addObject("memberDTO", memberDTO);
            modelAndView.setViewName("Member/MemberPage");
            return modelAndView;
        }
        modelAndView.setViewName("Member/LoginPage");
        return modelAndView;
    }

    @PostMapping("logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("memberDTO");
        ModelAndView view = new ModelAndView();
        view.addObject("message", "로그아웃 성공");
        view.setViewName("Member/LoginPage");
        return view;
    }

    public Optional<MemberDTO> readMemberByEmail(String email) {
        return memberService.readMemberByEmail(email);
    }

    @PostMapping("/updateMember")
    public void updateMember(Long id, String email) throws Exception {
        //이메일 중복 검사
        if (!memberService.existsByEmail(email)) {
            throw new Exception();
        }
        //데이터 변경 진행
        memberService.updateMember(id, email);
    }

    @PostMapping("/deleteMember")
    public void deleteMember(Long id) {
        memberService.deleteMember(id);
    }
}
