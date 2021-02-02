package com.salom.vasalim.repository;

import com.salom.vasalim.demain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByUserName(String userUser);
}
