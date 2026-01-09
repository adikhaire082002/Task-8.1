package com.jdbctemplate.SpringTask81.controller;


import com.jdbctemplate.SpringTask81.entity.User;
import com.jdbctemplate.SpringTask81.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user ){
        String add = userService.add(user);
        return  new ResponseEntity<>(add,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        String update = userService.update(user);
        return  new ResponseEntity<>(update,HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam int userId){
        String delete = userService.delete(userId);
        return  new ResponseEntity<>(delete,HttpStatus.GONE);
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser(@RequestParam int id){
        User user = userService.get(id);
        return  new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping("/getUserByName")
    public ResponseEntity<?> getUser(@RequestParam String name){
        User user = userService.getByName(name);
        return  new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.findAll();
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }

}
