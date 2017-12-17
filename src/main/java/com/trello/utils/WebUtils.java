package com.trello.utils;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class WebUtils {

    public static String toString(User user){
        StringBuilder sb=new StringBuilder();

        sb.append("UserName").append(user.getUsername());

        Collection<GrantedAuthority> authories=user.getAuthorities();
        if(authories!=null && !authories.isEmpty()){
            sb.append("(");
            boolean first=true;
            for (GrantedAuthority a:authories){
                if(first){
                    sb.append(a.getAuthority());
                    first=false;
                }else {
                    sb.append(",").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();

    }
}
