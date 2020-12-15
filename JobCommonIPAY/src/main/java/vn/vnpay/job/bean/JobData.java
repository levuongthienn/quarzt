package vn.vnpay.job.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.quartz.Job;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobData {

    private int hour;
    private int minute;
    private String jobName;
    private Class<? extends Job> job;
}
