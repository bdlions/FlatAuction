package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.util.ArrayList;

/**
 *
 * @author nazmul hasan
 */
public class Product extends ClientResponse
{
    private int id;
    private String productId;
    private User user;
    private String title;
    private String description;
    private String firstName;
    private String lastName;
    private String phone;
    private Image[] images;
    private Location location;
    private ProductType productType;
    private ProductSize productSize;
    private ProductCategory productCategory;
    private ArrayList<Amenity> amenities;
    private Smoking smoking;
    private Gender gender;
    private Occupation occupation;
    private Pet pet;
    private ArrayList<Duration> durations;
    private Currency basePrice;
    private Currency securityDeposit;
    private String startDate;
    private String endDate;
    private Stay minStay;
    private Stay maxStay;
    private boolean isFeaturedAd;
    private boolean isDefaultBid;
    private Currency adBid;
    

    
    public Product()
    {
        this.location = new Location();
        this.productType = new ProductType();
        this.productSize = new ProductSize();
        this.productCategory = new ProductCategory();
        this.amenities = new ArrayList<>();
        this.smoking = new Smoking();
        this.occupation = new Occupation();
        this.gender = new Gender();
        this.pet = new Pet();
        this.durations = new ArrayList<>();
        this.basePrice = new Currency();   
        this.securityDeposit = new Currency();
        this.minStay = new Stay();
        this.maxStay = new Stay();
        this.adBid = new Currency();
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

    public ArrayList<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(ArrayList<Amenity> amenities) {
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

    public Currency getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Currency basePrice) {
        this.basePrice = basePrice;
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

    public ArrayList<Duration> getDurations() {
        return durations;
    }

    public void setDurations(ArrayList<Duration> durations) {
        this.durations = durations;
    }

    public Currency getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(Currency securityDeposit) {
        this.securityDeposit = securityDeposit;
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

    public Currency getAdBid() {
        return adBid;
    }

    public void setAdBid(Currency adBid) {
        this.adBid = adBid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
