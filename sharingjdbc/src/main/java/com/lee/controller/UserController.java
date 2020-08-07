package com.lee.controller;

import com.lee.domain.UserPO;
import com.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/get")
    public void get(){
        System.out.println(userService.get(1).getName());
    }
    @RequestMapping("/insert")
    public void insert(){
        UserPO userPO=new UserPO();
        userPO.setName("小姐姐");
        userService.save(userPO);
    }

    @RequestMapping("/delete")
    public void delete(){
        userService.delete(1);
    }
}
