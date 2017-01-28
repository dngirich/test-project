package com.test.service;

import com.test.domain.Location;

public interface ZipCodeService {

    Location find(Integer zipCode);
}
