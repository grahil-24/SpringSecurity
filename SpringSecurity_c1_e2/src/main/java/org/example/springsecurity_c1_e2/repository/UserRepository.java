package org.example.springsecurity_c1_e2.repository;

import org.example.springsecurity_c1_e2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("""
      SELECT u from User u where u.username =:username
    """)
    Optional<User> findUserByUsername(String username);
}
