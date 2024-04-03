package org.unlogged.demo.ui;

public class TC2Response {

    private long customerId;
    private double productCost;
    private double deliveryCost;
    private double totalAmount;
    private boolean reportStatus;
    private String region;
    private String groupId;
    private String errorStatus;

    public TC2Response(long customerId, double productCost, double deliveryCost, double totalAmount, boolean reportStatus, String region,
                       String groupID, String errorStatus) {
        this.customerId = customerId;
        this.productCost = productCost;
        this.deliveryCost = deliveryCost;
        this.totalAmount = totalAmount;
        this.reportStatus = reportStatus;
        this.region = region;
        this.groupId = groupID;
        this.errorStatus = errorStatus;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(boolean reportStatus) {
        this.reportStatus = reportStatus;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
