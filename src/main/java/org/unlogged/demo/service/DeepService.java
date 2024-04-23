package org.unlogged.demo.service;

import org.springframework.stereotype.Service;
import org.unlogged.demo.models.*;

@Service
public class DeepService {

    public L1Object getDeepReference() {
        L4Object l4 = new L4Object();
        l4.setL4Id(411);
        l4.setL4Name("4l-name");

        L3Object l3Object = new L3Object();
        l3Object.setL4Object(l4);
        l3Object.setL3Id(311);
        l3Object.setL3Name("3l-name");

        L2Object2 l2Object2 = new L2Object2();
        l2Object2.setL3SubModel(l3Object);
        l2Object2.setL22Id(221);

        L2Object1 l2Object1 = new L2Object1();
        l2Object1.setL2Uuid("L2-UUID-1");
        l2Object1.setName("2l1-name");
        l2Object1.setL21Id(211);

        L1Object l1Object = new L1Object();
        l1Object.setId(111);
        l1Object.setName("1l-name");
        l1Object.setUuid("L1-UUID");
        l1Object.setMake(l2Object1);
        l1Object.setModel(l2Object2);

        return l1Object;
    }
}
