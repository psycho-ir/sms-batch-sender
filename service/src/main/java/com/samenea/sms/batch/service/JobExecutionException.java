package com.samenea.sms.batch.service;

import com.samenea.commons.component.utils.exceptions.SamenRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 3:30 PM
 */

public class JobExecutionException extends SamenRuntimeException {
    private Logger logger = LoggerFactory.getLogger(JobExecutionException.class);

    public JobExecutionException() {
        super();
    }

    public JobExecutionException(String s) {
        super(s);
    }

    public JobExecutionException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public JobExecutionException(Throwable throwable) {
        super(throwable);
    }

}
