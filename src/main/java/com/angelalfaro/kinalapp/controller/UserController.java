package com.angelalfaro.kinalapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angelalfaro.kinalapp.entity.User;
import com.angelalfaro.kinalapp.service.user.UserServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.listAllUsers();

        return ResponseEntity.ok(users);
    }

    //Get all the users by the state
    //Example.
    //if a user is banned state = 6
    //if a user is inactive state = 3 ...
    //etc
    @GetMapping("/state/{state}")
    public ResponseEntity<List<User>> getAllUsersByState(@PathVariable(name = "state") int state) {

        List<User> usersState = userService.listAllByState(state);

        return ResponseEntity.ok(usersState);
    }
    
    @GetMapping("/{codeUser}")
    public ResponseEntity<User> getUserByCode(@PathVariable(name = "codeUser") Long codeUser) {
        return userService.findByCodeUser(codeUser)
                //If Optional has a value, return status 200 ok with the user
                // :: call a method of a class
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        
        try {

            User u = userService.saveUser(user);

            return new ResponseEntity<>(u, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    
    @DeleteMapping("/{codeUser}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "codeUser") Long codeUser) {
        try {

            if (!userService.existsByCodeUser(codeUser)){
                return ResponseEntity.notFound().build();
            }

            userService.deleteUser(codeUser);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{codeUser}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "codeUser") Long codeUser,
            @RequestBody User user) {
                
        try {
            if (!userService.existsByCodeUser(codeUser)){
                return ResponseEntity.notFound().build();
            }

            User updUser = userService.updateUser(codeUser,user);

            return ResponseEntity.ok(updUser);


        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
