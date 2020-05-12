package com.whw.controller;

import com.whw.service.dataServcie.BaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private BaseDataService service;
    @GetMapping
    public String getData(Model model){
        model.addAttribute("list",service.findAll());
        return "index";
    }
}
