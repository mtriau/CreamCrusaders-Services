package com.handmade.dao;

import com.handmade.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by Matt on 1/29/18.
 */
@Repository
public class RoleDAOImpl extends AbstractJpaDAO<Role> implements RoleDAO {

    public Role findByName(String name){
        Query q = entityManager.createQuery(
                "SELECT e FROM " + Role.class.getName() + " e WHERE name = :prop_name");
        q.setParameter("prop_name", name);
        return (Role) q.getSingleResult();
    }
}
