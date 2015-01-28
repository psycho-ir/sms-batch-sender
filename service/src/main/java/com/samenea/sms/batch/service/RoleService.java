package com.samenea.sms.batch.service;

import com.samenea.sms.batch.model.PhoneInfo;
import com.samenea.sms.batch.model.Role;
import com.samenea.sms.batch.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/8/13
 * Time: 11:12 AM
 */
@Service
public class RoleService {
    private Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ExcelReader excelReader;
    @Value("${upload.path}")
    private String uploadPath = "/home/soroosh/uploads";

    public void addRole(Role role) {
        roleRepository.addRole(role);
    }

    public void removeRole(String roleName) {
        roleRepository.remove(roleName);

    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();

    }

    public void loadFromExcel(String originalFilename, String roleName) {
        try {
            final List<PhoneInfo> phoneNumbers = excelReader.getPhoneInfo(uploadPath + "/" + originalFilename);
            roleRepository.reloadPhoneNumbers(roleName, phoneNumbers);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public Role findRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }

    public void removePhoneNumber(String roleName, String phoneNumber) {
        roleRepository.removePhoneNumber(roleName,phoneNumber);
    }
}
