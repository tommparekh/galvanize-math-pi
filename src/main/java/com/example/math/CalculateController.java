package com.example.math;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.math.service.MathService.getCalculateAnswer;

@RestController
@RequestMapping("/math")
public class CalculateController {

    @GetMapping("/calculate")
    public String calculate(@RequestParam(defaultValue = "add", required = false) String operation
            , @RequestParam int x, @RequestParam int y) {

        String response = getCalculateAnswer(operation, x, y);

        return response;
    }


}
