package org.member.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

    @GetMapping("/main")
    public String main() {
        return "Hello World222";
    }
}
