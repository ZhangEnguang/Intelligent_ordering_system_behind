package com.tsc.iorder.service;

import com.tsc.iorder.dao.UserMapper;
import com.tsc.iorder.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public Map<String,Object> login(Map<String,Object> map) {
        Map<String,Object> resMap= new HashMap<>();
        if (map.get("username")!=null&&!map.get("username").equals("")){
            String username = (String) map.get("username");
            User user = mapper.login(username);
            if (user!=null&&user.getPassword().equals(map.get("password"))){
                resMap.put("res",true);
                resMap.put("user",user);
                return resMap;
            }else {
                return null;
            }
        }else {
            return null;
        }



    }

    public Map<String, Object> isExit(Map<String, Object> map) {
        User user = this.mapper.login((String)map.get("username"));
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("user",user);
        return resMap;
    }

    public Map<String, Object> findUser(String id) {
        Map<String,Object> resMap = new HashMap<>();
        User user = this.mapper.findUserById(id);
        resMap.put("user",user);
        return resMap;
    }
}
