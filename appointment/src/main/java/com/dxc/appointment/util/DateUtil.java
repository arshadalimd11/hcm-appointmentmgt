package com.dxc.appointment.util;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

@Component
public class DateUtil {

   public long toMillis(LocalDateTime dateTime){
        ZonedDateTime zonedDateTime=ZonedDateTime.of(dateTime, ZoneId.systemDefault());
        long millis= zonedDateTime.toInstant().toEpochMilli();
        return millis;
    }

    public LocalDateTime toDateTime(long millis){
        System.out.println("inside todatetime="+millis);
        LocalDateTime datetime =LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), TimeZone.getDefault().toZoneId());
        return datetime;
    }

}
