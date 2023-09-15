package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findUserByIsAdmin(Boolean isAdmin);
    public User findUserByFirstNameAndLastName(String firstName, String lastName);
    public Optional<User> findUserByEmail(String email);
    public User findUserByEmailAndPassword(String email, String password);
    public User findUserByFirstName(String firstName);
    public User findUserById(Long id);
}
