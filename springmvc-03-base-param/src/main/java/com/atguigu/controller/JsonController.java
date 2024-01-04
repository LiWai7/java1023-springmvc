package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description: 接收前端传递的json数据
 */

@RestController
@RequestMapping("json")
public class JsonController {


    /**
     *
     *
     * 场景: 前端传递json数据,后台接收
     *
     *       http://localhost:8080/json/save  post
     *       请求体: {user_name:x,password:x,page:x,size:x}
     *
     * 准备:
     *      1.导入jackson的依赖 jackson-databind  [springmvc框架可以使用jackson的工具类]
     *      2. <mvc:annotation-driven /> 增强经理的json处理能力
     *
     *
     *      HTTP状态 415 - 不支持的媒体类型, 我们经理handlerAdapter不支持json格式处理!
     *      前端 -> ds -> handlerAdapter [requestBody -> jackson - > 对象 ] -> handler [json -> 对象]
     *
     * 接收:
     *     handler( 实体类 对象 | Map data  |  String jsonStr)
     *     自定义对象: 将json的属性映射到实体类的属性上! 要求: 实体类的属性名等于json的key [推荐] [好箱子]
     *          需要你提前创建实体类和指定对应的属性 [前置准备工作]
     *     map: 将json的key设置成map的key,jsonvalue设置成map对应的value [破箱子]
     *          不需要提前对应数据类型 直接使用jdk自带的map hashMap
     *     字符串: 整体接收json字符串,最终自己进行json字符串转化!!
     *
     *     handler(默认 -> param | 路径 -> @PathVariable | Json -> @RequestBody -> 对象|map|String)
     */
    @PostMapping("save1")
    public String save(@RequestBody User user){
        System.out.println("JsonController.save1");
        System.out.println("user = " + user);
        return "user = " + user;
    }

    @PostMapping("save2")
    public String save(@RequestBody Map data){
        System.out.println("JsonController.save2");
        System.out.println("data = " + data);
        return "data = " + data;
    }

    @PostMapping("save3")
    public String save(@RequestBody String json){
        System.out.println("JsonController.save3");
        System.out.println("json = " + json);
        return "json = " + json;
    }


}
