package org.weather.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

//    @PostMapping("/wdMain")
//    public String wdMain(String country, String area) {
    @GetMapping("/wdMain")
    public ModelAndView wdMain() {
        ModelAndView mav = new ModelAndView("wdMain");
//            mav.addObject("country", country);
//            mav.addObject("area", area);
            mav.addObject("country", "경기");
            mav.addObject("area", "용인시수지구");
            mav.setViewName("WDMain");
        return mav;
    }
}
