package org.unlogged.demo.models;

import java.sql.Timestamp;
import java.util.Date;

public class CustomerScoreCard {

    private CustomerProfile customerProfile;
    private int score;
    private boolean isEligible;
    private Timestamp valTime;
    private Date valDate;

    public CustomerScoreCard() {
    }

    public CustomerScoreCard(CustomerProfile customerProfile, int score, boolean isEligible) {
        this.customerProfile = customerProfile;
        this.score = score;
        this.isEligible = isEligible;
        this.valTime = new Timestamp(0);
        this.valDate = new Date(0);
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
    }
}
