package org.unlogged.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.unlogged.demo.dao.CustomerProfileRepo;
import org.unlogged.demo.jspdemo.wfm.ApiHelper.WeatherInfo;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.jspdemo.wfm.Services.CustomService;
import org.unlogged.demo.jspdemo.wfm.Services.CustomService2;
import org.unlogged.demo.jspdemo.wfm.ThirdPartyService;
import org.unlogged.demo.models.CustomerProfile;
import org.unlogged.demo.models.redis.DeliveryUnit;
import org.unlogged.demo.service.DeliveryUnitService;
import org.unlogged.demo.service.LocalFileService;

import java.util.List;

@Service
@Component
public class UiTestEntryClass {

    private CustomService customService = new CustomService2();

    @Autowired
    private TC1MockService tc1MockService;

    @Autowired
    private CustomerProfileRepo customerProfileRepo;

    @Autowired
    private DeliveryUnitService deliveryUnitService;

    @Autowired
    private LocalFileService localFileService;

    private TC2ConstantsSet constantsSet = new TC2ConstantsSet();

    @Autowired
    private ThirdPartyService thirdPartyService;

    //TC1 - Test to ensure mocks are created for the mockable calls in this method
    private User mockTC1() {
        String randomString = tc1MockService.getAString();
        return tc1MockService.getUser();
    }

    //TC2 - Test to ensure crud and influence of mocks along with saving mocks.
    private TC2Response mockTestCRUD() throws Exception {
        CustomerProfile profile = customerProfileRepo.getByCustomerId(1);
        double baseAmount = 1000.0;
        double discountPerCode = constantsSet.getDiscountPerCode();
        double maxDiscount = constantsSet.getMaxDiscount();
        double deliveryCost = constantsSet.getDeliveryCost();
        double finalDiscountModifier = discountPerCode * profile.getReferralcodes().size();
        double finalProductCost = baseAmount * (Math.min(finalDiscountModifier, maxDiscount));
        WeatherInfo weatherInfo = thirdPartyService.getWeatherFor(profile.getAddress());
        List<DeliveryUnit> deliveryUnitList = deliveryUnitService.getAllDeliveryUnits();
        if (deliveryUnitList == null || deliveryUnitList.size() == 0) {
            deliveryUnitService.addNewDeliveryUnit(
                    new DeliveryUnit("newCreated", "newDefault",
                            true, "universal"));
        }
        String constantsGroupId = constantsSet.getGroupId();
        String dummyError = "";
        try {
            dummyError = constantsSet.getGetDummyError();
        } catch (Exception e) {
            dummyError = e.getMessage();
        }
        boolean reportStatus = localFileService.writeReport(true, profile);
        return new TC2Response(profile.getCustomerid(), baseAmount, deliveryCost,
                finalProductCost + deliveryCost, reportStatus, weatherInfo.getLocation().region,
                constantsGroupId, dummyError);
    }
}
