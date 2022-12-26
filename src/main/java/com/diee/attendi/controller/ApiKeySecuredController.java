package com.diee.attendi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured-resource")
public class ApiKeySecuredController {

    @GetMapping()
    public String getSecuredInfo() {
        return "This is a secured information which can only be accessed by using a valid api-key";
    }
}
