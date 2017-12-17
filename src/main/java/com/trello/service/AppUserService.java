package com.trello.service;


import com.trello.dao.UserRepository;
import com.trello.dao.User_roleRepository;
import com.trello.model.AppUser;
import com.trello.model.User_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AppUserService {

    @Autowired
    private UserRepository repository;


    @Autowired
    private User_roleRepository user_roleRepository;

    public void save(AppUser user){
        repository.save(user);
        User_role user_role=new User_role();
        user_role.setUser_Id(user.getUserId());
        user_role.setRole_id(2);
        user_roleRepository.save(user_role);

    }
}
