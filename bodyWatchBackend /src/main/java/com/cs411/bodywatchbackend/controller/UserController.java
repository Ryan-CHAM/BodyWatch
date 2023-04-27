package com.cs411.bodywatchbackend.controller;

import com.cs411.bodywatchbackend.model.User;
import com.cs411.bodywatchbackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId){
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @GetMapping("/users/id")
    public ResponseEntity<List<Integer>> getAllUserId(){
        return ResponseEntity.ok().body(userService.getAllUserId());
    }

    @PostMapping("/users")
    public HttpStatus createUser(@RequestBody User user){
        userService.createUsers(user);
        return HttpStatus.OK;
    }

    @PutMapping("/users/{userId}")
    public HttpStatus updateUser(@PathVariable int userId, @RequestBody User user){
        if (user.getUserId() != userId) {
            return HttpStatus.BAD_REQUEST;
        }
        else {
            userService.updateUser(user);
            return HttpStatus.OK;
        }
    }

    @DeleteMapping("/users/{userId}")
    public HttpStatus deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
        return HttpStatus.OK;
    }

}
