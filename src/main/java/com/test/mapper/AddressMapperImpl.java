package com.test.mapper;

import com.test.bean.AddressResponse;
import com.test.domain.AddressResponseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressResponse from(AddressResponseEntity entity) {

        AddressResponse address = new AddressResponse();
        address.setId(entity.getId());
        address.setDateTime(entity.getDateTime());
        address.setZipCode(entity.getZipCode());
        address.setFormattedAddress(entity.getFormattedAddress());
        address.setLatitude(entity.getLatitude());
        address.setLongitude(entity.getLongitude());
        return address;
    }

    @Override
    public List<AddressResponse> from(List<AddressResponseEntity> entities) {

        List<AddressResponse> result = new ArrayList<>();
        entities.stream().map((entity) -> transformToAddressResponse(entity))
                .forEach((bean) -> {
                    result.add(bean);
                });
        return result;

    }

    private AddressResponse transformToAddressResponse(AddressResponseEntity entity) {
        AddressResponse address = new AddressResponse();
        address.setId(entity.getId());
        address.setDateTime(entity.getDateTime());
        address.setZipCode(entity.getZipCode());
        address.setFormattedAddress(entity.getFormattedAddress());
        address.setLatitude(entity.getLatitude());
        address.setLongitude(entity.getLongitude());
        return address;
    }

}
