package com.web.user.sample_application.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.user.sample_application.model.User;
import com.web.user.sample_application.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/create_user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
	
	@PostMapping("/get_users")
    public ResponseEntity<List<User>> getUsers(@RequestBody(required = false) Map<String, String> filters) {
        return ResponseEntity.ok(userService.getUsers(filters));
    }
	
	@PostMapping("/delete_user")
    public ResponseEntity<String> deleteUser(@RequestBody Map<String, String> request) {
        return userService.deleteUser(request);
    }
	
    @PostMapping("/update_user")
    public ResponseEntity<String> updateUser(@RequestBody UpdateUserRequest request) {
        return userService.updateUser(request);
    }
	}


