package com.samenea.sms.batch.repository;

import com.samenea.commons.component.model.exceptions.NotFoundException;
import com.samenea.sms.batch.model.PhoneInfo;
import com.samenea.sms.batch.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/9/13
 * Time: 12:10 PM
 */

@Repository
public class RoleRepository {
    private Logger logger = LoggerFactory.getLogger(RoleRepository.class);

    @Autowired
    private MongoOperations mongoOperations;

    public Role findRoleByName(String roleName) {
        final List<Role> roles = mongoOperations.find(new Query(Criteria.where("name").is(roleName)), Role.class);
        if (roles.size() == 0) {
            throw new NotFoundException(String.format("Role with name:%s does not exist.", roleName));
        }
        return roles.get(0);

    }

    public void addRole(Role role) {
        mongoOperations.insert(role);
    }

    public List<Role> findAll() {
        return mongoOperations.findAll(Role.class);
    }

    public void remove(String roleName) {
        mongoOperations.remove(new Query(Criteria.where("name").is(roleName)), Role.class);
    }

    public void reloadPhoneNumbers(String roleName, List<PhoneInfo> phoneNumbers) {
        mongoOperations.updateMulti(new Query(Criteria.where("name").is(roleName)), new Update().set("phoneNumbers", phoneNumbers), Role.class);
    }

    public void removePhoneNumber(String roleName, String phoneNumber) {
        final Role roleByName = findRoleByName(roleName);
        final List<PhoneInfo> phoneNumbers = roleByName.getPhoneNumbers();
        for (int i = phoneNumbers.size()-1; i >= 0; i--) {
            if (phoneNumbers.get(i).getPhoneNumber().equals(phoneNumber)) {
                phoneNumbers.remove(i);
            }
        }
        reloadPhoneNumbers(roleName, roleByName.getPhoneNumbers());

    }
}
