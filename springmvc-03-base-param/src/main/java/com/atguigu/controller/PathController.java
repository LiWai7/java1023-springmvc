package com.atguigu.controller;

import com.atguigu.pojo.Xxx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description: 演示路径接受参数
 */


//@Controller
//@ResponseBody


@RestController
@RequestMapping("path")
public class PathController {

    /**
     *
     * 场景1: 路径传递单个参数
     *       http://localhost:8080/path/1  -> 动态的id值
     *               模糊路径: * [不对] **  确实是模糊,可以动态传递,但是无法接值!
     *                        {key}  == * 加了一个动态标识
     *       1.1 设置handler路径的时候,指定位是动态的!
     *             {key}  == * 加了一个动态标识
     *       1.2 利用Handler的形参列表接收路径参数
     *             handler(int id )  -> id -> param 注意: 形参列表的默认参数就是接收param的值! 死心眼子!!
     *             接收其他方向的值: path | json | cookie .... 添加指定的注解
     *
     *      细节:
     *         1. 如果形参名刚好等于 {key} 不用显示指定name或者value
     *            如果形参名不等于路径的key  name | value = "{key}"
     *         2. 也可以指定必须传递或者非必须传递 boolean required() default true;
     *         3. 他不能给默认值
     */

    @RequestMapping("{id}")
    public String data1( @PathVariable(value = "id") int idx ){
        System.out.println("id = " + idx);
        return "id = " + idx;
    }

    /**
     *
     * 场景2 路径传递多个参数
     *       http://localhost:8080/path/[x]/[j]  -> 动态的id值
     */
    @RequestMapping("{x}/{j}")
    public String data2(@PathVariable String j , @PathVariable("x") String xxx){
        System.out.println("PathController.data2");
        System.out.println("j = " + j + ", xxx = " + xxx);
        return "j = " + j + ", xxx = " + xxx;
    }

    /**
     *
     * 场景3 路径传递多个参数,虚实结合
     *       http://localhost:8080/path/[x]/id/[j]/type  -> 动态的id值
     */
    @RequestMapping("{x}/id/{j}/type")
    public String data3(@PathVariable String j , @PathVariable("x") String xxx){
        System.out.println("PathController.data3");
        System.out.println("j = " + j + ", xxx = " + xxx);
        return "j = " + j + ", xxx = " + xxx;
    }



    /**
     *
     * 场景4 路径传递多个参数,虚实结合 + param
     *       http://localhost:8080/path/[x]/path/[j]?id=1 -> 动态的id值
     */
    @RequestMapping("{x}/path/{j}")
    public String data4(@PathVariable String x , @RequestParam int id , @PathVariable String j){
        System.out.println("PathController.data4");
        System.out.println("x = " + x + ", id = " + id + ", j = " + j);
        return "x = " + x + ", id = " + id + ", j = " + j;
    }


    /**
     *
     * 场景5 路径传递多个参数,虚实结合 + param
     *       http://localhost:8080/path/[x]/path/[j]?id=1 -> 动态的id值
     *       能不能用实体类接呢???
     *          路径传递参数,不能使用实体类接收!!!
     *          handler(自定义类型 对象 -> param)
     *
     *    path和param的区别?
     *       1. path必须添加注解@PathVariable
     *       2. path需要使用{}设计动态路径
     *       3. path不能使用实体类接收参数
     */
    @RequestMapping("{x}/xxx/{j}")
    public String data5(@PathVariable String x , @PathVariable String j, Xxx xxx){
        System.out.println("PathController.data5");
        System.out.println("x = " + x + ", xxx = " + xxx + ", j = " + j);
        return "x = " + x + ", xxx = " + xxx + ", j = " + j;
    }

}















