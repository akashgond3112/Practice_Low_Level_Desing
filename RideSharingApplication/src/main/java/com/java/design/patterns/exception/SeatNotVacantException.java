package com.java.design.patterns.exception;

public class SeatNotVacantException extends Exception{
    public SeatNotVacantException(String str){
        super(str);
    }
}
