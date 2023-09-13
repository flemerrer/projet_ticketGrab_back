package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findUserByIsAdmin(Boolean isAdmin);
    public User findUserByFirstNameAndLastName(String firstName, String lastName);
    public User findUserByEmailAndPassword(String email, String password);
    public User findUserById(Long id);
}
