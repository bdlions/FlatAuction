package com.auction.dto;

import com.auction.dto.response.ClientResponse;

/**
 *
 * @author nazmul hasan
 */
public class AccountSettingFA extends ClientResponse{
    private int id;
    private User user;
    private double defaultBidPerClick;
    private Currency defaultBidPerClickUnit;
    private double dailyBudget;
    private Currency dailyBudgetUnit;
    private boolean campainActive;
    public AccountSettingFA()
    {
        this.defaultBidPerClickUnit = new Currency();
        this.dailyBudgetUnit = new Currency();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getDefaultBidPerClick() {
        return defaultBidPerClick;
    }

    public void setDefaultBidPerClick(double defaultBidPerClick) {
        this.defaultBidPerClick = defaultBidPerClick;
    }

    public Currency getDefaultBidPerClickUnit() {
        return defaultBidPerClickUnit;
    }

    public void setDefaultBidPerClickUnit(Currency defaultBidPerClickUnit) {
        this.defaultBidPerClickUnit = defaultBidPerClickUnit;
    }

    public double getDailyBudget() {
        return dailyBudget;
    }

    public void setDailyBudget(double dailyBudget) {
        this.dailyBudget = dailyBudget;
    }

    public Currency getDailyBudgetUnit() {
        return dailyBudgetUnit;
    }

    public void setDailyBudgetUnit(Currency dailyBudgetUnit) {
        this.dailyBudgetUnit = dailyBudgetUnit;
    }

    public boolean isCampainActive() {
        return campainActive;
    }

    public void setCampainActive(boolean campainActive) {
        this.campainActive = campainActive;
    }
    
    
}
