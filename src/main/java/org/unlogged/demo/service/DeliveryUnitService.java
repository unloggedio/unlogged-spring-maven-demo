//package org.unlogged.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.unlogged.demo.dao.DeliveryUnitRepo;
//import org.unlogged.demo.models.redis.DeliveryUnit;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class DeliveryUnitService {
//
//    @Autowired
//    private DeliveryUnitRepo deliveryUnitRepo;
//
//    public List<DeliveryUnit> getAvailableUnitsForLocation(List<DeliveryUnit> deliveryUnits, String location) {
//        return deliveryUnits.stream()
//                .filter(e -> e.isAvailable() && e.getLocation().equalsIgnoreCase(location))
//                .collect(Collectors.toList());
//    }
//
//
//    public DeliveryUnit addNewDeliveryUnit(DeliveryUnit deliveryUnit) {
//        deliveryUnitRepo.save(deliveryUnit);
//        return deliveryUnit;
//    }
//
//    public DeliveryUnit getDeliveryUnit(String Id) {
//        return deliveryUnitRepo.findById(Id).get();
//    }
//
//    public List<DeliveryUnit> getAllDeliveryUnits() {
//        List<DeliveryUnit> deliveryUnits = new ArrayList<>();
//        deliveryUnitRepo.findAll().forEach(deliveryUnits::add);
//        return deliveryUnits;
//    }
//
//    public void clearAllUnits() {
//        deliveryUnitRepo.deleteAll();
//    }
//}
