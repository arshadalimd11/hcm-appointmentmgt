package com.dxc.appointment.util;

import com.dxc.appointment.dto.AppointmentDetails;
import com.dxc.appointment.dto.CreateAppointmentRequest;
import com.dxc.appointment.entities.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AppointmentUtil {

    @Autowired
    private DateUtil dateUtil;

    public Appointment toAppointment(CreateAppointmentRequest request){
        LocalDateTime dateTime= dateUtil.toDateTime(request.getDateTimeMillis());
        Appointment appointment = new Appointment();
        appointment.setUserId(request.getUserId());
        appointment.setTestId(request.getTestId());
        appointment.setDateTime(dateTime);
        appointment.setCenterId(request.getCenterId());
        appointment.setApproved(false);
        return appointment;
    }

    public List<AppointmentDetails>appointmentDetailsList(Collection<Appointment>appointments){
        List<AppointmentDetails>desired=new ArrayList<>();
        for (Appointment appointment:appointments){
            AppointmentDetails details=appointmentDetails(appointment);
            desired.add(details);
        }
        return desired;
    }

    public AppointmentDetails appointmentDetails(Appointment appointment){
        AppointmentDetails details=new AppointmentDetails();
        details.setAppointmentId(appointment.getAppointmentId());
        LocalDateTime dateTime=appointment.getDateTime();
        long millis=dateUtil.toMillis(dateTime);
        details.setDateTimeMillis(millis);
        details.setCenterId(appointment.getCenterId());
        details.setTestId(appointment.getTestId());
        details.setUserId(appointment.getUserId());
        details.setApproved(appointment.isApproved());
        return details;
    }

}
