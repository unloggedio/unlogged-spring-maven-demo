package org.unlogged.demo.models;

import lombok.Data;

@Data
public class CustomerScoreCard {

    private CustomerProfile customerProfile;
    private int score;
    private boolean isEligible;
//    private Date dateGenerated;

    public CustomerScoreCard(CustomerProfile customerProfile, int score, boolean isEligible) {
        this.customerProfile = customerProfile;
        this.score = score;
        this.isEligible = isEligible;
//        this.dateGenerated = new Date();
    }
}
