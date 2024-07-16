package org.unlogged.demo.service;

import lombok.Getter;

public class val {

    public static final String external = "external";

    public static class nestedClass {
        public static final String internal = "internal";

        public String getInternal() {
            return internal;
        }
    }

    @Getter
    public static enum NestedEnum {
        INTERNAL_ENUM_1("internal_enum_1_str"),
        INTERNAL_ENUM_2("internal_enum_2_str");

        private String pos;
        NestedEnum(String internalEnum1Str) {
            this.pos = internalEnum1Str;
        }
    }
}
