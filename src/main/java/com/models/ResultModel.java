package com.models;

public class ResultModel {
    private final boolean success;
    private  final String message;
    public ResultModel(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}
