package com.test.mapper;

import com.test.beans.AddressResponse;
import com.test.domain.AddressResponseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressResponse from(AddressResponseEntity entity) {

        AddressResponse adress = new AddressResponse();
        adress.setId(entity.getId());
        adress.setDateTime(entity.getDateTime());
        adress.setZipCode(entity.getZipCode());
        adress.setFormattedAddress(entity.getFormattedAddress());
        adress.setLatitude(entity.getLatitude());
        adress.setLongitude(entity.getLongitude());
        return adress;
    }

    @Override
    public List<AddressResponse> from(List<AddressResponseEntity> entities) {

        List<AddressResponse> result = new ArrayList<>();
        entities.stream().map((entity) -> transformToAdressResponse(entity))
                .forEach((bean) -> {
                    result.add(bean);
                });
        return result;

    }

    private AddressResponse transformToAdressResponse(AddressResponseEntity entity) {
        AddressResponse adress = new AddressResponse();
        adress.setId(entity.getId());
        adress.setDateTime(entity.getDateTime());
        adress.setZipCode(entity.getZipCode());
        adress.setFormattedAddress(entity.getFormattedAddress());
        adress.setLatitude(entity.getLatitude());
        adress.setLongitude(entity.getLongitude());
        return adress;
    }

}
