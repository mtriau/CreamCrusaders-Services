package com.handmade.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.handmade.model.User;

@Repository
public class UserDAOImpl extends AbstractJpaDAO<User>{
	
	public User getUserByUserName(String userName){
		Query q = entityManager.createQuery(
				"SELECT e FROM " + User.class.getName() + " e WHERE username  = :prop");
	   	q.setParameter("prop", userName);
	   	User user1 = (User) q.getSingleResult();
		return (User) q.getSingleResult();
	}
	public User findByEmail(String email){
		Query q = entityManager.createQuery(
				"SELECT e FROM " + User.class.getName() + " e WHERE email  = :prop");
		q.setParameter("prop", email);
		return (User) q.getSingleResult();
	}
	
}
