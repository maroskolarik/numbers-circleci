package com.gfa.circleci.dtos;

public class ResponseDto {
    private final int result;

    public ResponseDto(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
