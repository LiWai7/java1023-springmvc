package com.atguigu.service;

import com.atguigu.pojo.Schedule;

import java.util.List;

/**
 * projectName: com.atguigu.service
 *
 * description: schedule业务接口
 */

public interface ScheduleService {

    /**
     * 返回全部学习计划
     * @return
     */
    List<Schedule> getAll();

    /**
     * 保存学习计划
     * @param schedule
     */
    void saveSchedule(Schedule schedule);

    /**
     * 更新学习计划
     * @param schedule
     */
    void updateSchedule(Schedule schedule);

    /**
     * 移除学习计划
     * @param
     */
    void removeById(Integer id);

}