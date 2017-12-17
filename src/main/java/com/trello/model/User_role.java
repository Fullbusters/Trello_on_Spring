package com.trello.model;


import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class User_role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private long User_Id;
    @Column
    private long Role_id;

    public User_role() {
    }

    public User_role(long user_Id, long role_id) {
        User_Id = user_Id;
        Role_id = role_id;
    }

    public long getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(long user_Id) {
        User_Id = user_Id;
    }

    public long getRole_id() {
        return Role_id;
    }

    public void setRole_id(long role_id) {
        Role_id = role_id;
    }
}
