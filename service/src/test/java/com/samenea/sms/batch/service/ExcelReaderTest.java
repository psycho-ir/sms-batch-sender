package com.samenea.sms.batch.service;


import com.samenea.sms.batch.model.PhoneInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 1:49 PM
 */
@Ignore
public class ExcelReaderTest {
    private Logger logger = LoggerFactory.getLogger(ExcelReaderTest.class);

    @Test
    public void d() throws IOException {
        ExcelReader reader = new ExcelReader();
        final List<PhoneInfo> recievers = reader.getPhoneInfo("/home/soroosh/uploads/numbers.xls");
        System.out.println(recievers.size());
    }
}
