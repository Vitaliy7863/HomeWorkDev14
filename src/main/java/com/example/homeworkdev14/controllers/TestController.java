package com.example.homeworkdev14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping
    public ModelAndView test(){
        ModelAndView res = new ModelAndView();
        res.addObject("test", "Hello World");
        return res;
    }
}
