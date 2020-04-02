package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Carousel;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userMapper")
public interface UserMapper {
    User login(String username);

    User findUserById(String id);

    List<User> list(SearchParam searchParam);

    int addUser(User user);
}
