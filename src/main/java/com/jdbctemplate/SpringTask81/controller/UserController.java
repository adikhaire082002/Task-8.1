package com.jdbctemplate.SpringTask81.controller;

import com.jdbctemplate.SpringTask81.entity.User;
import com.jdbctemplate.SpringTask81.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Tag(name = "User Operations", description = "Operations related to user management")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    @Operation(
            summary = "Add a new user",
            description = "This endpoint allows adding a new user to the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid user data")
    })
    public ResponseEntity<?> addUser(@RequestBody User user){
        String add = userService.add(user);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(
            summary = "Update an existing user",
            description = "This endpoint allows updating the information of an existing user."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<?> updateUser(@RequestBody User user){
        String update = userService.update(user);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @Operation(
            summary = "Delete a user",
            description = "This endpoint allows deleting a user by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<?> deleteUser(@RequestParam
                                        @Parameter(description = "ID of the user to be deleted")
                                        int userId){
        String delete = userService.delete(userId);
        return new ResponseEntity<>(delete, HttpStatus.GONE);
    }

    @GetMapping("/getUser")
    @Operation(
            summary = "Get user by ID",
            description = "Retrieve a user from the database by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<?> getUser(
            @RequestParam
            @Parameter(description = "ID of the user to retrieve")
            int id){
        User user = userService.get(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping("/getUserByName")
    @Operation(
            summary = "Get user by name",
            description = "Retrieve a user from the database by their name."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<?> getUser(
            @RequestParam
            @Parameter(description = "Name of the user to retrieve")
            String name){
        User user = userService.getByName(name);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping("/allUsers")
    @Operation(
            summary = "Get all users",
            description = "Retrieve a list of all users from the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}