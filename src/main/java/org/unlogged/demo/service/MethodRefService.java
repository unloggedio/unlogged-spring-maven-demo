package org.unlogged.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MethodRefService {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
}