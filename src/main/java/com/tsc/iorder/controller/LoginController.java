package com.tsc.iorder.controller;

import com.tsc.iorder.domain.User;
import com.tsc.iorder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private UserService service;
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody Map<String,Object> map, HttpServletResponse response){
        Map<String, Object> resMap = this.service.login(map);
        if (resMap!=null&&resMap.get("user")!=null){
            User user = (User) resMap.get("user");
            Cookie cookie = new Cookie("userID", String.valueOf(user.getId()) );
            cookie.setMaxAge(24*3600);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            Cookie cookieRoot = new Cookie("root", String.valueOf(user.getRoot()));
            cookieRoot.setMaxAge(24*3600);
            cookieRoot.setDomain("localhost");
            cookieRoot.setPath("/");
            response.addCookie(cookieRoot);
        }
        return resMap;
    }
    @RequestMapping("/isExit")
    @ResponseBody
    public Map<String,Object> isExit(@RequestBody Map<String,Object> map){
        return this.service.isExit(map);
    }
    @RequestMapping("/notLogin")
    @ResponseBody
    public void notLogin(HttpServletResponse response){
       Cookie cookie = new Cookie("userID",null);
       cookie.setMaxAge(0);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);
        Cookie cookieRoot = new Cookie("root", null);
        cookieRoot.setMaxAge(0);
        cookieRoot.setDomain("localhost");
        cookieRoot.setPath("/");
        response.addCookie(cookieRoot);
    }
    @RequestMapping("/isLogin")
    @ResponseBody
    public Map<String,Object> isLogin(HttpServletRequest request){
        boolean b = false;
        Map<String,Object> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userID")){
                if (cookie.getValue()!=null&&!cookie.getValue().equals("")){
                     map = this.service.findUser(cookie.getValue());
                    b = true;
                }
            }
        }
        map.put("isLogin",b);
        return map;
    }
}
