package org.unlogged.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unlogged.demo.dao.CustomerProfileRepo;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.redis.DeliveryUnit;
import org.unlogged.demo.models.weather.WeatherInfo;
import org.unlogged.demo.utils.LocationUtils;

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

    @Autowired
    private DeliveryUnitService deliveryUnitService;

    public boolean canDeliverToCustomer(long customerId) {
        CustomerProfile customerProfile = customerProfileRepo.getByCustomerId(customerId);
        String location = LocationUtils.getLocationFromAddress(customerProfile.getAddress());
        WeatherInfo weatherInfo = weatherService.getWeatherForAddress(location);

        List<DeliveryUnit> availableUnits = deliveryUnitService.getAvailableUnitsForLocation(
                deliveryUnitService.getAllDeliveryUnits(), location);
        if (availableUnits.size() == 0) {
            return false;
        }

        boolean canDeliver = false;
        if (weatherInfo.getCurrent().getPrecip_mm() < 2.51) {
            canDeliver = true;
        }
        boolean reportWritten = localFileService.writeReport(canDeliver, customerProfile);
        return reportWritten && canDeliver;
    }

    public List<CustomerProfile> getAllCustomers() {
        return customerProfileRepo.findAll();
    }

    public CustomerProfile addNewCustomer(CustomerProfile customerProfile) {
        customerProfileRepo.save(customerProfile);
        return customerProfile;
    }
}
