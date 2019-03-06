package com.handmade.dao;

import com.handmade.model.ArtisanItem;
import org.springframework.data.repository.Repository;

/**
 * Created by Matt on 3/5/19.
 */
public interface ArtisanItemRepository extends Repository<ArtisanItem, Integer> {

    void save(ArtisanItem artisanItem);
    ArtisanItem getArtisanItemByItemId(Integer ItemId);


}
