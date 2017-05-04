package com.auction.dto;

import com.auction.util.ClientResponse;

/**
 *
 * @author nazmul hasan
 */
public class Product extends ClientResponse
{
    private int id;
    private String productId;
    private String title;
    private String description;
    private Currency basePrice;
    private String time;
    private Location location;
    private String img;
    private Image[] images;
    private String startDate;
    private String endDate;
    private String timeLeft;
    private int totalBidders;
    private int totalBids;

    private String price_type;
    private String price;
    private String available;
    private String size;
    
    public Product()
    {
        this.basePrice = new Currency();
        this.location = new Location();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Currency getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Currency basePrice) {
        this.basePrice = basePrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public int getTotalBidders() {
        return totalBidders;
    }

    public void setTotalBidders(int totalBidders) {
        this.totalBidders = totalBidders;
    }

    public int getTotalBids() {
        return totalBids;
    }

    public void setTotalBids(int totalBids) {
        this.totalBids = totalBids;
    }

    public String getPrice_type() {
        return price_type;
    }

    public void setPrice_type(String price_type) {
        this.price_type = price_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
}
