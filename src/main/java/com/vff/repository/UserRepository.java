package com.vff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vff.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
