package com.handmade.services;

import com.handmade.dao.ArtisanItemRepository;
import com.handmade.dao.ArtisanRepository;
import com.handmade.dao.SoldItemRepository;
import com.handmade.model.Artisan;
import com.handmade.model.ArtisanItem;
import com.handmade.model.SoldItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 3/5/19.
 */
@Service
@Transactional
public class ItemService {
    @Autowired
    SoldItemRepository soldItemRepository;
    @Autowired
    ArtisanItemRepository artisanItemRepository;
    @Autowired
    ArtisanRepository artisanRepository;

    public ArtisanItem getArtisanItemById(Integer artisanItemId) {
        return artisanItemRepository.getArtisanItemByItemId(artisanItemId);
    }
    public Integer saveArtisanItem(ArtisanItem artisanItem) {
        artisanItemRepository.save(artisanItem);
        return artisanItem.getItemId();
    }

    public SoldItem getSoldItemById(Integer soldItemId) {
        return soldItemRepository.getSoldItemBySoldItemId(soldItemId);
    }
    public List<SoldItem> getSoldItemsByItemId(Integer itemId) {
        return soldItemRepository.getSoldItemByItemId(itemId);
    }
    public List<SoldItem> getSoldItemsByArtisanId(Integer artisanId) {
        return soldItemRepository.getSoldItemByArtisanId(artisanId);
    }
    public Integer saveSoldItem(SoldItem soldItem) {
        soldItemRepository.save(soldItem);
        return soldItem.getSoldItemId();
    }

    public List<SoldItem> getSoldItemsByUser(Integer userId) {
        List<Artisan> artisans = artisanRepository.findAll();
        List<SoldItem> soldItems = new ArrayList<>();
        for (Artisan a : artisans) {
            List<SoldItem> artisanSoldItems  = soldItemRepository.getSoldItemByArtisanId(a.getArtisanId());
            soldItems.addAll(artisanSoldItems);
        }
        return soldItems;
    }

}
