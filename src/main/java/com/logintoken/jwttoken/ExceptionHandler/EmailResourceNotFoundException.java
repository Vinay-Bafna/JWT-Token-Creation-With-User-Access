package com.logintoken.jwttoken.ExceptionHandler;


public class EmailResourceNotFoundException extends RuntimeException {
    public String Email;
    public EmailResourceNotFoundException(String Email){
        super(String.format("Email Not Found With : %s",Email));
        this.Email=Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
