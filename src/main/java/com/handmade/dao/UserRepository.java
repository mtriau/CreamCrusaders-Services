package com.handmade.dao;

import com.handmade.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Matt on 5/21/18.
 */
public interface UserRepository extends Repository<User, Integer> {
    void save(User user);
    List<User> findAll();
    User getUserByUserName(String username);
    User getUserByUserId(Integer userId);
}
