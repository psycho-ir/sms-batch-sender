package com.samenea.sms.batch.web.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by soroosh on 3/3/14.
 */
public class FilteredMessageJob {
    private Logger logger = LoggerFactory.getLogger(MessageJob.class);

    public FilteredMessageJob() {
        this.phoneNumbers = new ArrayList<String>();
    }

    private String message;

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    private List<String> phoneNumbers;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
