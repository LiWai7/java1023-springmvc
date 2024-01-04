package com.atguigu.service.impl;

import com.atguigu.pojo.Schedule;
import com.atguigu.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * projectName: com.atguigu.service.impl
 *
 * description:
 */

@Service
public class ScheduleServiceImpl  implements ScheduleService {


    //准备假数据
    private static Map<Integer, Schedule> scheduleMap;

    private static  int maxId = 5;

    static {

        scheduleMap = new HashMap<>();

        Schedule schedule = null;

        schedule = new Schedule(1, "学习Java", false);
        scheduleMap.put(1, schedule);

        schedule = new Schedule(2, "学习H5", true);
        scheduleMap.put(2, schedule);

        schedule = new Schedule(3, "学习Css", false);
        scheduleMap.put(3, schedule);


        schedule = new Schedule(4, "学习JavaScript", false);
        scheduleMap.put(4, schedule);

        schedule = new Schedule(5, "学习Spring", true);
        scheduleMap.put(5, schedule);

    }


    /**
     * 返回全部学习计划
     *
     * @return
     */
    @Override
    public List<Schedule> getAll() {
        return new ArrayList<>(scheduleMap.values());
    }

    /**
     * 保存学习计划
     *
     * @param schedule
     */
    @Override
    public void saveSchedule(Schedule schedule) {
        maxId++;
        schedule.setId(maxId);
        scheduleMap.put(maxId,schedule);
    }

    /**
     * 更新学习计划
     *
     * @param schedule
     */
    @Override
    public void updateSchedule(Schedule schedule) {
        scheduleMap.put(schedule.getId(),schedule);
    }

    /**
     * 移除学习计划
     *
     * @param id
     */
    @Override
    public void removeById(Integer id) {
        scheduleMap.remove(id);
    }
}