package com.example01.controller;

import com.example01.entity.User;
import com.example01.utils.JwtUtils;
import com.example01.utils.R;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

//@RestController
@RequestMapping("/user")
public class UserController {
    /*
    @PostMapping("/login")
    public R login(@RequestBody User user){
        System.out.println(user.toString());
        //制造token
        String token= JwtUtils.generateToken(user.getUsername());
        return R.ok().date("token",token);
    }
    @GetMapping("/info")
    public R info(String token){
        String username=JwtUtils.getClaimsByToken(token).getSubject();
        String url="https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif";
        return R.ok().date("name",username).date("avtar",url);
    }
    @PostMapping("/logout")
    public R logout(){
        return R.ok();
    }
     */
}
