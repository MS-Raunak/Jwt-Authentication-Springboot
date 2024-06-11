package com.ms.springboot_jwt_auth.controller;

import com.ms.springboot_jwt_auth.model.User;
import com.ms.springboot_jwt_auth.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    UserServices services = new UserServices();

    //http://localhost:8080/home/users
    //Get all users
    @GetMapping("/users")
    public List<User> getUser() {
        return this.services.getUsers();
    }

    //http://localhost:8080/home/currentuser
    //Get Logged User
    @GetMapping("/currentuser")
    public String getLoggedUser(Principal principal) {
        return principal.getName();
    }
}
