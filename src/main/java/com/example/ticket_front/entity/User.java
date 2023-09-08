package com.example.ticket_front.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String firstNameUser;
    private String lastNameUser;
    private String emailUser;
    private String passwordUser;
    private Boolean isAdmin;
    private Integer soldTicketsNumber;

    public User() {
    }

    public User(String firstNameUser, String lastNameUser, String emailUser, String passwordUser) {
        this.firstNameUser = firstNameUser;
        this.lastNameUser = lastNameUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFirstNameUser() {
        return firstNameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        this.firstNameUser = firstNameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getSoldTicketsNumber() {
        return soldTicketsNumber;
    }

    public void setSoldTicketsNumber(Integer soldTicketsNumber) {
        this.soldTicketsNumber = soldTicketsNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstNameUser='" + firstNameUser + '\'' +
                ", lastNameUser='" + lastNameUser + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                ", isAdmin=" + isAdmin +
                ", soldTicketsNumber=" + soldTicketsNumber +
                '}';
    }
}
