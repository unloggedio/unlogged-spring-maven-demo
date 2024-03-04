package org.unlogged.demo.jspdemo.wfm.Models.Entities;

public class CustomerScoreCard {

    private CustomerProfile customerProfile;
    private int score;
    private boolean isEligible;

    public CustomerScoreCard(CustomerProfile customerProfile, int score, boolean isEligible) {
        this.customerProfile = customerProfile;
        this.score = score;
        this.isEligible = isEligible;
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
