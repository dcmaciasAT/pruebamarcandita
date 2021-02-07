package com.atsistemas.dcmacias.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.inject.Singleton;

import com.atsistemas.dcmacias.domain.Contact;
import com.atsistemas.dcmacias.domain.User;

@Singleton
public class UserService {

    private Map<Long, User> userCache = new HashMap<>();

    public UserDto create(String name, String lastName, Long phoneNumber) {
        User user = new User();
        userCache.put(phoneNumber, user);
        return user;
    }

    public Optional<User> updateContacts(Long phone,Set<Contact> contacts) {
        Optional<User> optUser = findByPhone(phone);
        return optUser.map( user -> {
            user.setContacts(contacts);
            return user;
        });
    }

    public Optional<User> findByPhone(Long id) {
    	
        return Optional.ofNullable(userCache.get(id));
    }

    public List<User> findAll() {
        return new ArrayList<>(userCache.values());
    }


   
}
