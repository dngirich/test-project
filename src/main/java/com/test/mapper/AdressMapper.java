package com.test.mapper;

import com.test.beans.AdressResponse;
import com.test.domain.AdressResponseEntity;
import java.util.List;

public interface AdressMapper {

    AdressResponse from(AdressResponseEntity entity);

    List<AdressResponse> from(List<AdressResponseEntity> entities);
}
