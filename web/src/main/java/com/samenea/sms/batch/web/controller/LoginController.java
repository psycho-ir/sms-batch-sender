package com.samenea.sms.batch.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/10/13
 * Time: 9:29 AM
 */
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String showLogin(ModelMap modelMap) {

        modelMap.addAttribute("message", "ok");
        return "login";

    }

    @RequestMapping("/loginfailed")
    public String failLogin(ModelMap modelMap) {
        modelMap.addAttribute("error", "error");
        return "login";
    }
}
