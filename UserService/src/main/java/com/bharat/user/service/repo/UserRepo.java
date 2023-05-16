package com.bharat.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharat.user.service.entities.User;

public interface UserRepo extends JpaRepository<User, String> {

}
