package com.logintoken.jwttoken.Repository;

import java.util.Optional;
import com.logintoken.jwttoken.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String Email);

}
