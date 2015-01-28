package com.samenea.sms.batch.web.controller;

import com.samenea.sms.batch.model.PhoneInfo;
import com.samenea.sms.batch.service.BatchMessageSender;
import com.samenea.sms.batch.service.RoleService;
import com.samenea.sms.batch.web.model.FilteredMessageJob;
import com.samenea.sms.batch.web.model.MessageJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 12:25 PM
 */

@Controller
public class JobExecutorController {
    private Logger logger = LoggerFactory.getLogger(JobExecutorController.class);
    @Autowired
    private BatchMessageSender batchMessageSender;
    @Autowired(required = true)
    private RoleService roleService;

    @RequestMapping(value = "run", method = RequestMethod.POST)
    public String runJub(MessageJob messageJob, ModelMap modelMap, Principal principal) {
        System.out.println(messageJob.getExcelFiles());
        System.out.println(messageJob.getMessage());
        if (messageJob.getFiltered()) {
            List<PhoneInfo> allSelectedPhoneInfo = new ArrayList<PhoneInfo>();
            for (String roleName : messageJob.getExcelFiles()) {

                allSelectedPhoneInfo.addAll(roleService.findRoleByName(roleName).getPhoneNumbers());
            }
            FilteredMessageJob filteredMessageJob = new FilteredMessageJob();
            filteredMessageJob.setMessage(messageJob.getMessage());
            modelMap.put("filteredMessageJob", filteredMessageJob);
            modelMap.put("phoneNumbers", allSelectedPhoneInfo);
            modelMap.put("message", messageJob.getMessage());
            return "filter";
        }
        try {
            final Integer size = batchMessageSender.send(messageJob.getExcelFiles(), messageJob.getMessage(), principal.getName());
            modelMap.put("message", String.format("%s پیام ارسال شد", size));
        } catch (Exception e) {
            modelMap.put("message", String.format("Error occured. %s", e.getMessage()));
        }
        return "result";

    }

    @RequestMapping(value = "filtered-run", method = RequestMethod.POST)
    public String runFilteredJob(FilteredMessageJob filteredMessageJob, ModelMap modelMap, Principal principal) {
        try {

            final Integer size = batchMessageSender.sendToNumbers(new HashSet<String>(filteredMessageJob.getPhoneNumbers()), filteredMessageJob.getMessage(), principal.getName());
            modelMap.put("message", String.format("%s پیام ارسال شد", size));
        } catch (Exception e) {
            modelMap.put("message", String.format("Error occured. %s", e.getMessage()));
        }
        return "result";
    }
}
