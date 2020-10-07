package com.dxc.appointment.controllers;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dxc.appointment.exceptions.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {AppointmentAlreadyApprovedException.class})
    public String  handleAppointmentAlreadyApproved(AppointmentAlreadyApprovedException e) {
        String msg=e.getMessage();
        return msg;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {AppointmentNotFoundException.class})
    public String handleAppointmentNotFound(AppointmentNotFoundException e) {
        String msg=e.getMessage();
        return msg;
    }
    

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {SlotNotAvailableException.class})
    public String handleSlotNotAvailable(SlotNotAvailableException e) {
        String msg=e.getMessage();
        return msg;
    }
}
	

