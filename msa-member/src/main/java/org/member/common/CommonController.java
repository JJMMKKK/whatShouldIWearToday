package org.member.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/LoginPage")
    public String LoginPage() {
        return "LoginPage";
    }

    @GetMapping("/RegisterPage")
    public String RegisterPage() {
        return "RegisterPage";
    }

    @GetMapping("/UpdateEmailPage")
    public String UpdateEmailPage() {
        return "UpdateEmailPage";
    }

    @GetMapping("/DeletePage")
    public String DeletePage() {
        return "DeletePage";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }


}
