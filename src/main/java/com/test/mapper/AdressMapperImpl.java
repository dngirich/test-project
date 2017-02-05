package com.test.mapper;

import com.test.beans.AdressResponse;
import com.test.domain.AdressResponseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AdressMapperImpl implements AdressMapper {

    @Override
    public AdressResponse from(AdressResponseEntity entity) {

        AdressResponse adress = new AdressResponse();
        adress.setId(entity.getId());
        adress.setDateTime(entity.getDateTime());
        adress.setZipCode(entity.getZipCode());
        adress.setFormattedAddress(entity.getFormattedAddress());
        adress.setLatitude(entity.getLatitude());
        adress.setLongitude(entity.getLongitude());
        return adress;
    }

    @Override
    public List<AdressResponse> from(List<AdressResponseEntity> entities) {

        List<AdressResponse> result = new ArrayList<>();
        entities.stream().map((entity) -> transformToAdressResponse(entity))
                .forEach((bean) -> {
                    result.add(bean);
                });
        return result;

    }

    private AdressResponse transformToAdressResponse(AdressResponseEntity entity) {
        AdressResponse adress = new AdressResponse();
        adress.setId(entity.getId());
        adress.setDateTime(entity.getDateTime());
        adress.setZipCode(entity.getZipCode());
        adress.setFormattedAddress(entity.getFormattedAddress());
        adress.setLatitude(entity.getLatitude());
        adress.setLongitude(entity.getLongitude());
        return adress;
    }

}
