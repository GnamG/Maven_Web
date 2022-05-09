package com.fc.controller;

import com.fc.entity.Car;
import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("variable")
public class StandardVariableExpressionController {
    @RequestMapping("test")
    public String test(Model model) {
        model.addAttribute("name","易烊千玺");
        model.addAttribute("age",22);
        model.addAttribute("married", false);

        User user = new User(1, "易烊千玺", 22, "男", "四个字", new Car("五菱Mini", "lv色"));
        model.addAttribute("user",user);
        return "variable";
    }

    @RequestMapping("test1")
    public String test1(Model model) {
        model.addAttribute("name","唔西迪西");
        model.addAttribute("age",32);
        model.addAttribute("married", false);

        User user = new User(2, "唔西迪西", 32, "女", "四个字", new Car("五菱SUV", "粉色"));
        model.addAttribute("user",user);
        return "variable";
    }
}
