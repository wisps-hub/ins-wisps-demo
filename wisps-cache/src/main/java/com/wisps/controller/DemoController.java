package com.wisps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class DemoController {

    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }

}
