package com.dxc.appointment.controllers;

import com.dxc.appointment.dto.AppointmentDetails;
import com.dxc.appointment.entities.*;
import com.dxc.appointment.dto.CreateAppointmentRequest;
import com.dxc.appointment.service.*;


import com.dxc.appointment.util.AppointmentUtil;
import com.dxc.appointment.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private IAppointmentService service;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private AppointmentUtil appointmentUtil;

    @PostMapping("/add")
    public AppointmentDetails makeAppointment(@RequestBody CreateAppointmentRequest request) {
        Appointment appointment=appointmentUtil.toAppointment(request);
        appointment = service.makeAppointment(appointment);
        AppointmentDetails details=appointmentUtil.appointmentDetails(appointment);
        return details;
    }


    @GetMapping("/byid/{appointmentId}")
    public AppointmentDetails getAppointment(@PathVariable("appointmentId") Integer appointmentId) {
        Appointment appointment=service.findAppointmentById(appointmentId);
        AppointmentDetails details=appointmentUtil.appointmentDetails(appointment);
        return details;
    }

    @GetMapping("/bycenterid/{centerId}")
    public List<AppointmentDetails>getAppointmentsByCenterId(@PathVariable("centerId") String centerId){
       List<Appointment>appointments= service.findAppointmentsByCenterId(centerId);
       List<AppointmentDetails>details=appointmentUtil.appointmentDetailsList(appointments);
       return details;
    }

    @GetMapping("/bytestid/{testId}")
    public AppointmentDetails getByAppointmentId(@PathVariable("testId") Integer testId){
       Appointment appointment= service.findAppointmentByTestId(testId);
       AppointmentDetails details=appointmentUtil.appointmentDetails(appointment);
       return details;
    }


    @DeleteMapping("/remove/{appointmentId}")
    public void removeAppointment(@PathVariable("appointmentId") Integer appointmentId) {
        service.removeAppointmentById(appointmentId);
    }


}
