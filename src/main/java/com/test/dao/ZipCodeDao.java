package com.test.dao;

import com.test.domain.AddressResponseEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeDao {

    void save(AddressResponseEntity adress);

    AddressResponseEntity getByZipCode(Integer zipCod);

    List<AddressResponseEntity> getAllAddresses();
}
