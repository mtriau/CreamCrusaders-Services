package com.handmade.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.handmade.model.*;
import com.handmade.services.ItemService;
import com.handmade.services.MessagingService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 3/5/19.
 */

@RestController
@RequestMapping("/api/artisan-item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/sold-item/artisan-id/{artisanId}", method = RequestMethod.GET, produces = { "application/json" })
    public RestfulResponse getSoldItemsByArtisanId(HttpServletRequest req, @PathVariable Integer artisanId) {
        RestfulResponse resp = new RestfulResponse();
        List<SoldItem> soldItems;
        try {
            soldItems = itemService.getSoldItemsByArtisanId(artisanId);
            resp.setSuccess(true);
            resp.setData(soldItems);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Unable to find artisan");
        }
        return resp;
    }

    @RequestMapping(value = "/sold-item/user-id/{userId}", method = RequestMethod.GET, produces = { "application/json" })
    public RestfulResponse getSoldItemsByUserId(HttpServletRequest req, @PathVariable Integer userId) {
        RestfulResponse resp = new RestfulResponse();
        List<SoldItem> soldItems;
        try {
            soldItems = itemService.getSoldItemsByUser(userId);
            resp.setSuccess(true);
            resp.setData(soldItems);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Unable to find items");
        }
        return resp;
    }

    @RequestMapping(value = "/sold-item/item-id/{itemId}", method = RequestMethod.GET, produces = { "application/json" })
    public RestfulResponse getSoldItemsByItemId(HttpServletRequest req, @PathVariable Integer itemId) {
        RestfulResponse resp = new RestfulResponse();
        List<SoldItem> soldItems;
        try {
            soldItems = itemService.getSoldItemsByItemId(itemId);
            resp.setSuccess(true);
            resp.setData(soldItems);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Unable to find item");
        }
        return resp;
    }

    @RequestMapping(value = "/item-categories", method = RequestMethod.GET, produces = { "application/json" })
    public RestfulResponse getAllItemCategories(HttpServletRequest req) {
        RestfulResponse resp = new RestfulResponse();
        List<ItemCategory> itemCategories;
        try {
            itemCategories = itemService.getAllItemCategories();
            resp.setSuccess(true);
            resp.setData(itemCategories);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Unable to get item categories");
        }
        return resp;
    }

    @RequestMapping(value = "/sold-item", method = RequestMethod.POST, produces = { "application/json" })
    public RestfulResponse saveSoldItem(HttpServletRequest req, @RequestBody SoldItem soldItem) {
        RestfulResponse resp = new RestfulResponse();

        try {
            Integer soldItemId = itemService.saveSoldItem(soldItem);
            resp.setSuccess(true);
            resp.setData(soldItemId);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Sold Item saved");
        }
        return resp;
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = { "application/json" })
    public RestfulResponse saveArtisanItem(HttpServletRequest req, @RequestBody ArtisanItem artisanItem) {
        RestfulResponse resp = new RestfulResponse();

        try {
            ArtisanItem artisanItem1 = itemService.saveArtisanItem(artisanItem);
            resp.setSuccess(true);
            resp.setData(artisanItem1);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Artisan Item saved");
        }
        return resp;
    }


}
