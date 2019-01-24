package com.handmade.dao;

import com.handmade.model.Role;

/**
 * Created by Matt on 1/29/18.
 */
public interface RoleDAO {
    Role findByName(String name);

}
