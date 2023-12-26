package org.unlogged.demo.models;

import lombok.Data;

@Data
public class DeliveryPromptCard {
    private boolean canDeliver;
    private CustomerProfile customerProfile;

    public DeliveryPromptCard(boolean canDeliver, CustomerProfile customerProfile) {
        this.canDeliver = canDeliver;
        this.customerProfile = customerProfile;
    }
}
