package com.gear.istio.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("info")
    public String info() {
        return "获取用户成功，用户信息：root";
    }
}
