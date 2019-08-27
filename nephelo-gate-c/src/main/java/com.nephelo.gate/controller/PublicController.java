package com.nephelo.gate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @RequestMapping("/")
    public String login() {
        return "Nephelo Gate success";
    }
}
