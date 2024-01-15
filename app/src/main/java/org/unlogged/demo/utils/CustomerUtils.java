package org.unlogged.demo.utils;

public class CustomerUtils {

    public static String getLocationFromAddress(String address) {
        String[] parts = address.split(" ");
        if (parts.length >= 1) {
            return parts[parts.length - 1];
        }
        return address;
    }
}
