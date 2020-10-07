package com.dxc.appointment.exceptions;


public class AppointmentAlreadyApprovedException extends RuntimeException{
	
	public AppointmentAlreadyApprovedException (String msg) {
		super(msg);
		
	}
}
