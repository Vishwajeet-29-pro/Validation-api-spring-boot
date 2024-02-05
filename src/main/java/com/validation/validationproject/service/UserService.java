package com.validation.validationproject.service;

import com.validation.validationproject.Exception.UserNotFoundException;
import com.validation.validationproject.dto.UserRequest;
import com.validation.validationproject.entity.User;
import com.validation.validationproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest){
        User user = User.build(0,
                userRequest.getName(), userRequest.getEmail(),
                userRequest.getMobile(), userRequest.getGender(),
                userRequest.getNationality(), userRequest.getAge());
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if (user != null){
            return user;
        }
        throw new UserNotFoundException("User with the id "+id+" not found");
    }
}
