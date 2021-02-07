package com.seyithandilek.springsecurityjwt;

import com.seyithandilek.springsecurityjwt.entity.User;
import com.seyithandilek.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    private final UserRepository userRepository;

    @Autowired
    public SpringSecurityJwtApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostConstruct
    public void initUsers(){
        List<User> users= Stream.of(
                new User(101,"seyit","password","ssseyit.65@gmail.com"),
                new User(102,"user1","user1","user1@gmail.com"),
                new User(103,"user2","user2","user2@gmail.com"),
                new User(104,"user3","user3","user3@gmail.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

}
