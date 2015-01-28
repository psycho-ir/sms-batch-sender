package com.samenea.sms.batch.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/8/13
 * Time: 10:18 AM
 */
@Document(collection = "phoneInfo")
public class PhoneInfo {
    private String name;
    private String lastName;
    private String phoneNumber;
    private Boolean isEnable;


    public PhoneInfo(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public PhoneInfo() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getEnable() {
        return isEnable == null ? true : isEnable;

    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
