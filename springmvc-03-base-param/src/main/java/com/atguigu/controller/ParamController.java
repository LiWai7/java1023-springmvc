package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */

@ResponseBody
@Controller
@RequestMapping("param")
public class ParamController {

    /**
     * 场景1: 前端传递了账号和密码 param形式
     *        http://localhost:8080/param/data1? [ username=root&password=123456 ]
     *
     * 方式1: 形参列表,声明对应类型和对应命名的参数即可!
     *        handler(形参列表 默认接收的就是param参数)
     */
    @RequestMapping("data1")
    public String data1(String username,String password){
        System.out.println("ParamController.data1");
        System.out.println("username = " + username + ", password = " + password);
        return "username = " + username + ", password = " + password;
    }


    /**
     * 场景2: 前端传递了账号和密码 param形式
     *        http://localhost:8080/param/data2? [ user_name=root&password=123456&page=1&size=10]
     *
     *        user_name命名不太标准!
     *        page和size可能不传递,不传递有默认值 1 和 10
     *        要求密码必须有值password
     *
     * 方式2: 形参列表中添加一个注解 @RequestParam
     *      1. 参数名和形参名不同      @RequestParam(name|value="指定paramkey的名称") 一旦指定,形参名没有意义拉!
     *      2. 要求某个参数必须传递    @RequestParam(required = true) | @RequestParam 违背了400异常!
     *      3. 要求不传递,给与默认值   @RequestParam(required = false,defaultValue = "1") int page | @RequestParam(defaultValue = "10") int size
     *
     *       要求前端param的key必须等于handler(形参名)
     *       如果前端不传递,默认是null,应该使用基本类型的包装类型接收参数,避免500异常!
     *
     *       handler(@RequestParam(name | value , required , defaultValue = "" ))
     *
     */

    @RequestMapping("data2")
    public String data2(@RequestParam(value = "user_name") String username,
                        @RequestParam(required = true) String password,
                        @RequestParam(required = false,defaultValue = "1") int page,
                        @RequestParam(defaultValue = "10") int size){

        System.out.println("ParamController.data2");
        System.out.println("username = " + username + ", password = " + password + ", page = " + page + ", size = " + size);
        return "username = " + username + ", password = " + password + ", page = " + page + ", size = " + size;
    }



    /**
     * 场景3: 前端传递了账号和密码 param形式
     *        http://localhost:8080/param/data3? [ username=root&password=123456]
     * 方式3: 形参列表中添加一个实体对象
     *        1. 实体类的属性名,必须等于请求参数名,否则接收不到
     *        2. 想设置默认值,直接实体类的属性上 = 默认值即可
     *        3. 如果设置的属性.前端没有传递,那就是null
     */

    @RequestMapping("/data3")
    public String data3(User user){
        System.out.println("ParamController.data3");
        System.out.println("user = " + user);
        return user.toString();
    }


    /**
     * 场景4: 前端传递了账号和密码爱好 param形式
     *        http://localhost:8080/param/data4? [ username=root&password=123456&hbs=chi&hbs=he&hbs=wan]
     * 方式4: 接收集合类型 形参列表(@RequestParam  List<String> 参数名)
     *                    实体类对象
     *                           private List<String> hbs; //没有注解要求
     */
    @RequestMapping("data4")
    public String data4(String username, @RequestParam String password , @RequestParam List<String> hbs){
        System.out.println("username = " + username + ", password = " + password + ", hbs = " + hbs);
        return "username = " + username + ", password = " + password + ", hbs = " + hbs;
    }


    /**
     *
     *
     *  springmvc : 简化controller层的代码编写
     *
     *              //1.设置访问地址 @RequestMapping()
     *              handler(    2. 形参列表 -> 接收各种参数 [param | json | path | cookie ....]      ){
     *
     *                  return  3. 快速响应数据;
     *              }
     *
     *
     *             1. springmvc基本使用流程
     *             2. 如何设计handler的地址    @RequestMapping
     *             3. 如何接收参数 / param参数
     *
     *
     *
     *  param参数接收练习题:
     *
     *      场景: 实现用户模块的某些功能的控制层设计! 具体功能和参数传递要求如下!
     *            要求使用(形参列表+@RequestParam)实现以下功能
     *
     *      1. 登录功能
     *            8080/user/login?account=root&password=123456&type=admin|emp
     *
     *            账号和密码必须传递参数!
     *            type可能不传递,不传递默认值为emp!
     *
     *            @RequestMapping("login")
     *            public String login(@RequestParam String account ,
     *                                @RequestParam(required = true) String password ,
     *                                @RequestParam(defaultValue = "emp")String type )
     *      2. 注册功能
     *           8080/user/register?account=xxx&password=xxx&sex=xx&age=xxx&user_height=xxx&hbs=x&hbs=j
     *
     *           账号密码必须传递参数
     *           sex可能不传递,默认为男
     *           user_height使用java规范命名接收 userHeight
     *           hbs为一key多值
     *
     *           @RequestMapping("register")
     *           public String register(@RequestParam String account,@RequestParam String password,
     *                                  @ReqeustParam(defaultValue="男")String sex, Integer age,
     *                                  @RequestParam(name="user_height") Double userHeight,
     *                                  @RequestParam List<String> hbs
     *                                  )
     *      3. 用户分页查询功能
     *           8080/user/show?keyword=xx&page=1&size=10
     *
     *           @GetMapping("show")
     *           public String show(String keyword , @RequestParam(defaultValue="1") int page , @RequestParam(defaultValue="10") int size)
     *
     *           要求此接口只能使用get方式请求
     *           page不传递默认值为1
     *           size不传递默认值为10
     */


























}
















