package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.models.Vehicle;

@RestController
@RequestMapping(value = "/rest")
public class Controller {

    Vehicle v = new Vehicle(23,"E","e","E");
    @RequestMapping(value = "/test")
    public String test() {
        Integer x = 99;
        Vehicle.getE();
        v.getMake();
        return "Testing134567";
    }

    @RequestMapping(value = "/eee")
    public String testr() {
        String a = "a".split(" ")[10];
        int x = 5;
        String d = "eee" +
                "bbb";
        return "Object_" +
                "ggg";
    }

    public Vehicle fetchVehicle() {
        Vehicle v = new Vehicle(1, "ASDA2743280", "Honda-", "Civic");
        parseVehicle(v, v.getVehicleId(), v.getVIN(), v.getMake(), v.getModel());
        v.setVehicleId(14);
        return v;
    }

    private void parseVehicle(Vehicle v, long vehicleId, String vin, String make, String model) {
        String a = "a".split(" ")[10];
    }

    private String formString(int a) {
        if (a > 5) {
            String s = "sss";
            return s;
        } else {
            if (a == 3) {
                return "LT5-3";
            } else {
                return "LT5u";
            }
        }
    }

}