package com.handmade.services;

import com.handmade.dao.UserDAOImpl;
import com.handmade.dao.UserRoleDAOImpl;
import com.handmade.model.User;
import com.handmade.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Matt on 2/6/18.
 */
@Service
@Transactional
public class AdminService {

    @Autowired
    private UserDAOImpl userRepo;

    @Autowired
    private UserRoleDAOImpl userRoleRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public List<UserRole> getAllUserRoles(){
        return userRoleRepo.findAll();
    }

}
