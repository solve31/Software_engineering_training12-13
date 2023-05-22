package com.example01.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example01.entity.User;
import com.example01.service.UserService;
import com.example01.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;
    //@CrossOrigin
    //@PostMapping(value = "/user/login")
    //@ResponseBody
    @PostMapping("/login")
    public Map login(@RequestBody User user) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(true,User::getUsername,user.getUsername());
        queryWrapper.eq(true,User::getPassword,user.getPassword());
        User user1=userService.getOne(queryWrapper);

        //为空则登录失败
        if(user1==null){
            HashMap<String, Object> responseData = new HashMap<>();
            HashMap<String, Object> response = new HashMap<>();
            response.put("code",20001);
            response.put("msg","登录失败");
            response.put("data",responseData);
            return response;
        }
        //制造token
        String token= JwtUtils.generateToken(user.getUsername());
        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("token",token);
        response.put("code",20000);
        response.put("msg","登录成功");
        response.put("data",responseData);
        return response;
    }

    //@CrossOrigin
    //@GetMapping(value = "/user/info")
    @GetMapping("/info")
    @ResponseBody
    public Map info() {
        HashMap<String, Object> responseInfo = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("roles","admin");
        responseData.put("name","Super admin");
        responseData.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        responseInfo.put("code",20000);
        responseInfo.put("msg","登录成功");
        responseInfo.put("data",responseData);
        return responseInfo;
    }
    //@CrossOrigin
    //@PostMapping(value = "/user/logout")
    @PostMapping("/logout")
    //@ResponseBody
    public Map logout() {
        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        response.put("code",20000);
        response.put("msg","退出成功");
        response.put("data",responseData);
        return response;
    }
}