package com.web.user.sample_application.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.user.sample_application.controller.UpdateUserRequest;
import com.web.user.sample_application.model.User;
import com.web.user.sample_application.repository.ManagerRepository;
import com.web.user.sample_application.repository.UserRepository;

@Service
public class UserService  {
	
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private ManagerRepository managerRepository;

    private static final Pattern PAN_PATTERN = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^(?:\\+91|0)?([6789]\\d{9})$");

    public ResponseEntity<String> createUser(User user) {
        if (user.getFullName() == null || user.getFullName().isEmpty()) {
            return ResponseEntity.badRequest().body("Full name must not be empty");
        }
        if (!MOBILE_PATTERN.matcher(user.getMobNum()).matches()) {
            return ResponseEntity.badRequest().body("Invalid mobile number");
        }
        user.setMobNum(user.getMobNum().replaceAll("^(?:\\+91|0)", ""));

        user.setPanNum(user.getPanNum().toUpperCase());
        if (!PAN_PATTERN.matcher(user.getPanNum()).matches()) {
            return ResponseEntity.badRequest().body("Invalid PAN number");
        }
        if (user.getManagerId() != null && !managerRepository.existsById(UUID.fromString(user.getManagerId()))) {
            return ResponseEntity.badRequest().body("Invalid manager ID");
        }
        user.setUserId(UUID.randomUUID().toString());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(null);
        user.setActive(true);
        userRepository.save(user);
        return ResponseEntity.ok("User created successfully");
    }
    
    
    public List<User> getUsers(Map<String, String> filters) {
        if (filters == null || filters.isEmpty()) {
            return userRepository.findAll();
        }
        if (filters.containsKey("user_id")) {
            return userRepository.findById(filters.get("user_id")).map(Collections::singletonList).orElse(Collections.emptyList());
        }
        if (filters.containsKey("mob_num")) {
            return userRepository.findByMobNum(filters.get("mob_num"));
        }
        if (filters.containsKey("manager_id")) {
            return userRepository.findByManagerId(filters.get("manager_id"));
        }
        return Collections.emptyList();
        
    }
    
    public ResponseEntity<String> deleteUser(Map<String, String> request) {
        if (request.containsKey("user_id")) {
            userRepository.deleteById(request.get("user_id"));
            return ResponseEntity.ok("User deleted successfully");
        }
        if (request.containsKey("mob_num")) {
            List<User> users = userRepository.findByMobNum(request.get("mob_num"));
            userRepository.deleteAll(users);
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.badRequest().body("Invalid request");
    }
    
    
    public ResponseEntity<String> updateUser(UpdateUserRequest request) {
        List<User> users = userRepository.findAllById(request.getUserIds());
        if (users.isEmpty()) {
            return ResponseEntity.badRequest().body("No users found for the given IDs");
        }
        for (User user : users) {
            if (request.getUpdateData().containsKey("manager_id")) {
                String newManagerId = request.getUpdateData().get("manager_id");
                if (!managerRepository.existsById(UUID.fromString(newManagerId))) {
                    return ResponseEntity.badRequest().body("Invalid manager ID");
                }
                if (user.getManagerId() != null) {
                    user.setActive(false);
                    userRepository.save(user);
                    User newUser = new User(user);
                    newUser.setUserId(UUID.randomUUID().toString());
                    newUser.setManagerId(newManagerId);
                    newUser.setCreatedAt(LocalDateTime.now());
                    userRepository.save(newUser);
                } else {
                    user.setManagerId(newManagerId);
                    user.setUpdatedAt(LocalDateTime.now());
                    userRepository.save(user);
                }
            }
        }
        return ResponseEntity.ok("Users updated successfully");
    }

	
	
	 
}
