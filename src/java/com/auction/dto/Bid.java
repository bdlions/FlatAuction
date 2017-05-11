package com.auction.dto;

/**
 *
 * @author nazmul hasan
 */
public class Bid {
    private int id;
    private String bidId;
    private User user;
    private Product product;
    private long createdOn;
    private double bidAmount;
    private Currency bidAmountUnit;
    
    //this will not be added into database. 
    private String bidTime;
    public Bid()
    {
        this.user = new User();
        this.product = new Product();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Currency getBidAmountUnit() {
        return bidAmountUnit;
    }

    public void setBidAmountUnit(Currency bidAmountUnit) {
        this.bidAmountUnit = bidAmountUnit;
    }

    public String getBidTime() {
        return bidTime;
    }

    public void setBidTime(String bidTime) {
        this.bidTime = bidTime;
    }

    
    
}
