package com.handmade.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;


import com.handmade.identity.AuthUtil;
import com.handmade.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handmade.model.RestfulResponse;
import com.handmade.model.User;
import com.handmade.services.UserService;

@RestController
@RequestMapping("/api/authentication")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private AuthUtil authUtil;

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = { "application/json" })
	public RestfulResponse getUserInformation(@RequestParam(value = "name", required = false) String userIdParam,
			HttpServletRequest req) {

		String loggedInUserId = userService.getLoggedInUserId();

		User user;
		boolean provideUserDetails = false;

		if (userIdParam == null || userIdParam.equals("")) {
			provideUserDetails = true;
			user = userService.getLoggedInUser();
		} else if (loggedInUserId.equals(userIdParam)) {
			provideUserDetails = true;
			user = userService.getLoggedInUser();
		} else {
			// Check if the current user is superuser then provide the details
			// of requested user
			provideUserDetails = true;
			user = userService.getUserInfoByUserId(userIdParam);
		}

		RestfulResponse resp = new RestfulResponse();
		if (provideUserDetails) {
			resp.setSuccess(true);
		} else {
			resp.setSuccess(false);
			resp.setMessage("No Access");
		}
		resp.setData(user);
		return resp;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = { "application/json" })
	public RestfulResponse addNewUser(HttpServletRequest req, @RequestBody User user) {
		RestfulResponse resp = new RestfulResponse();
		try {
			userService.addNewUser(user);
			resp.setSuccess(true);
			resp.setMessage("User Added");
		}
		catch(Exception e){
			e.printStackTrace();
			resp.setSuccess(false);
			resp.setMessage("Unable to add user");
		}
		return resp;
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE, produces = { "application/json" })
	public RestfulResponse deleteUser(HttpServletRequest req, @PathParam("userId") Integer userId) {
		RestfulResponse resp = new RestfulResponse();
		try {
			userService.deleteUserById(userId);
			resp.setSuccess(true);
			resp.setMessage("User Added");

		}
		catch(Exception e){
			e.printStackTrace();
			resp.setSuccess(false);
			resp.setMessage("Unable to add user");
		}
		return resp;
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = { "application/json" })
	public RestfulResponse getUserById(HttpServletRequest req, @PathParam("userId") Integer UserId) {
		User user = userService.getUserInfoByUserId("1");
		RestfulResponse resp = new RestfulResponse();
		resp.setData(user);
		resp.setSuccess(true);

		return resp;
	}

	@RequestMapping(value = "/user/{userId}/group", method = RequestMethod.GET, produces = { "application/json" })
	public RestfulResponse getUserGroup(HttpServletRequest req, @PathParam("userId") Integer userId) {
		RestfulResponse resp = new RestfulResponse();
		try {
			UserRole userRole = userService.getUserGroupByUserId(1);
			resp.setData(userRole);
			resp.setSuccess(true);
		}
		catch(Exception e){
			e.printStackTrace();
			resp.setSuccess(false);
			resp.setMessage("Could not get user group");
		}
		return resp;

	}

	@RequestMapping(value = "/user/{userId}/group", method = RequestMethod.POST, produces = { "application/json" })
	public RestfulResponse setUserGroup(HttpServletRequest req, @PathParam("userId") Integer userId, @RequestBody Integer groupId) {
		RestfulResponse resp = new RestfulResponse();
		System.out.println(groupId);
		try {
			userService.setUserGroup(userId, groupId);
			resp.setSuccess(true);
			resp.setMessage("User group set");
		}
		catch(Exception e){
			e.printStackTrace();
			resp.setSuccess(false);
			resp.setMessage("Could not set user group");
		}
		return resp;

	}

}
