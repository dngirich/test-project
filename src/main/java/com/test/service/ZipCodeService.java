package com.test.service;

import com.test.beans.AdressResponse;
import java.util.List;

public interface ZipCodeService {

    AdressResponse find(Integer zipCode);

    List<AdressResponse> getAll();

}
