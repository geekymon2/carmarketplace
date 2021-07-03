package com.geekymon2.carmarketplace.carlistingservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @GetMapping("/list")
    public List<String> getList() {
        return Arrays.asList("A list of items","test");
    }

}
