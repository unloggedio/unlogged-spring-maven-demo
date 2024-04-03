package org.unlogged.demo.ui;

public class TC2ConstantsSet {

    private double discountPerCode = 0.1;
    private double maxDiscount = 0.7;
    private double deliveryCost = 220.0;
    private String groupId = "default-1";
    private String getDummyError = "no error";

    public double getDiscountPerCode() {
        return discountPerCode;
    }

    public void setDiscountPerCode(double discountPerCode) {
        this.discountPerCode = discountPerCode;
    }

    public double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGetDummyError() {
        return getDummyError;
    }

    public void setGetDummyError(String getDummyError) {
        this.getDummyError = getDummyError;
    }
}
