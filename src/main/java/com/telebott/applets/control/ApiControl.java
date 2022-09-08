package com.telebott.applets.control;

import com.telebott.applets.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiControl {
    @Autowired
    private ApiService service;
}
