package com.dxc.appointment.dao;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.appointment.entities.*;

public interface IAppointmentDao extends JpaRepository<Appointment, Integer> {

	List<Appointment> findByCenterId(String centerId);

	Appointment findAppointmentByTestId(Integer testId);
}
