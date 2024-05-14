//package org.unlogged.demo.models.redis;
//
//import org.springframework.data.redis.core.RedisHash;
//
//import java.io.Serializable;
//
//@RedisHash("DeliveryUnitV2")
//public class DeliveryUnit implements Serializable {
//
//    private String id;
//    private String unitName;
//    private boolean available;
//    private String location;
//
//    public DeliveryUnit() {
//    }
//
//    public DeliveryUnit(String id, String unitName, boolean available, String location) {
//        this.id = id;
//        this.unitName = unitName;
//        this.available = available;
//        this.location = location;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getUnitName() {
//        return unitName;
//    }
//
//    public void setUnitName(String unitName) {
//        this.unitName = unitName;
//    }
//
//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//}
