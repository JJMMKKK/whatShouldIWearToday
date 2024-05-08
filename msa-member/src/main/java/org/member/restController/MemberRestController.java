package org.member.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

    public final MemberRestService memberRestService;

    public MemberRestController(MemberRestService memberRestService) {
        this.memberRestService = memberRestService;
    }

    @PostMapping("AjaxExistByUsername")
    public boolean ajaxExistByUsername(String username) {
        return memberRestService.existsByUsername(username);
    }

    @PostMapping("AjaxExistByEmail")
    public boolean ajaxExistByEmail(String email) {
        return memberRestService.existsByEmail(email);
    }

}
