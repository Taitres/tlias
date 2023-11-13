package com.taitres.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @RequestMapping("/dept")
    public String getDept(){
        return "Dept";
    }
}
