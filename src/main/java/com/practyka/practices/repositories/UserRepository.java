package com.practyka.practices.repositories;

import com.practyka.practices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);

}
