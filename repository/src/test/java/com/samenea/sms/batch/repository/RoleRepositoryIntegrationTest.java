package com.samenea.sms.batch.repository;

import com.samenea.commons.component.model.exceptions.NotFoundException;
import com.samenea.sms.batch.model.PhoneInfo;
import com.samenea.sms.batch.model.Role;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/8/13
 * Time: 11:34 AM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config.xml", "classpath:repository.xml"})
public class RoleRepositoryIntegrationTest {
    private Logger logger = LoggerFactory.getLogger(RoleRepositoryIntegrationTest.class);
    @Autowired
    private MongoOperations operations;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void before() {
        Role role = new Role("Tellers", "Teller", "Teller description");
        role.addPhoneInfo(new PhoneInfo("soroosh", "sarabadani", "09122502092"));

        operations.save(role);

    }

    @After
    public void after() {
        operations.dropCollection(Role.class);
    }

    @Test
    public void t() {

        Role role = new Role("Tellers", "Teller", "Teller description");
        role.addPhoneInfo(new PhoneInfo("soroosh", "sarabadani", "09122502092"));

        operations.save(role);
        final List<Role> roles = operations.find(new Query(Criteria.where("phoneNumbers.name").is("soroosh")), Role.class);
        String[] phoneNumbers = new String[role.getPhoneNumbers().size()];
        for (int i = 0; i < roles.get(0).getPhoneNumbers().size(); i++) {
            phoneNumbers[i] = roles.get(0).getPhoneNumbers().get(i).getPhoneNumber();
        }

        operations.updateMulti(new Query(Criteria.where("phoneNumbers.name").is("soroosh")), new Update().set("phoneNumbers", new PhoneInfo("ss", "aa", "000")), Role.class);


    }

    @Test
    public void findRoleByName_should_return_role() {
        final Role role = roleRepository.findRoleByName("Teller");

    }

    @Test(expected = NotFoundException.class)
    public void findRoleByName_should_throw_exception_when_role_does_not_exist() {
        final Role role = roleRepository.findRoleByName("T");

    }

    @Test
    public void addRole_should_create_new_role_in_repository() {
        Role role = new Role("Test", "T", "TestDesc");
        roleRepository.addRole(role);

        final Role r = roleRepository.findRoleByName("T");
        Assert.assertNotNull(r);
    }

    @Test
    public void findAll_should_return_all_roles() {
        final List<Role> allRoles = roleRepository.findAll();
        Assert.assertEquals(1, allRoles.size());
    }

}
