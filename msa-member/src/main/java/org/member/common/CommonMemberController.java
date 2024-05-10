package org.member.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonMemberController {

    @GetMapping("/LoginPage")
    public String LoginPage() {
        return "Member/LoginPage";
    }

    @GetMapping("/RegisterPage")
    public String RegisterPage() {
        return "Member/RegisterPage";
    }

    @GetMapping("/UpdateEmailPage")
    public String UpdateEmailPage() {
        return "Member/UpdateEmailPage";
    }

    @GetMapping("/DeletePage")
    public String DeletePage() {
        return "Member/DeletePage";
    }





}
