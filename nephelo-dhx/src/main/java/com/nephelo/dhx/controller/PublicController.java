package com.nephelo.dhx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nephelo on 2018-12-11.
 */
@RestController
public class PublicController {
    @GetMapping("publicUser")
    public String home() {
        return "nephelo dhx";
    }

    @RequestMapping(value = "info")
    public String info() {
        return "nephelo dhx";
    }

    @RequestMapping(value = "products")
    public String products() {
        return "nephelo dhx";
    }
}
