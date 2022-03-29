package com.rps.restservicecors.service;

import com.rps.restservicecors.dao.UserDao;
import com.rps.restservicecors.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("postgres") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    public User getUserById(UUID id) {
        return userDao.getUserById(id);
    }

    public int deleteUserById(UUID id) {
        return userDao.deleteUserById(id);
    }

    public int updateUserById(UUID id, User user) {
        return userDao.updateUserById(id, user);
    }
}
