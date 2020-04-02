package com.tsc.iorder.dao;

import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    User login(String username);

    User findUserById(String id);

    List<User> list(SearchParam searchParam);

    int addUser(User user);
}
