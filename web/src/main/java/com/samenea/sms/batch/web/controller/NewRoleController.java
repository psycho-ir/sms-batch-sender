package com.samenea.sms.batch.web.controller;

import com.samenea.sms.batch.model.Role;
import com.samenea.sms.batch.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/9/13
 * Time: 2:26 PM
 */

@Controller
public class NewRoleController {
    private Logger logger = LoggerFactory.getLogger(NewRoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role/new", method = RequestMethod.GET)
    public String showNewRole(ModelMap modelMap) {
        modelMap.put("role", new Role());

        return "newRole";
    }

    @RequestMapping(value = "/role/new", method = RequestMethod.POST)
    public String addRole(Role role) {
        roleService.addRole(role);
        return "redirect:/role/list";
    }
}
