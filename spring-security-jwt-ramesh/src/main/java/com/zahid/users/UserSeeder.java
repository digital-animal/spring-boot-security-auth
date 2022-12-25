package com.zahid.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(UserSeeder.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    @Deprecated
    public void loadSeedData() {
        if(userRepository.count() == 0) {
            User user1 = new User("Alex", "Lee", "alex.lee@gmail.com", "123");
            User user2 = new User("Lee", "Cooper", "lee.cooper@gmail.com", "123");
            User user3 = new User("John", "Doe", "john.doe@gmail.com", "123");
            User user4 = new User("Zahid", "Jewel", "zahid.jewel@gmail.com", "123");
            User user5 = new User("Asif", "Hasan", "asif.hasan@gmail.com", "123");

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
            userRepository.save(user5);
        }

        logger.info("Number of user(s): {}", userRepository.count());
    }
    
}
