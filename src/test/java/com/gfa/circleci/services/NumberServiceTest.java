package com.gfa.circleci.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {
    private static NumberService numberService;

    @BeforeAll
    public static void init() {
        numberService = new NumberServiceImpl();
    }

    @Test
    void add() {
        int num1 = 2;
        int num2 = 1;
        assertEquals(3, numberService.add(num1, num2));
    }

    @Test
    void sub() {
        int num1 = 2;
        int num2 = 1;
        assertEquals(1, numberService.sub(num1, num2));
    }
}
//