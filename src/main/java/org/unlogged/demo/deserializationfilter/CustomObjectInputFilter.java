package org.unlogged.demo.deserializationfilter;
import java.io.ObjectInputFilter;

public class CustomObjectInputFilter implements ObjectInputFilter {

    private static final String ALLOWED_PACKAGE = "org.unlogged.demo.models";
    private static final String NOT_ALLOWED_PACKAGE = "org.unlogged.demo.nonserialmodel";

    @Override
    public ObjectInputFilter.Status checkInput(FilterInfo info) {
        Class<?> clazz = info.serialClass();
        if (clazz != null && clazz.getName().startsWith(ALLOWED_PACKAGE)) {
            return ObjectInputFilter.Status.ALLOWED;
        } else if (clazz != null && clazz.getName().startsWith(NOT_ALLOWED_PACKAGE)){
            return ObjectInputFilter.Status.REJECTED;
        } else return Status.UNDECIDED;
    }
}
