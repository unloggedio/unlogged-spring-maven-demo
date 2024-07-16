package org.unlogged.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.service.PerfService;
import org.unlogged.demo.service.val;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;


@RestController
@RequestMapping("/perf")
public class PerfController {

	@Autowired
    private PerfService perfService;

    @RequestMapping("/ping")
    public String ping() {
        return "server up!";
    }

    @RequestMapping("/cpuintensive")
    public long cpu(@RequestParam long value) {
        return perfService.getCpuIntensiveData(value);
    }

    @RequestMapping("/memoryintensive1")
    public long memoryIntensive1(@RequestParam int count) {
        return perfService.sum_natural(count);
    }

    @RequestMapping("/memoryintensive2")
    public String memoryIntensive2(@RequestParam int count) {
        return perfService.readWriteInMemory(count);
    }

    @RequestMapping("/networkintensive")
    public String networkintensive(@RequestParam int count) {
        return perfService.genManyNetworkCall(count);
    }

    @RequestMapping("/databaseintensive")
    public String databaseintensive(@RequestParam int count) {
        return perfService.genDatabaseIntensive(count);
    }

    @RequestMapping("/fieldaccess")
    public void fieldAccess(){
        System.out.println("external = " + val.external);
        System.out.println("internal = " + val.nestedClass.internal);
        System.out.println("internal_enum = " + val.NestedEnum.INTERNAL_ENUM_1);

        ArrayList<Field> fieldList = new ArrayList<>();
        Class<?> classWithMessageKeys = null;
        try {
            classWithMessageKeys = Class.forName("org.unlogged.demo.service.val");

            Field[] fields = classWithMessageKeys.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            for (int i=0;i<=fieldList.size()-1;i++) {
                Field f = fieldList.get(i);
                Object val = f.get(null);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("class not found exception");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            System.out.println("illegal access exception");
            throw new RuntimeException(e);
        }
    }
}
