/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;

/**
 * @author khanhbn
 */
public class QuartzBatch {

    private static QuartzBatch INSTANCE = new QuartzBatch();

    public static QuartzBatch getInstance() {
        return INSTANCE;
    }

    private QuartzBatch() {
    }

    private static Logger logger = LogManager.getLogger(QuartzBatch.class);

    private Scheduler scheduler;

    public void mainScheduler(Class<? extends Job> r, int hour, int minute, String jobName) {
        try {
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("triggerName", "group1")
                    .withSchedule(dailyAtHourAndMinute(hour, minute)).build();
            JobDetail job = JobBuilder.newJob(r)
                    .withIdentity(jobName, "group1")
                    .build();
            scheduler = new StdSchedulerFactory().getScheduler();
            logger.info("Start Quartz Job Schedule to report data terminal payment. Send Hour: {}, Send Minutes: {}, with jobname: {}", hour, minute, jobName);
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            logger.error("Execute job fail with error: {}.", e);
        }
    }

    public void shutDown() throws SchedulerException {
        if (scheduler.isShutdown())
            return;
        scheduler.shutdown();
        logger.info("Shutdown Job ok");

    }
}
