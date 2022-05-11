package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NullController {
    @RequestMapping("null")
    public String test(Model model) {
        model.addAttribute("value",null);
        model.addAttribute("string","");

        return "null";
    }
}
