package org.unlogged.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unlogged.demo.Customer;
import org.unlogged.demo.dao.CustomerProfileRepo;
import org.unlogged.demo.dao.DeliveryRequestRepo;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.CustomerProfileRequest;
import org.unlogged.demo.models.DeliveryCheckResponse;
import org.unlogged.demo.models.DeliveryRequest;
import org.unlogged.demo.models.weather.WeatherInfo;
import org.unlogged.demo.utils.LocationUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerProfileRepo customerProfileRepo;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private LocalFileService localFileService;

//    @Autowired
//    private DeliveryUnitService deliveryUnitService;
    @Autowired
    private DeliveryRequestRepo deliveryRequestRepo;

    @Transactional
    public boolean initiateDelivery(long customerId) {
        DeliveryCheckResponse deliveryCheckResponse = canDeliverToCustomer(customerId);
        long lastId;
        if (deliveryCheckResponse.isCanDeliver()) {
            try {
                lastId = deliveryRequestRepo.getLastId();
            } catch (InvalidDataAccessResourceUsageException e) {
                lastId = 1;
            }
            deliveryRequestRepo.save(new DeliveryRequest(lastId, customerId,
                    deliveryCheckResponse, "" + new Date().toString().hashCode()));
            return true;
        } else {
            return false;
        }
    }

    public DeliveryCheckResponse canDeliverToCustomer(long customerId) {
        CustomerProfile customerProfile = customerProfileRepo.getByCustomerId(customerId);
        String location = LocationUtils.getLocationFromAddress(customerProfile.getAddress());
        WeatherInfo weatherInfo = weatherService.getWeatherForAddress(location);

//        List<DeliveryUnit> availableUnits = deliveryUnitService.getAvailableUnitsForLocation(
//                deliveryUnitService.getAllDeliveryUnits(), location);
//        if (availableUnits.size() == 0) {
//            return new DeliveryCheckResponse(customerProfile, false, false, weatherInfo);
//        }

        boolean canDeliver = false;
        if (weatherInfo.getCurrent().getPrecip_mm() < 2.51) {
            canDeliver = true;
        }
        boolean reportWritten = localFileService.writeReport(canDeliver, customerProfile);
        return new DeliveryCheckResponse(customerProfile,
                reportWritten, reportWritten && canDeliver, weatherInfo);
    }

    public List<CustomerProfile> getAllCustomers() {
        return customerProfileRepo.findAll();
    }

    public List<CustomerProfile> allCustomers() {
        List<CustomerProfile> customerProfiles = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            customerProfiles.addAll(getAllCustomers());
        }
        return customerProfiles;
    }

    public CustomerProfile addNewCustomer(CustomerProfileRequest customerProfileRequest) {
        Long lastId = customerProfileRepo.getLastId();
        if (lastId == null) {
            lastId = -1l;
        }
        return customerProfileRepo.save(new CustomerProfile(lastId + 1, customerProfileRequest.getCustomerName(),
                customerProfileRequest.getDateOfBirth(), customerProfileRequest.getEmail(),
                customerProfileRequest.getPrimaryNumber(), customerProfileRequest.getAddress(),
                customerProfileRequest.getCodes()));
    }
}
