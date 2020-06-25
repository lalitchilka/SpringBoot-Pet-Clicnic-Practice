package com.myapp.springbootpetclinicpractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetIndexController {

    @RequestMapping({"/vets", "vets/index", "vets/index.html"})
    public String index(){
        return "vets/index";
    }
}
