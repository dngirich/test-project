package com.test.dao;

import com.test.domain.AddressResponseEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeDao {

    void saveAddress(AddressResponseEntity adress);

    AddressResponseEntity getByZipCode(Integer zipCode);

    List<AddressResponseEntity> getAllAddresses();
}
