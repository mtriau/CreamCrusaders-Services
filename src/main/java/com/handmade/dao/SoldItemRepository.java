package com.handmade.dao;

import com.handmade.model.SoldItem;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Matt on 3/5/19.
 */
public interface SoldItemRepository extends Repository<SoldItem, Integer>{

    void save(SoldItem soldProduct);
    SoldItem getSoldItemBySoldItemId(Integer soldItemId);
    List<SoldItem> getSoldItemByArtisanId(Integer artisanId);
    List<SoldItem> getSoldItemByItemId(Integer ItemId);

}
