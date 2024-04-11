package org.unlogged.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.unlogged.demo.dao.CustomerProfileRepo;
import org.unlogged.demo.models.CustomerProfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Component
public class UiTestPrepHelper {

    @Autowired
    private CustomerProfileRepo customerProfileRepo;

    private void addNewCustomerprofiles() {
        CustomerProfile profile = new CustomerProfile(1, "stone",
                "dobe", "stone@monolith.hill",
                "1-800-235-321", "zimbabwe",
                new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6")));
        customerProfileRepo.save(profile);

        profile = new CustomerProfile(2, " bone",
                "lobe", "rib@graveyard.somedome",
                "6-666-666-666", "death valley",
                new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f")));
        customerProfileRepo.save(profile);
    }
}
