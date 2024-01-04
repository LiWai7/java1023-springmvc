package com.atguigu.controller;

import com.atguigu.pojo.Schedule;
import com.atguigu.service.ScheduleService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */

@RestController
@RequestMapping("schedule")
@CrossOrigin //跨域注解 运行外部访问
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public R findAll(){
        List<Schedule> all = scheduleService.getAll();
        R r =  R.ok(all);
        return r;
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable int id){
        scheduleService.removeById(id);
        return R.ok(null);
    }

    @PostMapping
    public R save(@RequestBody  Schedule schedule){
        scheduleService.saveSchedule(schedule);
        return R.ok(null);
    }

    @PutMapping
    public R update(@RequestBody Schedule schedule){
        scheduleService.updateSchedule(schedule);
        return R.ok(null);
    }



}
