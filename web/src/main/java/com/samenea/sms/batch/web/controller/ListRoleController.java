package com.samenea.sms.batch.web.controller;

import com.samenea.sms.batch.model.Role;
import com.samenea.sms.batch.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/9/13
 * Time: 2:38 PM
 */
@Controller
public class ListRoleController {
    private Logger logger = LoggerFactory.getLogger(ListRoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping("/role/list")
    public String list(ModelMap modelMap) {
        final List<Role> allRoles = roleService.findAllRoles();
        modelMap.put("roles", allRoles);
        return "listRoles";

    }
}
