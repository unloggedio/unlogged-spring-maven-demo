package org.unlogged.demo.filter.abs;

import java.util.List;
import java.util.Objects;

import org.unlogged.demo.filter.abs.model.FieldC;
import org.unlogged.demo.filter.abs.model.FilterC;

public abstract class BaseFilterC<T> extends FilterC<T> implements Cloneable {

    private String requestId;

    public BaseFilterC() {
        super();
    }

    public BaseFilterC(BaseFilterC filter) {
        super(filter);
        this.requestId = filter.getRequestId();
    }

    public abstract List<List<FieldC>> getMandatoryFields();

    public abstract List<FieldC> getSelectFields();

    public abstract List<FieldC> getGroupByFields();

    public abstract List<FieldC> getAggregatableFields();

    public abstract BaseFilterC clone();

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BaseFilterC<?> that = (BaseFilterC<?>) o;
        return Objects.equals(requestId, that.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), requestId);
    }

    @Override
    public String toString() {
        return "BaseFilterC{" +
                "requestId='" + requestId + "', " +
                super.toString() +
                '}';
    }
}