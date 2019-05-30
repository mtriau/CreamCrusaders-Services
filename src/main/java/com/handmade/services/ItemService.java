package com.handmade.services;

import com.handmade.dao.ArtisanItemRepository;
import com.handmade.dao.ArtisanRepository;
import com.handmade.dao.ItemCategoryRepository;
import com.handmade.dao.SoldItemRepository;
import com.handmade.model.Artisan;
import com.handmade.model.ArtisanItem;
import com.handmade.model.ItemCategory;
import com.handmade.model.SoldItem;
import com.handmade.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    public List<ItemCategory> getAllItemCategories() {
        return itemCategoryRepository.findAll();
    }

    public ArtisanItem getArtisanItemById(Integer artisanItemId) {
        return artisanItemRepository.getArtisanItemByItemId(artisanItemId);
    }
    public ArtisanItem saveArtisanItem(ArtisanItem artisanItem) {
        artisanItemRepository.save(artisanItem);
        if (artisanItem.getEncodedImage() != null) {
            String imageId = artisanItem.getArtisanId().toString()+ "_" + artisanItem.getItemId().toString();
            artisanItem.setImageId(imageId);
            ImageUtil.saveEncodedString(artisanItem.getEncodedImage(), imageId);
        }
        artisanItemRepository.save(artisanItem);
        return artisanItem;
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
