package com.auction.dto;

/**
 *
 * @author nazmul hasan
 */
public class Currency {
    private String id;
    private String title;
    private CurrencyUnit currencyUnit;
    public Currency()
    {
        currencyUnit = new CurrencyUnit();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CurrencyUnit getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(CurrencyUnit currencyUnit) {
        this.currencyUnit = currencyUnit;
    }
    
}
