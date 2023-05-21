package cdu.zch.demo20quartz.job;

import cdu.zch.demo20quartz.job.base.BaseJob;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Zch
 * @data 2023/5/21
 **/
@Slf4j
public class TestJob implements BaseJob {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.error("Test Job 执行时间：{}", DateUtil.now());
    }
}
