package com.test.controller;

import com.test.exception.ZipCodeNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.service.ZipCodeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.test.beans.AddressResponse;

@CrossOrigin
@RestController
@RequestMapping("/adress")
public class ZipCodeController {

    @Autowired
    private ZipCodeService zipCodeService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AddressResponse findByZipCode(@RequestParam(name = "zipcode") Integer zipcode) {
        if (zipcode != null) {
            return zipCodeService.getByZipCode(zipcode);
        } else {
            throw new ZipCodeNotFoundException("empty zipcode.");
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<AddressResponse> getAllAddresses() {
        return zipCodeService.getAllAddresses();
    }
}
