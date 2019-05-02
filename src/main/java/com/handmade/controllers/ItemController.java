package com.handmade.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.handmade.model.Artisan;
import com.handmade.model.ArtisanItem;
import com.handmade.model.RestfulResponse;
import com.handmade.model.SoldItem;
import com.handmade.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
            for (SoldItem si : soldItems) {
                System.out.println(si.getDateSold().toString());
            }
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

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = { "application/json" })
    public RestfulResponse saveArtisanItem(HttpServletRequest req, @RequestBody ArtisanItem artisanItem) {
        RestfulResponse resp = new RestfulResponse();

        try {
            Integer artisanItemId = itemService.saveArtisanItem(artisanItem);
            resp.setSuccess(true);
            resp.setData(artisanItemId);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Artisan Item saved");
        }
        return resp;
    }


}
