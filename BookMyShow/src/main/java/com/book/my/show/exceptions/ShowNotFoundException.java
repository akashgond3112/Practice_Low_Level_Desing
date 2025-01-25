package com.book.my.show.exceptions;

public class ShowNotFoundException extends Exception{
    public ShowNotFoundException(Long id){
        super("ShowId: "+id+" Not found");
    }
}
