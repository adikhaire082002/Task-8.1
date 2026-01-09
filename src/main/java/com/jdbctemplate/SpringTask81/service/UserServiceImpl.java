package com.jdbctemplate.SpringTask81.service;

import com.jdbctemplate.SpringTask81.entity.User;
import com.jdbctemplate.SpringTask81.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements   UserService {
    @Autowired
    UserRepository userRepo;

    @Override
    public String add(User user) {
        try{
            userRepo.save(user);
            return "User Added Successfully";

        } catch (RuntimeException e) {
            return e.getMessage() +"\n User not added";
        }

    }

    @Override
    public User get(int id) {
        try{

            User user = userRepo.findById(id);
            return user;
        }catch(RuntimeException e){
            throw new RuntimeException("Something went wrong");
        }
    }

    @Override
    public User getByName(String name) {
        try{

            User user = userRepo.findByName(name);
            return user;
        }catch(RuntimeException e){
            throw new RuntimeException("Something went wrong");
        }
    }

    @Override
    public  String delete(int id) {
        try{
            userRepo.delete(id);
            return "User Deleted Successfully";
        }catch (RuntimeException e) {
            return e.getMessage() +"\n User not deleted";
        }

    }

    @Override  public String update(User user) {
        try{
            int update = userRepo.update(user);
            if(update == 1){
                return "User Updated Successfully";
            }
            return   "Something went wrong";
        }catch (RuntimeException e) {
            return e.getMessage() +"\n User not updated";
        }

    }

    @Override
    public List<User> findAll() {
        List<User> all = userRepo.findAll();
        return all;
    }
}
