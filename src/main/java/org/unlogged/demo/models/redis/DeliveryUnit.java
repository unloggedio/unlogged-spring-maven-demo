package org.unlogged.demo.models.redis;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
@Data
@RedisHash("DeliveryUnitV2")
public class DeliveryUnit implements Serializable {

    private String id;
    private String unitName;
    private boolean available;
    private String location;
}
