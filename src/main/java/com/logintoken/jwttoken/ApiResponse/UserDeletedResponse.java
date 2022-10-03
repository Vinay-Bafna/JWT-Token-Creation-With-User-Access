package com.logintoken.jwttoken.ApiResponse;

public class UserDeletedResponse {
    private String message;
    public UserDeletedResponse(String message){
        super();
        this.message=message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
