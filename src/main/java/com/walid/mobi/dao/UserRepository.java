package com.walid.mobi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walid.mobi.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
