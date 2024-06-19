package org.unlogged.demo.service.abstractions;

import java.util.List;

public interface CrudService<T, ID> {
    public T getById(ID id);

    public List<T> getAll();

    public T insertNew(T t);

    public T updateExisting(T t);

    public T deleteById(ID id);
}
