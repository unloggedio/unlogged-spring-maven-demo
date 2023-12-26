package org.unlogged.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "deliveryrequests")
public class DeliveryRequest {
    private long customerid;
    private String deliveryhash;
    private String deliveryCheckResponse;
    @Id
    private long deliveryid;

    public DeliveryRequest(long deliveryid, long customerid, DeliveryCheckResponse deliveryCheckResponse, String deliveryhash) {
        this.deliveryid = deliveryid;
        this.customerid = customerid;
        this.deliveryhash = deliveryhash;
        this.deliveryCheckResponse = deliveryCheckResponse.toString();
    }
}
