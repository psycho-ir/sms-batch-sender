package com.samenea.sms.batch.service;

import com.samenea.sms.wsclient.SmsWebServiceFactory;
import com.samenea.sms.wsclient.smswsmodel.MessageVO;
import com.samenea.sms.wsclient.smswsmodel.NotFoundException;
import com.samenea.sms.wsclient.smswsmodel.Priority;
import com.samenea.sms.wsclient.smswsmodel.SmsWebservice;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 2:07 PM
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:service.xml", "classpath*:config.xml"})
public class BatchMessageSenderIntegrationTest {
    private Logger logger = LoggerFactory.getLogger(BatchMessageSenderIntegrationTest.class);

    @Autowired
    private BatchMessageSender batchMessageSender;

    @Autowired
    private SmsWebServiceFactory factory;

    @Test
    public void t() throws com.samenea.sms.wsclient.smswsmodel.IllegalStateException, NotFoundException {
        final SmsWebservice smsService = factory.getWebService();
        final String job = smsService.createJob();
        final MessageVO messageVO = new MessageVO();
        messageVO.setText("hello");
        messageVO.setProviderName("MagfaWebservice");
        messageVO.setRecipientNumber("09122502092");
        messageVO.setPriority(Priority.CRITICAL);

        final ArrayList<MessageVO> smsMessages = new ArrayList<MessageVO>();
        smsMessages.add(messageVO);
        smsService.createMessages(job, smsMessages);
        smsService.submitJob(job);
    }

/*    @Test
    public void send_should_send_sms_to_ws() {
        List<String> files = new ArrayList<String>();
        files.add("numbers.xls");
        batchMessageSender.send(files, "wow");
    }*/
}
