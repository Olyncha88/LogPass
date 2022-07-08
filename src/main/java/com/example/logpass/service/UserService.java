package com.example.logpass.service;

import com.example.logpass.dao.UserDao;
import com.example.logpass.enteties.User;

import java.util.Collection;

public class UserService {
    private final UserDao dao;

    public UserService(){
        dao = new UserDao();
    }

    public User save(User user){
        return dao.save(user);
    }

    /*public User update(User user){
        return dao.update(user);
    }

    public User select(User user){
        return dao.select(user);
    }

    public Collection<User> getAll(){
        return dao.getAll();
    }

    public void delete(User user){
        dao.delete(user);
    }

    public boolean isRegistered(User user){
        return dao.findUserByEmailAndPassword(user).isPresent();
    }*/
}
