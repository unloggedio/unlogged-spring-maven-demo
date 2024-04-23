package org.unlogged.demo.service;

import org.springframework.stereotype.Service;
import org.unlogged.demo.models.*;

@Service
public class DeepService {

    public L1Object getDeepReference() {

        L10 l10 = new L10("10l-name", 1011);
        L9 l9 = new L9(911, "9l-name", l10);
        L8 l8 = new L8("8l-name", 811, l9);
        L7 l7 = new L7("7l-name", 711, l8);
        L6 l6 = new L6("6l-name", 611, l7);
        L5 l5 = new L5("5l-name", 511, l6);

        L4Object l4 = new L4Object();
        l4.setL4Id(411);
        l4.setL4Name("4l-name");
        l4.setL5(l5);

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
