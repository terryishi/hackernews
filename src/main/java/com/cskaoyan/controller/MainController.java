package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/news")
    public String homePage (Model model){

       // model.addAttribute("11",11);
        return "home";
    }
}
