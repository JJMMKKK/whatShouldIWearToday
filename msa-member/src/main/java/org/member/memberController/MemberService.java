package org.member.memberController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.MemberVO;
import org.member.MemberDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    public void createMember(MemberDTO createMemberDataDTO) {
        MemberVO member = new MemberVO();
        BeanUtils.copyProperties(createMemberDataDTO, member);
        log.info("Member: {}", member);
        memberRepository.save(member);
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

}
