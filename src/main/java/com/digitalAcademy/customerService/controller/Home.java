package com.digitalAcademy.customerService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class Home {

    @GetMapping(path = "/hello")
    public String hello(){
        return "sawad dee ja";
    }

}
