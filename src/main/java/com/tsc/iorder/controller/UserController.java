package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.User;
import com.tsc.iorder.service.UserService;
import com.tsc.iorder.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService service;
    public static String urlUser = "F:/ideaFile/Intelligent_ordering_system/IntelligentOrderingSystem/static/images/user";
    public static String dbUser = "/static/images/user/";
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
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam(map);
        PageHelper.startPage(searchParam.getStart(),searchParam.getPageSize());
        List<User> list =  this.service.list(searchParam);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        resMap.put("page",pageInfo);
        return resMap;
    }
    @RequestMapping("/upload")
    @ResponseBody
    public boolean upload(@RequestParam("file") MultipartFile file,User user) throws IOException {
        String fileName = FileUtil.saveFile(file, urlUser);
        user.setImg(dbUser+fileName);
        user.setPassword("123456");
        return this.service.addUser(user);
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestParam("updateFile") MultipartFile file,User user) throws IOException {
        Map<String, Object> resMap = this.service.findUser(String.valueOf(user.getId()));
        User u = (User) resMap.get("user");
        String[] img = u.getImg().split("/");
        File dir = new File(urlUser);
        String fileName = img[img.length-1];
        if (!u.getImg().equals(dbUser+file.getOriginalFilename())){
            fileName = FileUtil.saveFile(file, urlUser);
        }
        user.setImg(dbUser+fileName);
        boolean b = this.service.update(user);
        List<User> list = this.service.findImg(u.getImg());
        if (list==null||list.size()==0){
            FileUtil.deleteFile(dir,img[img.length-1]);
        }
        return b;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId(Integer.valueOf((String) map.get("id")));
        Map<String, Object> resMap = this.service.findUser((String) map.get("id"));
        User user = (User) resMap.get("user");
        String[] img = user.getImg().split("/");
        File dir = new File(urlUser);
        List<User> list = this.service.findImg(user.getImg());
        if (list!=null&&list.size()==1){
            FileUtil.deleteFile(dir,img[img.length-1]);
        }
        return this.service.delete(searchParam);
    }
    @RequestMapping("/isExit")
    @ResponseBody
    public boolean isExit(@RequestBody Map<String,Object> map){
        List<User> list =  this.service.findUsers((String)map.get("username"));
        Map<String, Object> resMap = this.service.findUser((String) map.get("id"));
        User user = (User) resMap.get("user");
        if (user.getUsername().equals(map.get("username"))){
           return true;
        }else {
            if (list!=null){
                if (list.size()!=0){
                    return false;
                }else {
                    return true;
                }
            }else {
                return true;
            }
        }
    }
}
