package org.member.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/LoginPage")
    public String loginPage() {
        System.out.println("asd");
        return "LoginPage";
    }

    @GetMapping("/RegisterPage")
    public String RegisterPage() {
        return "RegisterPage";
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("test");
        return "test";
    }


}
