package org.member.memberController;

import org.member.MemberVO;
import org.member.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public void createMember(MemberDTO createMemberDataDTO) {
        MemberVO member = new MemberVO();
            member.setUsername(createMemberDataDTO.getUsername());
            member.setPassword(createMemberDataDTO.getPassword());
            member.setEmail(createMemberDataDTO.getEmail());
        memberRepository.save(member);
    }

    //로그인                                                                                                              //SpringSecurity
    public Optional<MemberDTO> readMemberByUsernameAndPassword(String username, String password) {
        return Optional.ofNullable(memberRepository.findByUsernameAndPassword(username, password));
    }
    
    //회원 이메일 정보 변경
    public void updateMember(Long id, String email) {
        MemberVO updateMember = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
            updateMember.setEmail(email);
        memberRepository.save(updateMember);
    }

    //회원 삭제
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    
    //검사용 코드
        //아이디 중복 검사
        public boolean existsByUsername(String username) {
        return memberRepository.existsByUsername(username);
    }
        //이메일 중복 검사
        public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }




//    public List<MemberVO> readAllMembers() {
//        List<MemberVO> members = new ArrayList<>();
//        memberRepository.findAll().forEach(memberVO -> members.add(memberVO));
//        return members;
//    }
//
//    public Optional<MemberVO> readMemberById(Long id) {
//        return memberRepository.findById(id);
//    }
//    public Optional<MemberDTO> readMemberByEmail(String email) {
//        return Optional.ofNullable(memberRepository.findByEmail(email));
//    }
}
