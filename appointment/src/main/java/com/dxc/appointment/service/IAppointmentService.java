package com.dxc.appointment.service;

import java.math.BigInteger;
import java.util.List;

import com.dxc.appointment.entities.*;

public interface IAppointmentService {

    Appointment makeAppointment(Appointment appointment);

    Appointment findAppointmentById(Integer appointmentId);

    List<Appointment> allAppointments();

    Appointment approveAppointment(Appointment appointment);

    void removeAppointmentById(Integer appointmentId);

    List<Appointment>findAppointmentsByCenterId(String centerId);

    Appointment findAppointmentByTestId(Integer testId);
}
