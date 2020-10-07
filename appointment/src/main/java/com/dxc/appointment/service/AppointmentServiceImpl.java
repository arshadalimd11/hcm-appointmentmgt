package com.dxc.appointment.service;

import com.dxc.appointment.dao.IAppointmentDao;
import com.dxc.appointment.entities.*;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dxc.appointment.exceptions.*;


@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    private IAppointmentDao dao;

    @Override
    public Appointment makeAppointment(Appointment appointment) {
        validateAppointment(appointment);
        Appointment app = dao.save(appointment);
        return app;
    }

    @Override
    public Appointment findAppointmentById(Integer appointmentId) {
        Optional<Appointment> optional = dao.findById(appointmentId);
        if (!optional.isPresent()) {
            throw new AppointmentNotFoundException("Appointment with id " + appointmentId + " not found");
        }
        Appointment app = optional.get();
        return app;
    }

    @Override
    public List<Appointment> allAppointments() {
        List<Appointment> allAppointments = dao.findAll();
        return allAppointments;
    }

    @Override
    public Appointment approveAppointment(Appointment appointment) {
        if (appointment.isApproved()) {
            throw new AppointmentAlreadyApprovedException(
                    "Appointment with Id :" + appointment.getAppointmentId() + " is Already Approved");
        }

        appointment.setApproved(true);
        return dao.save(appointment);
    }

    @Override
    public void removeAppointmentById(Integer appointmentId) {
        Appointment appointment = findAppointmentById(appointmentId);
        dao.delete(appointment);
    }

    @Override
    public List<Appointment> findAppointmentsByCenterId(String centerId) {
        List<Appointment> appointments = dao.findByCenterId(centerId);
        return appointments;
    }

    @Override
    public Appointment findAppointmentByTestId(Integer testId) {
        Appointment appointment=dao.findAppointmentByTestId(testId);
        return appointment;
    }

    public void validateAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new InvalidArgumentException("appointment is null");
        }
    }


}

	
	
	
	
	
	

