package com.fstg.Tuto_spring.exception;

public class AlreadyExistExceptionEntity extends RuntimeException{
    public AlreadyExistExceptionEntity () {

    }

    public AlreadyExistExceptionEntity(String message){
        super(message);
    }
}
