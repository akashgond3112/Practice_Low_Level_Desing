package com.book.my.show.exceptions;


public class ShowAlreadyExistsException extends Exception{
    public ShowAlreadyExistsException(Long id){
        super("Show with id: "+id+" already Exists.");
    }
}
