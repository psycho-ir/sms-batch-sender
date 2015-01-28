package com.samenea.sms.batch.web.controller;

import com.samenea.sms.batch.model.Role;
import com.samenea.sms.batch.service.RoleService;
import com.samenea.sms.batch.web.model.MessageJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 11:59 AM
 */
@Controller
public class ShowUploadedController {
    private Logger logger = LoggerFactory.getLogger(ShowUploadedController.class);

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private RoleService roleService;


    @RequestMapping("/")
    public String showUploadedFiles(ModelMap modelMap) {
        File file = new File(uploadPath);
        List<Role> roles = roleService.findAllRoles();
        modelMap.put("roles", roles);
        modelMap.put("messageJob", new MessageJob());

        return "list";

    }
}
