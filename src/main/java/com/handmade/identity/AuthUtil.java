package com.handmade.identity;

import com.google.gson.Gson;
import com.handmade.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Matt on 1/26/18.
 */
@Service
public class AuthUtil {


    public static List<String> getRoles(Collection<UserRole> roles){
        List<String> privileges = new ArrayList<String>();
        Iterator<UserRole> iterator = roles.iterator();
        while(iterator.hasNext()){
            privileges.add(iterator.next().getName());
        }
        return privileges;

    }

    public static Collection<? extends GrantedAuthority> getAuthorities(
            Collection<UserRole> roles) {

        List<String> privileges = new ArrayList<String>();
        Iterator<UserRole> iterator = roles.iterator();
        Gson gson = new Gson();

        while(iterator.hasNext()){
            privileges.add(iterator.next().getName());
        }

        return getGrantedAuthorities(privileges);
    }


    public static List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
