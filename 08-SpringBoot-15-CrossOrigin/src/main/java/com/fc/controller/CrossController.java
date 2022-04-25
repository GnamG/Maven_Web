package com.fc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cross")
@CrossOrigin(originPatterns = "*",allowCredentials = "true",
            maxAge = 3600,methods = {
            RequestMethod.POST,
            RequestMethod.GET,
            RequestMethod.OPTIONS,
            RequestMethod.DELETE,
            RequestMethod.PUT
})
public class CrossController {
    @GetMapping("test")
    public String test(){
        return "苏州";
    }
}
