package com.samenea.sms.batch.service;

import com.samenea.sms.wsclient.smswsmodel.MessageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 3:13 PM
 */

public class MessageVOListAdapter extends ArrayList<MessageVO> {
    private Logger logger = LoggerFactory.getLogger(MessageVOListAdapter.class);

    public MessageVOListAdapter(Set<String> recievers, String text) {
        for (String phoneNumber : recievers) {
            this.add(new MessageVOAdapter(phoneNumber, text));
        }
    }
}
