package com.nephelo.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nephelo on 2018-12-11.
 */
@RestController
public class PublicController {
    @GetMapping("publicUser")
    public String home() {
        return "nephelo User";
    }
}
