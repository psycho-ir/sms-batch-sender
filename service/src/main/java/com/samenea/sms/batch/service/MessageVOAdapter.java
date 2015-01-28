package com.samenea.sms.batch.service;

import com.samenea.sms.batch.model.PhoneInfo;
import com.samenea.sms.wsclient.smswsmodel.MessageVO;
import com.samenea.sms.wsclient.smswsmodel.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 3:07 PM
 */

public class MessageVOAdapter extends MessageVO {
    private Logger logger = LoggerFactory.getLogger(MessageVOAdapter.class);

    public MessageVOAdapter(String messageReciever, String text) {
        this.setPriority(Priority.CRITICAL);
        this.setProviderName("MagfaWebservice");
        this.setRecipientNumber(messageReciever);
        this.setText(text);
    }

}
