package com.test.dao;

import com.test.domain.AdressResponseEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeDao {

    void save(AdressResponseEntity adress);

    AdressResponseEntity getByZipCode(Integer zipCod);

    List<AdressResponseEntity> getAll();
}
