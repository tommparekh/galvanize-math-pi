package com.example.math;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/math"})
public class PiController {
    public PiController() {
    }

    @GetMapping({"/pi"})
    public String getPiValue() {
        return "3.141592653589793";
    }
}
