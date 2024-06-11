package com.ms.springboot_jwt_auth.services;

import com.ms.springboot_jwt_auth.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServices {
    private List<User> store = new ArrayList<>();

    public UserServices() {

        store.add(new User(UUID.randomUUID().toString(), "Chhaya", "ch@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Ankit", "a@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Shanya", "sh@gmail.com"));
    }

    public List<User> getUsers() {
        return this.store;
    }
}
