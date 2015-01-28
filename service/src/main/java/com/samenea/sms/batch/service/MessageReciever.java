package com.samenea.sms.batch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 12:42 PM
 */

public class MessageReciever {
    private Logger logger = LoggerFactory.getLogger(MessageReciever.class);
    private String phoneNumber;
    private String name;
    private String lastName;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
