package com.test.service.impl;

import com.test.domain.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.test.repository.IndexRepository;
import com.test.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IndexRepository geocodRepository;

    @Override
    public Index find(String param) {

        String existingIndexParam = restTemplate.getForObject(
                "http://maps.googleapis.com/maps/api/geocode/json?address={index}&sensor=true", String.class, param);

        Index index = new Index();
        index.setDateTime(new Date());
        index.setSearchRequest(param);
        index.setSearchResult(existingIndexParam);
        geocodRepository.save(index);
        return index;

    }

}
