package com.gfa.circleci.services;

import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService {
    @Override
    public int add(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int sub(int num1, int num2) {
        return num1 - num2;
    }
}
