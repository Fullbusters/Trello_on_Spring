package com.trello.service;


import com.trello.dao.UserRepository;
import com.trello.dao.UserRoleRepository;
import com.trello.model.AppUser;
import com.trello.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AppUserService {

    @Autowired
    private UserRepository repository;


    @Autowired
    private UserRoleRepository user_roleRepository;

    public void save(AppUser user){
        repository.save(user);
        UserRole user_role=new UserRole();
        user_role.setUserId(user.getUserId());
        user_role.setRoleId(2);
        user_roleRepository.save(user_role);

    }
}
