package com.handmade.controllers;

import com.handmade.model.RestfulResponse;
import com.handmade.model.User;
import com.handmade.model.UserRole;
import com.handmade.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Matt on 2/6/18.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/users",method = RequestMethod.GET, produces = {"application/JSON"})
    public RestfulResponse getUsers(HttpServletRequest req){

        RestfulResponse response = new RestfulResponse();
        List<User> users;

        try{
            users = adminService.getAllUsers();
            response.setData(users);
            response.setSuccess(true);

        }
        catch(Exception e){
            response.setSuccess(false);
            response.setMessage("Unable to get users");

        }
        return response;
    }

    @RequestMapping(value = "/userRoles",method = RequestMethod.GET, produces = {"application/JSON"})
    public RestfulResponse getUserGroups(HttpServletRequest req){

        RestfulResponse response = new RestfulResponse();
        List<UserRole> userRoles;

        try{
            userRoles = adminService.getAllUserRoles();
            response.setData(userRoles);
            response.setSuccess(true);

        }
        catch(Exception e){
            response.setSuccess(false);
            response.setMessage("Unable to get user Roles");

        }
        return response;
    }
}
