package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */


//@ResponseBody
//@Controller


@RestController

@RequestMapping("json")
public class JsonController {



    // /json/show -> [{},{},{name:xx}]

    /**
     *
     * 步骤1： 将返回的数据类型直接设置成handler的类型！
     * 步骤2： 方法必须被@ResponseBody
     *         handler -> 对象 | 集合 -> handlerAdapter  @ResponseBody 将数据给我装到响应体中，直接返回，不要找视图
     *                               -> handlerAdapter 进行对象 转成【默认就是json格式幻化】 字符
     */

    @RequestMapping("show")
    public List<User> show(){
        //数据
        User user = new User();
        user.setName("二狗子");

        User user1 = new User();
        user1.setName("氯弹弹");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        return userList;
    }

}
