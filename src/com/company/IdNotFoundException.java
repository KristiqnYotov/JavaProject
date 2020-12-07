package com.company;

public class IdNotFoundException extends Exception{
    public String message;

    public IdNotFoundException(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
