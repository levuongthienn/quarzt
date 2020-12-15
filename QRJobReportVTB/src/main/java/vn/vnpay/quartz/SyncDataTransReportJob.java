/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.quartz;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import vn.vnpay.dao.SyncDataDao;

/**
 *
 * @author trangvt
 */
public class SyncDataTransReportJob implements Job {
    private final static Logger LOGGER = LogManager.getLogger(SyncDataTransReportJob.class);

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        Long systemTime = System.currentTimeMillis();
        String tokenKey = RandomStringUtils.random(15, true, true);
        ThreadContext.put("token", tokenKey);
        LOGGER.info("Start Job SyncDataTransReportJob");
        boolean out = SyncDataDao.getInstance().syncTransReportData();
        if (out) {
            LOGGER.info("Execute Job sync data trans report Success with time: {}", System.currentTimeMillis() - systemTime);
        } else {
            LOGGER.info("EExecute Job sync data trans report FAILED");
        }
        ThreadContext.clearAll();
    }
}
