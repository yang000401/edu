package net.e4net.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.e4net.demo.entity.TbMember;
import net.e4net.demo.service.UserService;

@Controller
public class IndexController {
    @Autowired private UserService userService;

    @GetMapping("/index")
    public String index(@AuthenticationPrincipal TbMember Tbmember, Model model) {
        model.addAttribute("member",Tbmember);
        model.addAttribute("merchants", userService.allMerchants());
        return "pages/indexPage";
    }


}
