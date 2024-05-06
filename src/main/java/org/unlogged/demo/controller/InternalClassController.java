package org.unlogged.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.unlogged.demo.models.ItemData;
import org.unlogged.demo.models.ItemInfo;
import org.unlogged.demo.models.L1Object;
import org.unlogged.demo.service.DeepService;

import java.util.*;
import java.util.stream.Collectors;

public class InternalClassController {

    @Autowired
    private DeepService deepService;

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

        private int getY() {
            return this.y;
        }
    }

    private List<String> getTimeObjects() {
        List<String> timestamps = new ArrayList<>();
        DateTime jodaDateTime = new DateTime();
        timestamps.add(jodaDateTime.toString());
        Instant instant = new Instant();
        timestamps.add(instant.toString());
        java.time.Instant timeInstant = java.time.Instant.now();
        timestamps.add(timeInstant.toString());
        return timestamps;
    }

    private final Map<String, String> map1 = new HashMap<String, String>() {
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

    public char returnChar(char c) {
        return c;
    }

    Converter<ItemData, ItemInfo> myConverter = new Converter<ItemData, ItemInfo>() {
        public ItemInfo convert(MappingContext<ItemData, ItemInfo> context) {
            ItemData s = context.getSource();
            ItemInfo d = context.getDestination();
            d.setName(s.getName());
            d.setLarge(s.getMass() > 25);
            return d;
        }
    };

    public ItemInfo cmm() {
        ModelMapper mm = new ModelMapper();
        mm.addConverter(myConverter);
        ItemData dd = new ItemData();
        dd.setName("dodo");
        dd.setMass(64);
        ItemInfo di = mm.map(dd, ItemInfo.class);
        return di;
    }

    public <T> List<T> getListFromArray(T[] ips) {
        return Arrays.asList(ips);
    }

    public L1Object getL1Object() {
        return deepService.getDeepReference();
    }
}