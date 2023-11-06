package com.vff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vff.entity.User;


public interface UserRespository extends JpaRepository<User, Long> {

}
