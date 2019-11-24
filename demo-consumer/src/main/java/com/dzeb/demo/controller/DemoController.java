package com.dzeb.demo.controller;

import com.dzeb.demo.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController {

    @Reference(version = "1.0.0")
    private DemoService demoService;

    @RequestMapping("sayHello/{name}")
    public ResponseEntity<String> sayHello(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(demoService.sayHello(name));
    }
}
