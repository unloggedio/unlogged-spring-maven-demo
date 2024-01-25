package org.unlogged.demo.models;

public class DeliveryPromptCard {
    private boolean canDeliver;
    private CustomerProfile customerProfile;

    public DeliveryPromptCard() {}

    public DeliveryPromptCard(boolean canDeliver, CustomerProfile customerProfile) {
        this.canDeliver = canDeliver;
        this.customerProfile = customerProfile;
    }

    public boolean isCanDeliver() {
        return canDeliver;
    }

    public void setCanDeliver(boolean canDeliver) {
        this.canDeliver = canDeliver;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    @Override
    public String toString() {
        return "DeliveryPromptCard{" +
                "canDeliver=" + canDeliver +
                ", customerProfile=" + customerProfile +
                '}';
    }
}
