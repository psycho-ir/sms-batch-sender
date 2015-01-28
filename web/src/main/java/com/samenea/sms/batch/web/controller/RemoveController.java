package com.samenea.sms.batch.web.controller;

import com.samenea.sms.batch.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/18/13
 * Time: 10:36 AM
 */

@Controller
public class RemoveController {
    private Logger logger = LoggerFactory.getLogger(RemoveController.class);
    @Autowired
    private RoleService roleService;

    @RequestMapping("/remove")
    public String remove(HttpServletRequest request) {
        final String roleName = request.getParameter("role");
        final String phoneNumber = request.getParameter("phoneNumber");
        roleService.removePhoneNumber(roleName, phoneNumber);
        return "redirect:/listPhone/" + roleName;
    }
}
