package org.member.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonClothController {

    @PostMapping("/MyClothUpdatePage")
    public String MyClothUpdatePage() {
        return "Member/MyClothUpdatePage";
    }





}
