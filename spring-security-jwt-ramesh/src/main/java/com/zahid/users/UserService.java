package com.zahid.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        System.out.println(user.getId());
        User t = userRepository.findById(user.getId()).get();
        t = user;
        return userRepository.save(t);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
