package cdu.zch.demo20quartz.utils;

import cdu.zch.demo20quartz.job.base.BaseJob;

/**
 * 定时任务反射工具类
 * @author Zch
 * @data 2023/5/21
 **/
public class JobUtils {

    public static BaseJob getClass(String classname) throws Exception {
        Class<?> clazz = Class.forName(classname);
        return (BaseJob) clazz.newInstance();
    }

}
