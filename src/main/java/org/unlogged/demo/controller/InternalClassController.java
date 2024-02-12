package org.unlogged.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jna.platform.win32.Sspi;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.joda.time.Instant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InternalClassController {

    class Xe {
        @Getter
        private int y = 4;
        private Xe subInstance = new Xe();

        public int methodE() {
            return subInstance.y;
        }

        public int methodE2() {
            return subInstance.getY();
        }
    }

    private List<String> getTimeObjects() {
        List<String> timestamps = new ArrayList<>();
        DateTime jodaDateTime = new DateTime();
        timestamps.add(jodaDateTime.toString());
        Sspi.TimeStamp sspiTimeStamp = new Sspi.TimeStamp();
        timestamps.add(sspiTimeStamp.toString());
        Instant instant = new Instant();
        timestamps.add(instant.toString());
        java.time.Instant timeInstant = java.time.Instant.now();
        timestamps.add(timeInstant.toString());
        return timestamps;
    }

    private final Map<String, String> map1 = new HashMap<>() {
        {
            put("Val1", "key1");
            put("Val2", "key2");
            put("Val3", "key3");
            put("Val4", "key4");
        }
    };

    private String getMapValue() {
        return map1.get("Val4");
    }

    private List<String> filterList(List<String> inputList) {
        return inputList.stream().filter(e -> e.length() >= 5).collect(Collectors.toList());
    }

    public ObjectMapper configureMapper(ObjectMapper objectMapper) {
        objectMapper.setDefaultMergeable(true);
        return objectMapper;
    }

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}