package com.atguigu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:  user/a  user/b
 */

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("a")
    public String  a(){
        System.out.println("UserController.a");
        return "aaa";
    }

    @GetMapping("b")
    public String  b(){
        System.out.println("UserController.b");
        return "bbb";
    }

}
