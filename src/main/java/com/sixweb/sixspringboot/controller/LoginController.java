package com.sixweb.sixspringboot.controller;

import com.sixweb.sixspringboot.pojo.User;
import com.sixweb.sixspringboot.result.Result;
import com.sixweb.sixspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public Result login(@RequestBody User requestUser, HttpServletRequest request, HttpServletResponse response){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = userService.get(username,requestUser.getPassword());
        HttpSession httpSession = request.getSession();
        if(null==user){
            String message = "invalid username or password";
            return new Result(400);
        }else {
            httpSession.setAttribute("user"+username,user);
            Object u = httpSession.getAttribute("user"+username);
            String i = httpSession.getId();
            return new Result(200);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/logout")
    @ResponseBody
    public Result loginOut(@RequestBody User requestUser, HttpServletRequest request, HttpServletResponse response){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        HttpSession httpSession = request.getSession();
        String i = httpSession.getId();
        Object user = httpSession.getAttribute("user"+username);
        if(user!=null){
            httpSession.removeAttribute("user"+username);
            return  new Result(200);
        }else {
            return new Result(400);
        }
    }

}
