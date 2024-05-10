package org.member.memberController;

import org.member.MemberVO;
import org.member.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create")
    public void createMember(MemberDTO createMemberData) throws Exception{
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
    }

    public List<MemberVO> readAllMembers() {
        return memberService.readAllMembers();
    }

    public Optional<MemberVO> readMemberById(Long memberId) {
        return memberService.readMemberById(memberId);
    }

    @PostMapping("/login")
    public Optional<MemberVO> readMemberByUsernmaeAndPassword(String username, String password) {
        return memberService.readMemberByUsernameAndPassword(username, password);
    }

    public Optional<MemberVO> readMemberByEmail(String email) {
        return memberService.readMemberByEmail(email);
    }

    public void updateMember(Long id, String email) throws Exception {
        //이메일 중복 검사
        if (!memberService.existsByEmail(email)) {
            throw new Exception();
        }
        //데이터 변경 진행
        memberService.updateMember(id, email);
    }

    public void deleteMember(Long id) {
        memberService.deleteMember(id);
    }
}
