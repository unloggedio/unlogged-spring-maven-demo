package org.unlogged.demo.security.model;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "USER";
    }
}
