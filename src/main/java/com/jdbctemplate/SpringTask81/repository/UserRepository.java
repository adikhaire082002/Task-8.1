package com.jdbctemplate.SpringTask81.repository;

import com.jdbctemplate.SpringTask81.entity.User;

import java.util.List;

public interface UserRepository {
    int save(User user);
    User findById(Integer id);
    User findByName(String name);
    int update(User user);
    int delete(Integer id);
    List<User> findAll();
}
