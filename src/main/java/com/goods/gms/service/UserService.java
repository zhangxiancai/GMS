package com.goods.gms.service;

import com.goods.gms.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    boolean createUser(String username,String password);

    List<User> showAllUsers();

}
