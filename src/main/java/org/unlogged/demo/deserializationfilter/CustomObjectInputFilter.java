package org.unlogged.demo.deserializationfilter;
import java.io.ObjectInputFilter;

public class CustomObjectInputFilter implements ObjectInputFilter {

    private static final String ALLOWED_PACKAGE = "org.unlogged.demo.models";

    @Override
    public ObjectInputFilter.Status checkInput(FilterInfo info) {
        Class<?> clazz = info.serialClass();
        if (clazz != null && clazz.getName().startsWith(ALLOWED_PACKAGE)) {
            return ObjectInputFilter.Status.ALLOWED;
        } else {
            return ObjectInputFilter.Status.REJECTED;
        }
    }
}
