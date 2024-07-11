package org.unlogged.demo.controller.abstractions;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CrudController<T, ID> {

    int localA = alpha.a;

    @RequestMapping("/find")
    public T findById(@RequestParam("id") ID id);

    @RequestMapping("/findAll")
    public List<T> findAll();

    @RequestMapping("/insert")
    public T insertNew(@RequestBody T payload);

    @RequestMapping("/update")
    public T update(@RequestBody T t);

    @RequestMapping("/delete")
    public T deleteById(@RequestParam("id") ID id);
}
