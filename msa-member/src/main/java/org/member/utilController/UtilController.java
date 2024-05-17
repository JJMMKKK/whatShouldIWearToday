package org.member.utilController;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UtilController {

    private final UtilService utilService;

    @PostMapping("/findCountries")
    @ResponseBody
    public List<String> findCountries() {
        return utilService.findCountries();
    }

    @PostMapping("/findAreasByCountry")
    @ResponseBody
    public List<String> findAreasByCountry(String country) {
        return utilService.findAreasByCountry(country);
    }
}
