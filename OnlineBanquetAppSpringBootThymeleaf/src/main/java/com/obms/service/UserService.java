package com.obms.service;

import com.obms.dto.UserDto;
import com.obms.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
