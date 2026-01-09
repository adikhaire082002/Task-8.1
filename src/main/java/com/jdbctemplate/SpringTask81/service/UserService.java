package com.jdbctemplate.SpringTask81.service;

import com.jdbctemplate.SpringTask81.entity.User;

import java.util.List;

public interface UserService {

    String add(User user);
    User get(int id);
    User getByName(String name);
    String delete(int id);
    String update(User user);
    List<User> findAll();
}
