package com.test.service;

import com.test.bean.AddressResponse;
import java.util.List;

public interface ZipCodeService {

    AddressResponse getByZipCode(Integer zipCode);

    List<AddressResponse> getAllAddresses();

}
