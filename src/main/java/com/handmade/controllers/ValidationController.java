package com.handmade.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handmade.model.RestfulResponse;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @RequestMapping(value = "/validate", method = RequestMethod.GET, produces = { "application/json" })
    public RestfulResponse validate(HttpServletRequest req) {
        RestfulResponse resp = new RestfulResponse();
        resp.setSuccess(true);
        return resp;
    }
}
