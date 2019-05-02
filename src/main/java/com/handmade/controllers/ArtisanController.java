package com.handmade.controllers;

import com.handmade.model.Artisan;
import com.handmade.model.RestfulResponse;
import com.handmade.model.User;
import com.handmade.services.ArtisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Matt on 12/4/18.
 */
@RestController
@RequestMapping("/api/artisan")
public class ArtisanController {

    @Autowired
    ArtisanService artisanService;

    @RequestMapping(value = "/{artisanId}", method = RequestMethod.GET, produces = { "application/json" })
    public RestfulResponse addNewUser(HttpServletRequest req, @PathVariable Integer artisanId) {
        RestfulResponse<Artisan> resp = new RestfulResponse();
        Artisan artisan;
        try {
            artisan = artisanService.getArtisanById(artisanId);
            resp.setSuccess(true);
            resp.setData(artisan);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Unable to find artisan");
        }
        return resp;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
    public RestfulResponse getAllArtisans(HttpServletRequest req) {
        Logger log = Logger.getAnonymousLogger();
        for (Enumeration<String> e = req.getHeaderNames(); e.hasMoreElements();) {
            String header = e.nextElement();
            log.info(header);
            log.info(req.getHeader(header));
        }
        log.info("1 " + req.getMethod());
        log.info(req.getRemoteUser());
        log.info("2 " + req.getRequestedSessionId());
        log.info(req.getQueryString());
        log.info("3 " + req.getAuthType());
        log.info("4 " + req.getContextPath());
        log.info("5 " + req.getRequestURL());
        log.info("6 " + req.getServletPath());

        RestfulResponse resp = new RestfulResponse();
        List<Artisan> artisans;
        try {
            artisans = artisanService.getAllArtisans();
            resp.setSuccess(true);
            resp.setData(artisans);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Unable to find artisan");
        }
        return resp;
    }

    @RequestMapping(value = "/{arisanId}/{productId}", method = RequestMethod.POST, produces = { "application/json" })
    public RestfulResponse saveArtisan(HttpServletRequest req, @RequestBody Artisan artisan, @PathVariable("artisanId") Integer artisanId) {
        RestfulResponse resp = new RestfulResponse();
        try {
            artisan = artisanService.saveArtisan(artisan);
            resp.setSuccess(true);
            resp.setMessage("Artisan successfully saved");
            resp.setData(artisan);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setSuccess(false);
            resp.setMessage("Unable to save artisan");
        }
        return resp;
    }


}
