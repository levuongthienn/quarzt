package vn.vnpay.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import vn.vnpay.job.bean.JobData;

public class JobManager {
    private static JobManager ourInstance = new JobManager();

    public static JobManager getInstance() {
        return ourInstance;
    }

    private static Logger LOG = LogManager.getLogger(JobManager.class);

    private static final String GROUP_JOB = "MMS";

    private Scheduler scheduler;

    private JobManager() {
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
        } catch (Exception e) {
            LOG.error("Create job with err: {}", e);
        }
    }

//    public static void main(String[] args) {
//        List<JobData> jobs = new ArrayList<>();
//        jobs.add(JobData.builder().hour(11).minute(59).jobName("A").job(JobA.class).build());
//        jobs.add(JobData.builder().hour(11).minute(59).jobName("B").job(JobB.class).build());
//        jobs.add(JobData.builder().hour(11).minute(59).jobName("C").job(JobC.class).build());
//        JobManager.getInstance().startJob(jobs);
//    }

    public void startJob(JobData... jobs) {
        try {
            scheduler.start();
            for (JobData jobData : jobs) {
                buildJobAndTrigger(jobData);
                LOG.info("Job Start success with value: {}", jobData.toString());
            }
        } catch (Exception e) {
            LOG.error("Start job with err: {}", e);
        }
    }

    public void killJob() {
        try {
            if (scheduler.isShutdown())
                return;
            scheduler.shutdown();
            LOG.info("Job Stop");
        } catch (SchedulerException e) {
            LOG.error("Kill job with err: {}", e);
        }
    }

    private void buildJobAndTrigger(JobData jobData) throws SchedulerException {
        JobKey jobKey = new JobKey(jobData.getJobName());
        JobDetail jobDetail = JobBuilder.newJob(jobData.getJob()).withIdentity(jobKey).build();
        TriggerKey triggerKey = new TriggerKey(jobData.getJobName());
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.dailyAtHourAndMinute(jobData.getHour(), jobData.getMinute());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
