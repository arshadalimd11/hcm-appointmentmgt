package com.dxc.appointment.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;


import javax.persistence.*;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue
    private Integer appointmentId;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private Integer testId;
    private LocalDateTime dateTime;
    private boolean approved;
    @Column(nullable = false)
    private String centerId;

    public Appointment() {

    }

    public Appointment( String userId,Integer testId, LocalDateTime dateTime, boolean approved) {
        this.userId = userId;
        this.testId = testId;
        this.dateTime = dateTime;
        this.approved = approved;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getCenterId(){
        return centerId;
    }

    public void setCenterId(String centerId){
        this.centerId=centerId;
    }


    @Override
    public boolean equals(Object arg) {
        if (this == arg) {
            return true;
        }

        if (arg == null || !(arg instanceof Appointment)) {
            return false;
        }

        Appointment that = (Appointment) arg;
        boolean isequal = this.appointmentId.equals(that.appointmentId);
        return isequal;
    }

    @Override
    public int hashCode() {
        return appointmentId.hashCode();
    }


}
