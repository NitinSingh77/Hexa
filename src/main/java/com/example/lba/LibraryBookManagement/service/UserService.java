package com.example.lba.LibraryBookManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lba.LibraryBookManagement.exception.InvalidCredentialsException;
import com.example.lba.LibraryBookManagement.model.User;
import com.example.lba.LibraryBookManagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to verify user login
    public User verifyLogin(String username, String password) throws InvalidCredentialsException {
        User user = userRepository.verifyLogin(username, password);
        if (user == null) {
            throw new InvalidCredentialsException("Invalid credentials provided.");
        }
        return user;
    }

	
}
