package com.test.service.impl;

import com.test.beans.AdressResponse;
import com.test.exception.AdressNotFoundException;
import com.test.beans.GoogleGeoCodeResponse;
import com.test.dao.ZipCodeDao;
import com.test.domain.AdressResponseEntity;
import com.test.mapper.AdressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.test.service.ZipCodeService;
import java.util.List;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZipCodeDao zipCodeDao;
    @Autowired
    private AdressMapper adressMapper;

    @Override
    public AdressResponse find(Integer zipcode) {
        List<AdressResponse> existingAdress = adressMapper.from(zipCodeDao
                .getByZipCode(zipcode));
        if (!existingAdress.isEmpty()) {
            return existingAdress.get(0);
        } else {
            GoogleGeoCodeResponse result = restTemplate.getForObject(
            "http://maps.googleapis.com/maps/api/geocode/json?address={zipcode}&sensor=true",
            GoogleGeoCodeResponse.class, zipcode);
            String status = result.getStatus();

            if (!status.equalsIgnoreCase("ZERO_RESULTS")) {
                AdressResponseEntity adress = new AdressResponseEntity();
                adress.setDateTime(new Date());
                adress.setZipCode(zipcode);
                adress.setFormattedAddress(result.getResults().get(0)
                        .getFormatted_address());
                adress.setLatitude(Double.parseDouble(result.getResults().get(0)
                        .getGeometry().getLocation().getLat()));
                adress.setLongitude(Double.parseDouble(result.getResults().get(0)
                        .getGeometry().getLocation().getLng()));

                zipCodeDao.save(adress);
                return adressMapper.from(adress);
            } else {
                throw new AdressNotFoundException("Non-existent or invalid zipcode");
            }
        }
    }

    @Override
    public List<AdressResponse> getALL() {
        return adressMapper.from(zipCodeDao.getAll());
    }
}
