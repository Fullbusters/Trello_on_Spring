package com.trello.model;

import javax.persistence.*;

@Entity
@Table(name = "App_User")
public class AppUser {

    @Id
    @GeneratedValue
    @Column(name = "User_Id")
    private Long userId;
    @Column(name = "User_Name")
    private String userName;
    @Column(name = "Encrypted_Password")
    private String encryptedPassword;
    @Column(name = "Enabled")
    private Short enabled;

    public AppUser() {

    }

    public AppUser(Long userId, String userName, String encrytedPassword) {
        this.userId = userId;
        this.userName = userName;
        this.encryptedPassword = encrytedPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encryptedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encryptedPassword = encrytedPassword;
    }

    public Short getEnabled() {
        return enabled;
    }

    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return this.userName + "/" + this.encryptedPassword;
    }
}
