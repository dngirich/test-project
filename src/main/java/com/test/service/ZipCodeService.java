package com.test.service;

import com.test.beans.AddressResponse;
import java.util.List;

public interface ZipCodeService {

    AddressResponse getByZipCode(Integer zipCode);

    List<AddressResponse> getAllAddresses();

}
