package com.example.Loginform.repository;


import com.example.Loginform.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
      User findByUsernameAndPassword(String username, String password);

}