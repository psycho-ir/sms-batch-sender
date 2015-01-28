package com.samenea.sms.batch.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/8/13
 * Time: 10:17 AM
 */
@Document(collection = "role")
public class Role {
    private String name;
    private String title;
    private String description;
    private ArrayList<PhoneInfo> phoneNumbers;

    public Role(String title, String name, String description) {
        this();
        this.name = name;
        this.title = title;
        this.description = description;

    }

    public Role() {
        this.phoneNumbers = new ArrayList<PhoneInfo>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addPhoneInfo(PhoneInfo phoneInfo) {
        this.phoneNumbers.add(phoneInfo);
    }

    public void removePhoneIngo(PhoneInfo phoneInfo) {
        for (PhoneInfo p : this.phoneNumbers) {
            if (p.getPhoneNumber().equals(phoneInfo.getLastName())) {
                this.phoneNumbers.remove(p);
            }
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public List<PhoneInfo> getPhoneNumbers() {
        return phoneNumbers;
    }
}
