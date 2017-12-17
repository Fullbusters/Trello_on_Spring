package com.trello.dao;


import com.trello.model.User_role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_roleRepository extends CrudRepository<User_role, Long> {
}
