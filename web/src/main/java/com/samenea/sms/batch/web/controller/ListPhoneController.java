package com.samenea.sms.batch.web.controller;

import com.samenea.sms.batch.model.Role;
import com.samenea.sms.batch.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/10/13
 * Time: 10:34 AM
 */

@Controller
public class ListPhoneController {
    private Logger logger = LoggerFactory.getLogger(ListPhoneController.class);
    @Autowired
    private RoleService roleService;

    @RequestMapping("/listPhone/{roleName}")
    public String showList(ModelMap modelMap, @PathVariable String roleName) {
        final Role role = roleService.findRoleByName(roleName);
        modelMap.put("phoneNumbers", role.getPhoneNumbers());
        modelMap.put("roleName", roleName);
        return "listPhone";
    }
}
