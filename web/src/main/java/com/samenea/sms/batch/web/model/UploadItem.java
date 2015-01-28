package com.samenea.sms.batch.web.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 11:17 AM
 */

public class UploadItem {
    private String filename;
    private CommonsMultipartFile fileData;
    private String roleName;


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public CommonsMultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
