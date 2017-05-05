package com.auction.dto;

import com.auction.dto.response.ClientResponse;

/**
 *
 * @author nazmul hasan
 */
public class AccountSettingFA extends ClientResponse{
    private Currency defaultBidPerClick;
    private Currency dailyBudget;
    private boolean campainActive;
    public AccountSettingFA()
    {
    
    }

    public Currency getDefaultBidPerClick() {
        return defaultBidPerClick;
    }

    public void setDefaultBidPerClick(Currency defaultBidPerClick) {
        this.defaultBidPerClick = defaultBidPerClick;
    }

    public Currency getDailyBudget() {
        return dailyBudget;
    }

    public void setDailyBudget(Currency dailyBudget) {
        this.dailyBudget = dailyBudget;
    }

    public boolean isCampainActive() {
        return campainActive;
    }

    public void setCampainActive(boolean campainActive) {
        this.campainActive = campainActive;
    }
    
}
