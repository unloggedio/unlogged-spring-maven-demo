package org.unlogged.demo.jspdemo.wfm.Services;

import org.springframework.stereotype.Component;

@Component
public class CustomServiceImpl implements CustomService{
    @Override
    public String getValue() {
        return "Some Value1";
    }
}
