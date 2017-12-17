package com.trello.dao;

import com.trello.mapper.UserMapper;
import com.trello.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


@Repository
@Transactional
public class UserDao extends JdbcDaoSupport {

    @Autowired
    public UserDao(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public AppUser findUserAccount(String userName){

        String sql= UserMapper.BASE_SQL+"where u.User_Name=?";

        Object[] params=new Object[]{userName};
        UserMapper mapper=new UserMapper();
        try{
            AppUser userinfo=this.getJdbcTemplate().queryForObject(sql,params,mapper);
            return userinfo;
        }catch (EmptyResultDataAccessException e){
            return null;
        }


    }


}
