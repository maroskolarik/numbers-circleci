package com.gfa.circleci.controllers;

import com.gfa.circleci.dtos.RequestDto;
import com.gfa.circleci.dtos.ResponseDto;
import com.gfa.circleci.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {
    private NumberService numberService;

    @Autowired
    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/")
    public ResponseEntity index() {
        return ResponseEntity.status(200).body("CALCULATOR SERVICE 2000 - 1526");
    }

    @PostMapping("/")
    public ResponseEntity calculate(@RequestBody RequestDto requestDto) {
        int result = 0;
        String action = requestDto.getAction();
        int num1 = requestDto.getNum1();
        int num2 = requestDto.getNum2();
        if (action.equals("+")) {
            result = numberService.add(num1, num2);
        }
        if (action.equals("-")) {
            result = numberService.sub(num1, num2);
        }
        return ResponseEntity.status(200).body(new ResponseDto(result));
    }
}
//
