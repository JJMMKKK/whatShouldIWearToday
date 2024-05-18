package org.weather.main;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RequiredArgsConstructor
@Controller
@Slf4j
public class MainController {

    private final MainService mainService;

//    @PostMapping("/wdMain")
//    public String wdMain(String country, String area) {
    @GetMapping("/wdMain")
    public ModelAndView wdMain() {
        ModelAndView mav = new ModelAndView("wdMain");
//            mav.addObject("country", country);
//            mav.addObject("area", area);
            mav.setViewName("WDMain");
        return mav;
    }

    @PostMapping("/findCountries")
    @ResponseBody
    public List<String> findCountries() {
        return mainService.findCountries();
    }

    @PostMapping("/findAreasByCountry")
    @ResponseBody
    public List<String> findAreasByCountry(String country) {
        return mainService.findAreasByCountry(country);
    }
}
