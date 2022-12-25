package com.zahid.users;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService; // better idea

    @GetMapping
    public List<User> getAllUser() {
        logger.info("Users:", userService.getAllUsers());
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        logger.info("User", userService.getUser(id));
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        logger.info("Updated User = {}", user);
        userService.updateUser(user);
        return ResponseEntity.ok("User Updated");
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        logger.info("New User = {}", user);
        userService.addUser(user);
        return ResponseEntity.ok("User Added");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        logger.info("User Id = {}", id);
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted");
    }
}