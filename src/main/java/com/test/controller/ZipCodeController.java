package com.test.controller;

import com.test.ZipCodeNotFoundException;
import com.test.domain.ZipCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.service.ZipCodeService;

@CrossOrigin
@RestController
@RequestMapping("/location")

public class ZipCodeController {

    @Autowired
    private ZipCodeService zipCodeService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ZipCode find(@RequestParam(name = "zipcode") Integer zipcode) {
        if (zipcode != null) {
            return zipCodeService.find(zipcode);
        } else {
            throw new ZipCodeNotFoundException("Can't find non-existent zipcode.");
        }

    }
}
