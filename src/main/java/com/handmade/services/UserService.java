package com.handmade.services;

import com.handmade.dao.SoldItemRepository;
import com.handmade.dao.UserRepository;
import com.handmade.dao.UserRoleDAOImpl;
import com.handmade.model.Artisan;
import com.handmade.model.SoldItem;
import com.handmade.model.UserRole;
import com.handmade.dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmade.model.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

  @Autowired
  private UserDAOImpl userRepo;
  @Autowired
  private SoldItemRepository soldItemRepository;
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserRoleDAOImpl userRoleRepo;

  	public UserRole getUserGroupByUserId(Integer userId){
  		return userRoleRepo.findOne(userId);
	}
	public void setUserGroup(Integer userId, Integer groupId){
  		UserRole userRole = userRoleRepo.findOne(userId);

  		userRole.setRoleId(groupId);
  		userRoleRepo.update(userRole);
	}

	public String getLoggedInUserId(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth==null){
            return "nosession";
        }
		return auth.getName();
	}


	public User getLoggedInUser() {
		String loggedInUserId = this.getLoggedInUserId();
		System.out.format("\n1. Inside >> getLoggedInUser: %s", loggedInUserId);
		User user = this.getUserInfoByUserId(loggedInUserId);
		System.out.format("\n2. After Find User: %s", loggedInUserId);
		return user;
	}

	public User getUserInfoByUserId(String userId){
			User user = this.userRepo.findOne(Integer.valueOf(userId));
			if(user == null){
				user = new User();
			}
			return user;
	}

	public boolean insertOrSaveUser(User user) {
		this.userRepo.save(user);
		return true;
	}


	public User addNewUser(User user) {
		return this.userRepo.save(user);
	}
	public void deleteUserById(Integer id) {
		this.userRepo.deleteById(id);
	}
	public User getUserByUserId(Integer userId) {
		return userRepo.findOne(userId);
	}

}
