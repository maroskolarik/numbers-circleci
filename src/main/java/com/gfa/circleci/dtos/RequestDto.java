package com.gfa.circleci.dtos;

public class RequestDto {
    private final int num1;
    private final int num2;
    private final String action;

    public RequestDto(int num1, int num2, String action) {
        this.num1 = num1;
        this.num2 = num2;
        this.action = action;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getAction() {
        return action;
    }
}
