package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("{id}")
    public User detail(@PathVariable int id){

        int i = 1/0;
        User user = new User();
        user.setId(id);
        user.setName("二狗哥");
        user.setAge(98);
        return user;
    }

    // 分页查询|条件模糊查询  List<User>  其他(修改 添加 删除): return "{status:ok}"
    @GetMapping
    public List<User> pageList(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue="10") int size){


        String name = null;
        name.toString();

        System.out.println("page = " + page + ", size = " + size);
        User user = new User();
        user.setId(1);
        user.setName("二狗哥");
        user.setAge(98);

        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }

    @PostMapping
    public String saveUser(@RequestBody User user){
        System.out.println("user = " + user);
        return "{status:'ok'}";
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        System.out.println("user = " + user);
        return "{status:'ok'}";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id){
        System.out.println("id = " + id);
        return "{status:'ok'}";
    }

    @GetMapping("search")
    public List<User> findSearch(String keyword,
                                 @RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue="10") int size){
        System.out.println("keyword = " + keyword + ", page = " + page + ", size = " + size);
        User user = new User();
        user.setId(1);
        user.setName("二狗哥");
        user.setAge(98);

        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }

}
