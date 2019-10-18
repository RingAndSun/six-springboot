package com.sixweb.sixspringboot.controller;

import com.sixweb.sixspringboot.pojo.User;
import com.sixweb.sixspringboot.result.Result;
import com.sixweb.sixspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;
/**
 * Created by RogueMonkey on 2019/10/18.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if(null==userService.get(username,requestUser.getPassword())){
            String message = "invalid username or password";
            return new Result(400);
        }else {
            return new Result(200);
        }
    }
}
