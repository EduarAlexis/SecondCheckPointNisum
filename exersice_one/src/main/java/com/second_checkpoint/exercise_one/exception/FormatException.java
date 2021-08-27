package com.second_checkpoint.exercise_one.exception;

public class FormatException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String msg;

    public FormatException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
