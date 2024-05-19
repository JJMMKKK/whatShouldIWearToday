package org.member.memberController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.vo.MemberVO;
import org.member.MemberDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    public void createMember(MemberDTO createMemberDataDTO) {
        MemberVO member = new MemberVO();
        BeanUtils.copyProperties(createMemberDataDTO, member);
        log.info("Member: {}", member);
        memberRepository.save(member);
    }

    //유저 아이디 찾기
    public String FindUsernameByEmail(String email) {
        MemberVO memberVO = memberRepository.findByEmail(email);
        if (memberVO != null) {
            return memberVO.getUsername();
        }
        return null;
    }

    //유저 비밀번호 변경하기
    public String UpdatePasswordByEmail(String username, String email) {
        MemberVO memberVO = memberRepository.findByUsernameAndEmail(username, email);
        if (memberVO != null) {
            String newPassword = makeTemporaryPassword(15);
            log.info("New password: {}", newPassword);
            memberVO.setPassword(passwordEncoder.encode(newPassword));
            memberRepository.save(memberVO);

            /**
             * 유저 이메일로 비밀번호 전송하기
             */

            return memberVO.getUsername();
        }
        return null;
    }
    
    // 검사용 코드
        //아이디 중복 검사
        public boolean existsByUsername(String username) {
        return memberRepository.existsByUsername(username);
    }
        //이메일 중복 검사
        public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    // 임시 비밀번호 생성기
    public String makeTemporaryPassword(int passwordLength){

        //비밀번호를 형성할 배열
        char[] passwordChars  = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        };

        //글자 길이 지정
        StringBuilder newPassword = new StringBuilder(passwordLength);

        //입력한 숫자만큼의 길이의 비밀번호 생성
        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(passwordChars.length);
            newPassword.append(passwordChars[randomIndex]);
        }
        return newPassword.toString();
    }
}
