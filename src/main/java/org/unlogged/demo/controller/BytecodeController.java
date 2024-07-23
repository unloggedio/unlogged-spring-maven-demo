package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.service.ReflectionService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/bytecode")
public class BytecodeController {

    @RequestMapping("/fieldaccess")
    public void fieldAccess(){
        System.out.println("external = " + ReflectionService.external);
        System.out.println("internal = " + ReflectionService.nestedClass.internal);
        System.out.println("internal_enum = " + ReflectionService.NestedEnum.INTERNAL_ENUM_1);

        ArrayList<Field> fieldList = new ArrayList<>();
        Class<?> classWithMessageKeys = null;
        try {
            classWithMessageKeys = Class.forName("org.unlogged.demo.service.ReflectionService");

            Field[] fields = classWithMessageKeys.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            for (int i=0;i<=fieldList.size()-1;i++) {
                System.out.println("--------");
                Field f = fieldList.get(i);
                System.out.println("f = " + f);
                Object val = f.get(null);
                System.out.println("val = " + val);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("class not found exception");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            System.out.println("illegal access exception");
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/lambda")
    public void lambdaTest() {
        List<String> names = Arrays.asList("aa", "b", "fdd", "wddd", "cdddd");
        names.sort((String s1, String s2) -> s1.length() - s2.length());
        names.forEach(System.out::println);
    }
}
