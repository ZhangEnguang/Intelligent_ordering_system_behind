package com.tsc.iorder.controller;

import com.tsc.iorder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("/findUser")
    @ResponseBody
    public Map<String,Object> findUser(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String id = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userID")){
                id = cookie.getValue();
            }
        }
       return this.service.findUser(id);

    }
}
