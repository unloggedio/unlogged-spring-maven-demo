package org.unlogged.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deliveryrequests")
public class DeliveryRequest {
    private long customerid;
    private String deliveryhash;
    private String deliveryCheckResponse;
    @Id
    private long deliveryid;

    public DeliveryRequest() {
    }

    public DeliveryRequest(long deliveryid, long customerid, DeliveryCheckResponse deliveryCheckResponse, String deliveryhash) {
        this.deliveryid = deliveryid;
        this.customerid = customerid;
        this.deliveryhash = deliveryhash;
        this.deliveryCheckResponse = deliveryCheckResponse.toString();
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public String getDeliveryhash() {
        return deliveryhash;
    }

    public void setDeliveryhash(String deliveryhash) {
        this.deliveryhash = deliveryhash;
    }

    public String getDeliveryCheckResponse() {
        return deliveryCheckResponse;
    }

    public void setDeliveryCheckResponse(DeliveryCheckResponse deliveryCheckResponse) {
        this.deliveryCheckResponse = deliveryCheckResponse.toString();
    }

    public long getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(long deliveryid) {
        this.deliveryid = deliveryid;
    }

    @Override
    public String toString() {
        return "DeliveryRequest{" +
                "customerid=" + customerid +
                ", deliveryhash='" + deliveryhash + '\'' +
                '}';
    }
}
