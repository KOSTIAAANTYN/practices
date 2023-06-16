package com.practyka.practices.services;

import com.practyka.practices.model.User;
import com.practyka.practices.model.enums.Role;
import com.practyka.practices.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    public boolean createUser(User user){
        boolean result=false;
        if(userRepository.findUserByEmail(user.getEmail())!=null)
            return result;
        if(user.getEmail()==null){
            return result;
        }
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return true;

    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void banUser(Long id){
        User user=userRepository.findById(id).orElse(null);
        if(user!=null){
            user.setActive(!user.isActive());
        }
        userRepository.save(user);
    }
}
