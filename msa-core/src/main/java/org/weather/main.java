package org.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class main {

    @GetMapping("/main")
    public String main() {
        return "Hello World";
    }

}
