package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.User;
import com.tsc.iorder.domain.Vip;
import com.tsc.iorder.service.UserService;
import com.tsc.iorder.service.VipService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private VipService vipService;
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
        List<User> users = this.service.findUsers(user.getUsername());
        if (users!=null&&users.size()!=0){
            return false;
        }
        String fileName = FileUtil.saveFile(file, urlUser);
        user.setImg(dbUser+fileName);
        user.setPassword("123456");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        user.setDate(format);
        return this.service.addUser(user);
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestParam("updateFile") MultipartFile file,User user) throws IOException {
        List<User> users = this.service.findUsers(user.getUsername());
        Map<String, Object> userMap = this.service.findUser(String.valueOf(user.getId()));
        User resUser = (User) userMap.get("user");
        if (!resUser.getUsername().equals(user.getUsername())){
            if (users!=null&&users.size()!=0){
                return false;
            }
        }
        String[] img = resUser.getImg().split("/");
        File dir = new File(urlUser);
        String fileName = img[img.length-1];
        if (!resUser.getImg().equals(dbUser+file.getOriginalFilename())){
            fileName = FileUtil.saveFile(file, urlUser);
        }
        user.setImg(dbUser+fileName);
        boolean b = this.service.update(user);
        List<User> list = this.service.findImg(resUser.getImg());
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
    @RequestMapping("/checkName")
    @ResponseBody
    public Map<String,Object> checkName(@RequestBody Map<String,Object> map){
        User user = new User();
        Map<String,Object> resMap = new HashMap<>();
        user.setUsername((String) map.get("username"));
        User resUser =  this.service.findUserByUsername(user);
        resMap.put("user",resUser);
        return resMap;
    }
    @RequestMapping("/updatePass")
    @ResponseBody
    public boolean updatePass(@RequestBody Map<String,Object> map){
        User user = new User();
        user.setUsername((String) map.get("username"));
        User resUser =  this.service.findUserByUsername(user);
        if (!resUser.getName().equals(map.get("name"))){
            return false;
        }else {
            user.setPassword((String) map.get("password"));
            return this.service.updatePass(user);
        }

    }
    @RequestMapping("/updateState")
    @ResponseBody
    public void updateState(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId(Integer.valueOf((String) map.get("id")));
        searchParam.setEvent((int) map.get("event"));
        this.service.updateState(searchParam);
    }
    @RequestMapping("/lock")
    @ResponseBody
    public void lock(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId(Integer.valueOf((String) map.get("id")));
        this.service.lock(searchParam);
    }
    @RequestMapping("/unlock")
    @ResponseBody
    public void unlock(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId(Integer.valueOf((String) map.get("id")));
        this.service.unlock(searchParam);
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
    @RequestMapping("/updateRate")
    @ResponseBody
    public Map<String,Object> updateRate(@RequestBody Map<String,Object> map){
        String phone = (String) map.get("phone");
        Map<String,Object> resMap = new HashMap<>();
        Vip byPhone = null;
        if (phone!=null&&!phone.equals("")){
            byPhone = this.vipService.findByPhone(phone);
        }
        resMap.put("vip",byPhone);
        User user = new User();
        user.setId((String) map.get("uid"));
        user.setserviceGrade(Double.valueOf((String) map.get("value")));
        this.service.updateRate(user);
        return resMap;
    }
}
