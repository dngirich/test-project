package com.test.mapper;

import com.test.beans.AddressResponse;
import com.test.domain.AddressResponseEntity;
import java.util.List;

public interface AddressMapper {

    AddressResponse from(AddressResponseEntity entity);

    List<AddressResponse> from(List<AddressResponseEntity> entities);
}
