package com.samenea.sms.batch.service;

import com.samenea.sms.batch.model.SentMessageHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/9/13
 * Time: 4:08 PM
 */
@Service
public class HistoryService {
    private Logger logger = LoggerFactory.getLogger(HistoryService.class);

    @Autowired
    private MongoOperations mongoOperations;

    public void log(SentMessageHistory sentMessageHistory) {
        mongoOperations.save(sentMessageHistory);

    }
}
