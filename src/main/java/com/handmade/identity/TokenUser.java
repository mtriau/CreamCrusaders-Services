package com.handmade.identity;


import com.handmade.model.User;
import com.handmade.model.UserRole;

import java.util.Collection;
import java.util.List;


public class TokenUser extends org.springframework.security.core.userdetails.User {
    private User user;

    //For returning a normal user
    public TokenUser(User user) {

        super(user.getUserName(), user.getPassword(), true, true, true,
                true, AuthUtil.getAuthorities(user.getRoles()));
        //super(user.getUserName(), user.getPassword(), true, true, true, true,  AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }
    public TokenUser(User user, List<String> roles) {

        super(user.getUserName(), user.getPassword(), true, true, true,
                true, AuthUtil.getGrantedAuthorities(roles));
        //super(user.getUserName(), user.getPassword(), true, true, true, true,  AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Collection<UserRole> getRoles() {

        return user.getRoles();
    }
}
