package cdu.zch.demo20quartz.mapper;

import cdu.zch.demo20quartz.entity.domain.JobAndTrigger;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Zch
 * @data 2023/5/21
 **/
@Mapper
public interface JobMapper {

    /**
     * 查询定时作业和触发器列表
     * @return 定时作业和触发器列表
     */
    List<JobAndTrigger> list();

}
