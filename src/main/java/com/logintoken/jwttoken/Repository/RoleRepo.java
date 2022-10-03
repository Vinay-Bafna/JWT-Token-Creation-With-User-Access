package com.logintoken.jwttoken.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logintoken.jwttoken.Entity.Role;
public interface RoleRepo extends JpaRepository<Role,Integer> {

}
