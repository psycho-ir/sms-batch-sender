package com.samenea.sms.batch.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/8/13
 * Time: 11:19 AM
 */
@Document(collection = "sentHistory")
public class SentMessageHistory {
    private int size;
    private String jobId;

    private ArrayList<String> roles;
    private Date sentDate;
    private String content;
    private String senderUserName;

    public SentMessageHistory() {

    }


    public SentMessageHistory(String content, String senderUserName, int size, String jobId, ArrayList<String> roles) {
        this.sentDate = new Date();
        this.content = content;
        this.senderUserName = senderUserName;
        this.size = size;
        this.jobId = jobId;
        this.roles = roles;

    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderUserName() {
        return senderUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
