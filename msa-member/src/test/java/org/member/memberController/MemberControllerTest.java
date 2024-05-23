package org.member.memberController;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.member.MemberDTO;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.Instant;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {

    @MockBean
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MockMvc mockMvc;

    private MemberDTO createMemberData;
    private final String username = "qwe";
    private final String password = "qwe";
    private final String email = "qwe@gmail.com";
    private final Instant registerdate = Instant.now();
    private final String country = "경기";
    private final String area = "용인시수지구";

    private String duplicatedUsername = "bnm";
    private String duplicatedEmail = "bnm@bnm";

    @BeforeEach
    void setUp() {

        createMemberData = new MemberDTO();
            createMemberData.setUsername(username);
            createMemberData.setPassword(password);
            createMemberData.setEmail(email);
            createMemberData.setRegisterdate(registerdate);
            createMemberData.setCountry(country);
            createMemberData.setArea(area);

        duplicatedUsername = duplicatedUsername;
        duplicatedEmail = duplicatedEmail;
    }

    @Test
    void success_createMember() throws Exception {

        createMemberData.setPassword(passwordEncoder.encode("qwe"));

        BDDMockito.given(memberService.existsByUsername(createMemberData.getUsername())).willReturn(false);
        BDDMockito.given(memberService.existsByEmail(createMemberData.getEmail())).willReturn(false);
        BDDMockito.doNothing().when(memberService).createMember(createMemberData);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("username", createMemberData.getUsername());
            params.add("password", password);
            params.add("email", createMemberData.getEmail());
            params.add("registerdate", createMemberData.getRegisterdate().toString());
            params.add("country", createMemberData.getCountry());
            params.add("area", createMemberData.getArea());

        mockMvc.perform(post("/create").params(params))
                .andExpect(status().isOk())
                .andExpect(request().attribute("message", "회원가입 성공"))
                .andExpect(view().name("Member/LoginPage"));
    }
}