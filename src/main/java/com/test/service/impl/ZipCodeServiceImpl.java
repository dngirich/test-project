package com.test.service.impl;

import com.test.domain.ZipCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.test.repository.ZipCodeRepository;
import com.test.service.ZipCodeService;
import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.*;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZipCodeRepository zipCodeRepository;

    @Override
    public ZipCode find(Integer zipcode) {

        String existingIndexParam = restTemplate.getForObject("http://maps.googleapis.com/maps/api/geocode/json?address={zipcode}&sensor=true", String.class, zipcode);

        ZipCode index = new ZipCode();
        index.setDateTime(new Date());
        index.setSearchRequest(zipcode);
        index.setSearchResult(existingIndexParam);
        zipCodeRepository.save(index);
        return index;

    }

}
