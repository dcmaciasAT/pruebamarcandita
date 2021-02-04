package com.atsistemas.dcmacias.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.inject.Singleton;

import com.atsistemas.dcmacias.dtos.UserDto;

@Singleton
public class UserService {

    private Map<Long, UserDto> userCache = new HashMap<>();

    public UserDto create(String name, String lastName, long phoneNumber) {
        UserDto user = new UserDto(name, lastName, phoneNumber);
        userCache.put(phoneNumber, user);
        return user;
    }

    public Optional<UserDto> update(long phone,String name , String lastName) {
        Optional<UserDto> optUser = findByPhone(phone);
        return optUser.map( user -> {
            user.setName(name);
            user.setLastName(lastName);
            return user;
        });
    }

    public Optional<UserDto> findByPhone(long id) {
        return Optional.ofNullable(userCache.get(id));
    }

    public List<UserDto> findAll() {
        return new ArrayList<>(userCache.values());
    }

    public Optional<UserDto> remove(String id) {
        return Optional.ofNullable(userCache.remove(id));
    }

   
}
