package org.weather.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

//    @PostMapping("/wdMain")
//    public String wdMain(String country, String area) {
    @GetMapping("/wdMain")
    public String wdMain() {


        return "WDMain";
    }

}
