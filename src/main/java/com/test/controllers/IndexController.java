package com.test.controllers;

import com.test.domain.Index;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.service.IndexService;

@CrossOrigin
@RestController
@RequestMapping("/indexx")
@Log
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Index find(@RequestParam(name = "param") String param) {

        log.info("param=" + param);

        return indexService.find(param);
    }
}
