package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author nazmul hasan
 */
public class Product extends ClientResponse implements Serializable
{
    private int id;
//    private String productId;
    private User user;
    private String title;
    private String description;
    private String firstName;
    private String lastName;
    private String phone;
    private String img;
    private Image[] images;
    private Location location;
    private ProductType productType;
    private ProductSize productSize;
    private ProductCategory productCategory;
    private Set<Amenity> amenities;
    private Smoking smoking;
    private Gender gender;
    private Occupation occupation;
    private Pet pet;
    private Set<Duration> durations;
    private double basePrice;
    private Currency basePriceUnit;
    private double securityDeposit;
    private Currency securityDepositUnit;
    private String startDate;
    private String endDate;
    private Stay minStay;
    private Stay maxStay;
    private boolean isFeaturedAd;
    private boolean isDefaultBid;
    private double adBid;
    private Currency adBidUnit;
    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getProductId() {
//        return productId;
//    }
//
//    public void setProductId(String productId) {
//        this.productId = productId;
//    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Set<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(Set<Amenity> amenities) {
        this.amenities = amenities;
    }

    public Smoking getSmoking() {
        return smoking;
    }

    public void setSmoking(Smoking smoking) {
        this.smoking = smoking;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Duration> getDurations() {
        return durations;
    }

    public void setDurations(Set<Duration> durations) {
        this.durations = durations;
    }

    public Stay getMinStay() {
        return minStay;
    }

    public void setMinStay(Stay minStay) {
        this.minStay = minStay;
    }

    public Stay getMaxStay() {
        return maxStay;
    }

    public void setMaxStay(Stay maxStay) {
        this.maxStay = maxStay;
    }

    public boolean isIsFeaturedAd() {
        return isFeaturedAd;
    }

    public void setIsFeaturedAd(boolean isFeaturedAd) {
        this.isFeaturedAd = isFeaturedAd;
    }

    public boolean isIsDefaultBid() {
        return isDefaultBid;
    }

    public void setIsDefaultBid(boolean isDefaultBid) {
        this.isDefaultBid = isDefaultBid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Currency getBasePriceUnit() {
        return basePriceUnit;
    }

    public void setBasePriceUnit(Currency basePriceUnit) {
        this.basePriceUnit = basePriceUnit;
    }

    public double getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public Currency getSecurityDepositUnit() {
        return securityDepositUnit;
    }

    public void setSecurityDepositUnit(Currency securityDepositUnit) {
        this.securityDepositUnit = securityDepositUnit;
    }

    public double getAdBid() {
        return adBid;
    }

    public void setAdBid(double adBid) {
        this.adBid = adBid;
    }

    public Currency getAdBidUnit() {
        return adBidUnit;
    }

    public void setAdBidUnit(Currency adBidUnit) {
        this.adBidUnit = adBidUnit;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
