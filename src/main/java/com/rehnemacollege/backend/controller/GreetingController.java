package com.rehnemacollege.backend.controller;

import com.rehnemacollege.backend.model.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/hello")
    public String helloWorld(@RequestParam Map<String, String> map) {
        return "Hello " + map.get("name");
    }

    @PostMapping("/bye")
    public String byeWorld(@RequestBody Model model) {
        if (model.getName() != null) {

        }
        return "Bye " + model.getName() + " from " + model.getAddress();
    }

    @GetMapping("/model")
    public Model getModel() {
        return new Model("John", "Tehran");
    }

}
