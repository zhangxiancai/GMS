package com.goods.gms.service.impl;

import com.goods.gms.dao.UserMapper;
import com.goods.gms.pojo.User;
import com.goods.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean createUser(String username, String password) {
        return userMapper.insert(username,password);
    }

    @Override
    public List<User> showAllUsers() {
        return userMapper.selectAllUsers();
    }
}
