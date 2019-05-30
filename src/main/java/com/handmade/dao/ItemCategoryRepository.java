package com.handmade.dao;

import com.handmade.model.ItemCategory;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Matt on 5/29/19.
 */
public interface ItemCategoryRepository extends Repository<ItemCategory, Integer> {
    List<ItemCategory> findAll();

}
