package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import com.example.demo.service.UserService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties.Json;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{email}")
    public UserEntity getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    /*@PostMapping("/login")
    public String loginUser(@RequestBody UserEntity user) {
        userService.loginUser(user);
        return "okey";
    }*/

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
        @RequestParam String email, 
        @RequestParam String password) {
        
        userService.loginUser(email, password);
        return ResponseEntity.ok("ok"); 
    }
    

    @GetMapping("/{id}/download")
    public ResponseEntity<ByteArrayResource> downloadFichier(@PathVariable Long id) {
        return userService.downloadFichier(id);
    }
}
