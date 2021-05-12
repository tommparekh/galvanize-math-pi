package com.example.math;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.math.service.MathService.getSum;

@RestController
@RequestMapping("/math")
public class SumController {

    @PostMapping("/sum")
    public String sum(@RequestParam MultiValueMap<String, Object> queryString) {
        List<Object> valueList = queryString.get("n");
        String response = getSum(valueList);
        return response;
    }


}
