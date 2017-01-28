package com.test.service.impl;

import com.test.LocationNotFoundException;
import com.test.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.test.repository.ZipCodeRepository;
import com.test.service.ZipCodeService;
import org.json.JSONObject;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZipCodeRepository zipCodeRepository;

    @Override
    public Location find(Integer zipcode) {

        String existingResult = restTemplate.getForObject(
        "http://maps.googleapis.com/maps/api/geocode/json?address={zipcode}&sensor=true",
        String.class, zipcode);

        JSONObject jsonObj = new JSONObject(existingResult);
        String status = jsonObj.getString("status");

        if (!status.equals("ZERO_RESULTS")) {
            Location location = new Location();
            location.setDateTime(new Date());
            location.setSearchRequest(zipcode);
            location.setSearchResult(existingResult);
            zipCodeRepository.save(location);
            return location;
        } else {
            throw new LocationNotFoundException("Non-existent or invalid zipcode");
        }

    }

}
