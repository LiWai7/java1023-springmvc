package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */
@Controller
public class HelloController {


    //handler处理器
    @ResponseBody
    @RequestMapping("/springmvc/hello")
    public String sayHello(){
        System.out.println("HelloController.sayHello");
        return "hello springmvc!!";
    }


}
