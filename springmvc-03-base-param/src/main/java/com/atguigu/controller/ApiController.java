package com.atguigu.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */

@RestController
@RequestMapping("api")
public class ApiController {

    //向session存储数据  save?id=x&name=root
    @RequestMapping("save")
    public String saveSession(String name , HttpSession session,int id){
        session.setAttribute("id",id);
        session.setAttribute("name",name);
        return "session save success!!";
    }

    //从session读取数据 get
    @RequestMapping("get")
    public String getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object name = session.getAttribute("name");
        Object id = session.getAttribute("id");
        return  name + ":" + id;
    }

}
