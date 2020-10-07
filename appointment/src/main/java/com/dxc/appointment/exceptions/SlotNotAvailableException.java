package com.dxc.appointment.exceptions;

public class SlotNotAvailableException extends RuntimeException{

    public SlotNotAvailableException(String msg){
        super(msg);
    }
}
