package com.tsc.iorder.dao;

import com.tsc.iorder.domain.User;
import org.springframework.stereotype.Component;

@Component("userMapper")
public interface UserMapper {
    User login(String username);

    User findUserById(String id);
}
