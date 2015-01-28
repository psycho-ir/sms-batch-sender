package com.samenea.sms.batch.web.controller;

import com.samenea.sms.batch.service.RoleService;
import com.samenea.sms.batch.web.model.UploadItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 10:56 AM
 */
@Controller
public class UploadExcelController {
    private Logger logger = LoggerFactory.getLogger(UploadExcelController.class);

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/upload/role/{roleName}")
    public String showUpload(ModelMap modelMap, @PathVariable String roleName) {
        modelMap.put("uploadItem", new UploadItem());
        modelMap.put("roleName", roleName);

        return "upload";


    }

    @RequestMapping(value = "/upload/role/{roleName}", method = RequestMethod.POST)
    public String upload(UploadItem uploadItem) {
        try {

            MultipartFile filea = uploadItem.getFileData();

            InputStream inputStream = null;
            OutputStream outputStream = null;
            if (filea.getSize() > 0) {
                inputStream = filea.getInputStream();
                File file = new File(uploadPath + "/" + filea.getOriginalFilename());
                outputStream = new FileOutputStream(file);
                int readBytes = 0;
                byte[] buffer = new byte[8192];
                while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
                    outputStream.write(buffer, 0, readBytes);
                }
                outputStream.flush();
                outputStream.close();
                inputStream.close();
                logger.info("File:{} uploaded.", filea.getOriginalFilename());

            }
            roleService.loadFromExcel(filea.getOriginalFilename(), uploadItem.getRoleName());
        } catch (Exception e) {
            logger.error("Error in uploading.", e);
        }
        return "redirect:/listPhone/"+uploadItem.getRoleName();
    }



}


