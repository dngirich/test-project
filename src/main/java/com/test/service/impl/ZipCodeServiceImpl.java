package com.test.service.impl;

import com.test.beans.AddressResponse;
import com.test.exception.AdressNotFoundException;
import com.test.beans.GoogleGeoCodeResponse;
import com.test.domain.AddressResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.test.service.ZipCodeService;
import java.util.List;
import com.test.dao.ZipCodeDao;
import com.test.mapper.AddressMapper;

@Service
@Transactional
public class ZipCodeServiceImpl implements ZipCodeService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZipCodeDao zipCodeDao;
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public AddressResponse getByZipCode(Integer zipCode) {
        AddressResponseEntity existingAddress = zipCodeDao.getByZipCode(zipCode);
        if (existingAddress != null) {
            return addressMapper.from(existingAddress);
        } else {
            GoogleGeoCodeResponse result = restTemplate.getForObject(
            "http://maps.googleapis.com/maps/api/geocode/json?address={zipcode}&sensor=true",
            GoogleGeoCodeResponse.class, zipCode);
            String status = result.getStatus();

            if (!status.equalsIgnoreCase("ZERO_RESULTS")) {
                AddressResponseEntity address = new AddressResponseEntity();
                address.setDateTime(new Date());
                address.setZipCode(zipCode);
                address.setFormattedAddress(result.getResults().get(0)
                        .getFormatted_address());
                address.setLatitude(Double.parseDouble(result.getResults().get(0)
                        .getGeometry().getLocation().getLat()));
                address.setLongitude(Double.parseDouble(result.getResults().get(0)
                        .getGeometry().getLocation().getLng()));

                zipCodeDao.save(address);
                return addressMapper.from(address);
            } else {
                throw new AdressNotFoundException("Non-existent or invalid zipcode");
            }
        }
    }

    @Override
    public List<AddressResponse> getAllAddresses() {
        return addressMapper.from(zipCodeDao.getAllAddresses());
    }
}
