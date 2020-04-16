package com.tsc.iorder.service;

import com.tsc.iorder.dao.UserMapper;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    public List<User> list(SearchParam searchParam) {
        return mapper.list(searchParam);
    }

    public boolean addUser(User user) {
        int i = this.mapper.addUser(user);
        return i!=0;
    }

    public List<User> findImg(String img) {
        return this.mapper.findImg(img);
    }

    public boolean delete(SearchParam searchParam) {
        int i = this.mapper.delete(searchParam);
        return i!=0;
    }

    public List<User> findUsers(String username) {
        return this.mapper.findUsers(username);

    }

    public boolean update(User user) {
        int i = this.mapper.update(user);
        return i!=0;
    }

    public User findUserByUsername(User user) {
        return this.mapper.findUserByUsername(user);
    }

    public boolean updatePass(User user) {
        int i = this.mapper.updatePass(user);
        return i!=0;
    }

    public void updateState(SearchParam searchParam) {
        this.mapper.updateState(searchParam);
    }

    public void lock(SearchParam searchParam) {
        this.mapper.lock(searchParam);
    }

    public void unlock(SearchParam searchParam) {
        this.mapper.unlock(searchParam);
    }

    public void lockByRootId(int id) {
        this.mapper.lockById(id);
    }

    public void updateRate(User user) {
        this.mapper.updateRate(user);
    }
}
