package com.enverny.excel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enverny.excel.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
