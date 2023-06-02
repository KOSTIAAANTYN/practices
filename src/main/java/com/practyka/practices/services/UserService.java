package com.practyka.practices.services;

import com.practyka.practices.model.User;
import com.practyka.practices.model.enums.Role;
import com.practyka.practices.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public boolean createUser(User user){
        if(userRepository.findUserByEmail(user.getEmail())!=null)
            return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        //TODO password
        userRepository.save(user);

        return true;

    }
}
