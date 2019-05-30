package com.handmade.services;

import com.google.gson.Gson;
import com.handmade.dao.ArtisanItemRepository;
import com.handmade.dao.ArtisanRepository;
import com.handmade.dao.SoldItemRepository;
import com.handmade.model.Artisan;
import com.handmade.model.ArtisanItem;
import com.handmade.model.SoldItem;
import com.handmade.util.ImageUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Matt on 12/4/18.
 */
@Service
@Transactional
public class ArtisanService {

    @Autowired
    ArtisanRepository artisanRepository;
    @Autowired
    S3Service s3Service;
    @Autowired
    SoldItemRepository soldItemRepository;
    @Autowired
    ArtisanItemRepository artisanItemRepository;

    public Artisan saveArtisan(Artisan artisan) {
        artisanRepository.save(artisan);
        for (ArtisanItem artisanItem : artisan.getArtisanItems()) {
            if (artisanItem.getImageId() != null && artisanItem.getEncodedImage() == null) {
                String imageId = artisanItem.getArtisanId().toString()+ "_" + artisanItem.getItemId().toString();
                artisanItem.setImageId(imageId);
                ImageUtil.saveEncodedString(artisanItem.getEncodedImage(), imageId);
            }
        }
        return artisan;
    }

    public Artisan getArtisanById(Integer artisanId) {
        Artisan a = artisanRepository.findByArtisanId(artisanId);
        Gson gson = new Gson();
        System.out.println(gson.toJson(a));
        List<ArtisanItem> artisanItems = new ArrayList<>();
        for (ArtisanItem item : a.getArtisanItems()) {
            if (item.getImageId() != null) {
                String encodedImage = ImageUtil.getImageStringByImgId(item.getImageId());
                item.setEncodedImage(encodedImage);
            }
            artisanItems.add(item);
        }
//        addSoldItems();
        a.setArtisanItems(artisanItems);
        return a;
    }

    private void addSoldItems(){
        System.out.println("Its running");
        Random rand = new Random();
        ArtisanItem ai = artisanItemRepository.getArtisanItemByItemId(3);
        ArtisanItem ai2 = artisanItemRepository.getArtisanItemByItemId(2);

        for (int i = 0; i < 150; i++) {
            SoldItem soldItem = new SoldItem();
            soldItem.setArtisanId(ai.getArtisanId());
            soldItem.setItemId(ai.getItemId());
            soldItem.setItemDescription(ai.getItemDescription());
            soldItem.setPrice(new BigDecimal(39.99));
            soldItem.setSoldItemId(0);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            timestamp.setDate(1);
            int randDaysToAdd = rand.nextInt(27);
            int randMonth = rand.nextInt(2) + 2;
            timestamp.setDate(timestamp.getDate() + randDaysToAdd);
            timestamp.setMonth(randMonth);
            soldItem.setDateSold(timestamp);
            soldItemRepository.save(soldItem);

        }
        System.out.println("Its Done");

    }

    public List<Artisan> getAllArtisans() {
        List<Artisan> artisans = artisanRepository.findAll();
        List<Artisan> artisans1 = new ArrayList<>();
        for (Artisan a : artisans) {
            List<ArtisanItem> artisanItems = new ArrayList<>();
            for (ArtisanItem item : a.getArtisanItems()) {
                if (item.getImageId() != null) {
                    String encodedImage = ImageUtil.getImageStringByImgId(item.getImageId());
                    item.setEncodedImage(encodedImage);
                }
                artisanItems.add(item);
            }
            a.setArtisanItems(artisanItems);
            artisans1.add(a);
        }
        return artisans1;
    }


}
