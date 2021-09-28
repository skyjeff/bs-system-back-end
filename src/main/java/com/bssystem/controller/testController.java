package com.bssystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class testController {
    @GetMapping("/t1")
    public void t1(){

        System.out.println(11);
    }
}
