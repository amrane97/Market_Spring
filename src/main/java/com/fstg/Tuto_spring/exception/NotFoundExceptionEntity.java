package com.fstg.Tuto_spring.exception;

public class NotFoundExceptionEntity extends RuntimeException {

    public NotFoundExceptionEntity (){

    }

    public NotFoundExceptionEntity (String message){
        super(message);
    }
}

