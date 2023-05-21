package cdu.zch.demo20quartz.job.base;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Job基类，主要是在 org.quartz.Job上再封装一层，只让我们自己项目里的Job去实现
 * @author Zch
 * @data 2023/5/21
 **/
public interface BaseJob extends Job {

    /**
     *
     * @param jobExecutionContext 上下文
     * @throws JobExecutionException 抛出异常
     */
    @Override
    void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException;
}
