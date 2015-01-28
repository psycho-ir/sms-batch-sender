package com.samenea.sms.batch.web.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 12:18 PM
 */

public class MessageJob {
    private Logger logger = LoggerFactory.getLogger(MessageJob.class);

    private List<String> excelFiles = new ArrayList<String>();
    private String message;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Boolean getFiltered() {
        return filtered;
    }

    public void setFiltered(Boolean filtered) {
        this.filtered = filtered;
    }

    private Boolean filtered;

    public List<String> getExcelFiles() {
        return excelFiles;
    }

    public void setExcelFiles(List<String> excelFiles) {
        this.excelFiles = excelFiles;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
