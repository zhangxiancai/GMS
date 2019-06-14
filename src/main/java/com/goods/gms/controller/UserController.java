package com.goods.gms.controller;

import com.goods.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/createUser")
    @ResponseBody
    public boolean createUser(String username, String password, Model model){

      return userService.createUser(username,password);
    }

    @RequestMapping("/")
    public String getMain(){

        return "index";
    }
}
