package com.wiw.whatShouldIWearToday.MemberController;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.member.MemberDTO;
import org.member.controller.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class TestMemberController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

//    private MemberVO member;

    private MemberDTO mockDTO;

    @BeforeEach
    void setup() {
        mockDTO = new MemberDTO("admin", "admin", "admin@admin.com");

    }

    @Test
    void successCreateMember() throws Exception {
        when(memberService.existsByUsername(mockDTO.getUsername())).thenReturn(true);
        when(memberService.existsByEmail(mockDTO.getEmail())).thenReturn(true);

        MultiValueMap<String, String> createMemberData = new LinkedMultiValueMap<>();
            createMemberData.add("username", mockDTO.getUsername());
            createMemberData.add("password", mockDTO.getPassword());
            createMemberData.add("email", mockDTO.getEmail());

        mockMvc
                .perform(post("/member/create").params(createMemberData))
                .andExpect(status().isCreated());
    }

    @Test
    void failCreateMemberByExistUsername() throws Exception {
        when(memberService.existsByUsername(mockDTO.getUsername())).thenReturn(false);

        mockMvc
                .perform(post("/member/create"))
                .andExpect(status().isExpectationFailed());
    }

}
