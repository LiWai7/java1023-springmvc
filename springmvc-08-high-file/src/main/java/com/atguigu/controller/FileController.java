package com.atguigu.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * projectName: com.atguigu.controller
 *
 * @author: 赵伟风
 * description:
 */
@RestController
@RequestMapping("file")
public class FileController {

    @PostMapping("upload")
    public String upload(String account, @RequestParam("headImg") MultipartFile img){

        System.out.println(account);

        //文件需要转存 阿里oss 提供文件的字节数组
        //文件名 -》 后期转存的时候需要你指定文件名
        String fileName = img.getOriginalFilename();
        System.out.println("fileName = " + fileName);
        String name = img.getName();
        System.out.println("name = " + name);
        long size = img.getSize();
        System.out.println("size = " + size);

        //img.transferTo();

        return "file save success!!";

    }
}
