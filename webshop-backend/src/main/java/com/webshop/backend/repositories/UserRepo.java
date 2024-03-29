package com.webshop.backend.repositories;

import com.webshop.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String userName, String password);

    User findByUsername(String userName);

}
