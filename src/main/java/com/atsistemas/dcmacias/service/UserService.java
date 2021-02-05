package com.atsistemas.dcmacias.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import javax.inject.Singleton;

import com.atsistemas.dcmacias.dtos.UserDTO;

@Singleton
public class UserService {

    private Map<Long, UserDTO> userCache = new HashMap<>();

    public UserDTO create(String name, String lastName, Long phoneNumber) {
        UserDTO user = new UserDTO();
        userCache.put(phoneNumber, user);
        return user;
    }

    public Optional<UserDTO> update(Long phone,String name , String lastName) {
        Optional<UserDTO> optUser = findByPhone(phone);
        return optUser.map( user -> {
            user.setUsername(name);
            user.setLastname(lastName);
            return user;
        });
    }

    public Optional<UserDTO> findByPhone(Long id) {
    	
        return Optional.ofNullable(userCache.get(id));
    }

    public List<UserDTO> findAll() {
        return new ArrayList<>(userCache.values());
    }


   
}
