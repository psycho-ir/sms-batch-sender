package com.samenea.sms.batch.service;

import com.samenea.sms.batch.model.PhoneInfo;
import com.samenea.sms.batch.model.SentMessageHistory;
import com.samenea.sms.wsclient.SmsWebServiceFactory;
import com.samenea.sms.wsclient.smswsmodel.MessageVO;
import com.samenea.sms.wsclient.smswsmodel.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 1:49 PM
 */

@Service
public class BatchMessageSender {
    private Logger logger = LoggerFactory.getLogger(BatchMessageSender.class);

    @Autowired(required = true)
    private RoleService roleService;

    @Autowired(required = true)
    private HistoryService historyService;

    @Autowired(required = true)
    private SmsWebServiceFactory smsWebServiceFactory;

    @Value("${upload.path}")
    private String uploadPath = "/home/soroosh/uploads";

    @PostConstruct
    public void init() {

    }

    public Integer send(List<String> roleNames, String message, String username) {
        Set<String> recievers = new HashSet<String>();
        for (String roleName : roleNames) {
            final List<PhoneInfo> phoneNumbers = roleService.findRoleByName(roleName).getPhoneNumbers();
            for (PhoneInfo p : phoneNumbers) {
                if (p.getEnable()) {
                    recievers.add(p.getPhoneNumber());
                }
            }
        }


        List<MessageVO> preparedMessages = new MessageVOListAdapter(recievers, message);
        final String jobId = smsWebServiceFactory.getWebService().createJob();
        logger.info("JOB with id:{} created.", jobId);
        try {
            smsWebServiceFactory.getWebService().createMessages2(jobId, "BatchSender", preparedMessages);
            logger.info("{} Message prepared for sending.", preparedMessages.size());
            smsWebServiceFactory.getWebService().submitJob(jobId);
            logger.info("Job with id:{} submmited.", jobId);

        } catch (com.samenea.sms.wsclient.smswsmodel.IllegalStateException e) {
            logger.error("Error in creating messages.", e);
            throw new JobExecutionException(e);
        } catch (NotFoundException e) {
            logger.error("Job ID:{} does not exist.", jobId);
            logger.error("Error in creating messages.", e);
            throw new JobExecutionException(e);
        }
        SentMessageHistory sentMessageHistory = new SentMessageHistory(message, username, recievers.size(), jobId, (ArrayList) roleNames);
        historyService.log(sentMessageHistory);
        return preparedMessages.size();

    }

    public Integer sendToNumbers(Set<String> phoneNumbers, String message, String username) {
        List<MessageVO> preparedMessages = new MessageVOListAdapter(phoneNumbers, message);
        final String jobId = smsWebServiceFactory.getWebService().createJob();
        logger.info("JOB with id:{} created.", jobId);
        try {
            smsWebServiceFactory.getWebService().createMessages2(jobId, "BatchSender", preparedMessages);
            logger.info("{} Message prepared for sending.", preparedMessages.size());
            smsWebServiceFactory.getWebService().submitJob(jobId);
            logger.info("Job with id:{} submmited.", jobId);

        } catch (com.samenea.sms.wsclient.smswsmodel.IllegalStateException e) {
            logger.error("Error in creating messages.", e);
            throw new JobExecutionException(e);
        } catch (NotFoundException e) {
            logger.error("Job ID:{} does not exist.", jobId);
            logger.error("Error in creating messages.", e);
            throw new JobExecutionException(e);
        }
        SentMessageHistory sentMessageHistory = new SentMessageHistory(message, username, phoneNumbers.size(), jobId, new ArrayList<String>(phoneNumbers));
        historyService.log(sentMessageHistory);
        return preparedMessages.size();
    }
}
