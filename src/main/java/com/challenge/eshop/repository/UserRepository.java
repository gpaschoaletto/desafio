package com.challenge.eshop.repository;


import com.challenge.eshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    //@Query(value = "SELECT * FROM user where email = ? ", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
