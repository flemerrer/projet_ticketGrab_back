package com.example.ticket_front.repository;

import com.example.ticket_front.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByIsAdmin(Boolean isAdmin);
    public User findByFirstNameUserAndLastNameUser(String firstNameUser, String lastNameUser);
    public User findByEmailUserAndPasswordUser(String emailUser, String lastNameUser);
    public User findByIdUser(Long IdUser);
}
