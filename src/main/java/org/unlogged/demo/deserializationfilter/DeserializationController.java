package org.unlogged.demo.deserializationfilter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.models.Dog;
import org.unlogged.demo.nonserialmodel.Cat;
import org.unlogged.demo.undecidedstatus.Mouse;

import java.io.*;

@RestController
@RequestMapping("/deserialize")
public class DeserializationController {

    private static final String ALLOWED_PACKAGE_FOR_ALLOW_FILTER = "org.unlogged.demo.nonserialmodel";
    private static final String NOT_ALLOWED_PACKAGE_FOR_REJECT_FILTER = "org.unlogged.demo.models";

    @GetMapping("/1")
    public String deserializeObject1() {

        Dog dog = new Dog("Test Dog", 22);
        try {
            byte[] serializedObject = serializeObject(dog);
            ObjectInputFilter filter = new CustomObjectInputFilter();
            ByteArrayInputStream bais = new ByteArrayInputStream(serializedObject);
            ObjectInputStream ois = new ObjectInputStream(bais);

            ois.setObjectInputFilter(filter);

            // Deserialize the object
            Serializable deserializedObject = (Serializable) ois.readObject();

            return "Deserialized object: " + deserializedObject.toString();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            return "Error during deserialization: " + e.getMessage();
        }
    }

    //Expected to throw exception
    @GetMapping("/2")
    public String deserializeObjectNotAllowed() {

        Cat cat = new Cat("Test Cat", 22);
        try {
            byte[] serializedObject = serializeObject(cat);
            ObjectInputFilter filter = new CustomObjectInputFilter();
            ByteArrayInputStream bais = new ByteArrayInputStream(serializedObject);
            ObjectInputStream ois = new ObjectInputStream(bais);

            ois.setObjectInputFilter(filter);

            // Deserialize the object
            Serializable deserializedObject = (Serializable) ois.readObject();

            return "Deserialized object: " + deserializedObject.toString();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            return "Error during deserialization: " + e.getMessage();
        }
    }

    @GetMapping("/3")
    public String deserializeObjectWithAllowFilter() {
        Cat cat = new Cat("Test Cat", 22);
        try {
            byte[] serializedObject = serializeObject(cat);

            // Create allowFilter using a predicate
            ObjectInputFilter filter = ObjectInputFilter.allowFilter(
                    clazz -> clazz != null && clazz.getName().startsWith(ALLOWED_PACKAGE_FOR_ALLOW_FILTER),
                    ObjectInputFilter.Status.REJECTED
            );

            ByteArrayInputStream bais = new ByteArrayInputStream(serializedObject);
            ObjectInputStream ois = new ObjectInputStream(bais);

            ois.setObjectInputFilter(filter);

            // Deserialize the object
            Serializable deserializedObject = (Serializable) ois.readObject();

            return "Deserialized object: " + deserializedObject.toString();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            return "Error during deserialization: " + e.getMessage();
        }
    }

    //Expected to fail for Dog since we are forcing reject Filter
    @GetMapping("/4")
    public String deserializeObjectWithRejectFilter() {
        Dog dog = new Dog("Test Dog", 22);
        try {
            byte[] serializedObject = serializeObject(dog);

            // Create rejectFilter using a predicate
            ObjectInputFilter filter = ObjectInputFilter.rejectFilter(
                    clazz -> clazz != null && clazz.getName().startsWith(NOT_ALLOWED_PACKAGE_FOR_REJECT_FILTER),
                    ObjectInputFilter.Status.REJECTED
            );

            ByteArrayInputStream bais = new ByteArrayInputStream(serializedObject);
            ObjectInputStream ois = new ObjectInputStream(bais);

            ois.setObjectInputFilter(filter);

            // Deserialize the object
            Serializable deserializedObject = (Serializable) ois.readObject();

            return "Deserialized object: " + deserializedObject.toString();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            return "Error during deserialization: " + e.getMessage();
        }
    }

    //Should throw an exception but why?
    @GetMapping("/5")
    public String deserializeObjectWithMergedFilters() {
        Cat cat = new Cat("Test Cat", 22);
        try {
            byte[] serializedObject = serializeObject(cat);

            // Create filters to merge
            ObjectInputFilter filter1 = ObjectInputFilter.rejectFilter(
                    clazz -> clazz != null && clazz.getName().startsWith(NOT_ALLOWED_PACKAGE_FOR_REJECT_FILTER),
                    ObjectInputFilter.Status.REJECTED
            );

            // Create allowFilter using a predicate
            ObjectInputFilter filter2 = ObjectInputFilter.allowFilter(
                    clazz -> clazz != null && clazz.getName().startsWith(ALLOWED_PACKAGE_FOR_ALLOW_FILTER),
                    ObjectInputFilter.Status.REJECTED
            );

            // Merge filters
            ObjectInputFilter mergedFilter = ObjectInputFilter.merge(filter1, filter2);

            ByteArrayInputStream bais = new ByteArrayInputStream(serializedObject);
            ObjectInputStream ois = new ObjectInputStream(bais);

            ois.setObjectInputFilter(mergedFilter);

            // Deserialize the object
            Serializable deserializedObject = (Serializable) ois.readObject();

            return "Deserialized object: " + deserializedObject.toString();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            return "Error during deserialization: " + e.getMessage();
        }
    }
    @GetMapping("/6")
    public String deserializeObjectRejectUndecided() {

        Mouse mouse = new Mouse("Test Mouse", 22);
        try {
            byte[] serializedObject = serializeObject(mouse);

            // Create a filter that rejects undecided classes
            ObjectInputFilter undecidedFilter = ObjectInputFilter.rejectUndecidedClass(new CustomObjectInputFilter());

            ByteArrayInputStream bais = new ByteArrayInputStream(serializedObject);
            ObjectInputStream ois = new ObjectInputStream(bais);

            ois.setObjectInputFilter(undecidedFilter);

            // Deserialize the object
            Serializable deserializedObject = (Serializable) ois.readObject();

            return "Deserialized object: " + deserializedObject.toString();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            return "Error during deserialization: " + e.getMessage();
        }
    }

    private static byte[] serializeObject(Object obj) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            return bos.toByteArray();
        }
    }
}

