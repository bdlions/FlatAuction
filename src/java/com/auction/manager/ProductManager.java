/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.auction.dto.Amenity;
import com.auction.dto.Availability;
import com.auction.dto.Currency;
import com.auction.dto.CurrencyUnit;
import com.auction.dto.Image;
import com.auction.dto.Location;
import com.auction.dto.Occupation;
import com.auction.dto.Pet;
import com.auction.dto.Product;
import com.auction.dto.ProductAmenities;
import com.auction.dto.ProductAvailabilities;
import com.auction.dto.ProductBid;
import com.auction.dto.ProductCategory;
import com.auction.dto.ProductSize;
import com.auction.dto.ProductType;
import com.auction.dto.SavedProduct;
import com.auction.dto.Smoking;
import com.auction.dto.Stay;
import com.auction.dto.User;
import com.auction.util.StringUtils;
import com.auction.util.TimeUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author alamgir
 */
public class ProductManager {

    private final Logger logger = LoggerFactory.getLogger(UserManager.class);
    //Session session = HibernateUtil.getSession();
    /**
     * This method will return all product types
     * @return List product type list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductType> getProductTypes() {
        List<ProductType> productTypes = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();        
        Query query = session.createSQLQuery("select {pt.*} from product_types pt")
                .addEntity("pt",ProductType.class);
        productTypes = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return productTypes;
    }
    
    /**
     * This method will return all product sizes
     * @return List product size list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductSize> getProductSizes() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<ProductSize> productSizes = new ArrayList<>();
        Query query = session.createSQLQuery("select {ps.*} from product_sizes ps")
                .addEntity("ps",ProductSize.class);
        productSizes = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return productSizes;
    }
    
    /**
     * This method will return all product categories
     * @return List product category list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductCategory> getProductCategories() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<ProductCategory> productCategories = new ArrayList<>();
        Query query = session.createSQLQuery("select {pc.*} from product_categories pc")
                .addEntity("pc",ProductCategory.class);
        productCategories = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return productCategories;
    }
    
    /**
     * This method will return all locations
     * @return List location list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Location> getLocations() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Location> locations = new ArrayList<>();
        Query query = session.createSQLQuery("select {l.*} from locations l")
                .addEntity("l",Location.class);
        //Query query = session.getNamedQuery("getLocations");
        locations = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return locations;
    }
    
    /**
     * This method will return all amenities
     * @return List amenity list
     * @author nazmul hasan on 11th July 2017
     */
    public List<Amenity> getAmenities() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Amenity> amenities = new ArrayList<>();
        Query query = session.createSQLQuery("select {a.*} from amenities a")
                .addEntity("a",Amenity.class);
        amenities = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return amenities;
    }
    
    /**
     * This method will return availability list
     * @return List stay list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Availability> getAvailabilities() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Availability> availabilities = new ArrayList<>();
        Query query = session.createSQLQuery("select {a.*} from availabilities a")
                .addEntity("a",Availability.class);
        availabilities = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return availabilities;
    }
    
    /**
     * This method will return stay list
     * @return List stay list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Stay> getStays() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Stay> stays = new ArrayList<>();
        Query query = session.createSQLQuery("select {s.*} from stays s")
                .addEntity("s",Stay.class);
        stays = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return stays;
    }
    
    /**
     * This method will return smoking list
     * @return List smoking list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Smoking> getSmokings() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Smoking> smokings = new ArrayList<>();
        Query query = session.createSQLQuery("select {s.*} from smokings s")
                .addEntity("s",Smoking.class);
        smokings = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return smokings;
    }
    
    /**
     * This method will return occupation list
     * @return List occupation list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Occupation> getOccupations() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Occupation> occupations = new ArrayList<>();
        Query query = session.createSQLQuery("select {o.*} from occupations o")
                .addEntity("o",Occupation.class);
        occupations = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return occupations;
    }
    
    /**
     * This method will return pet list
     * @return List pet list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Pet> getPets() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Pet> pets = new ArrayList<>();
        Query query = session.createSQLQuery("select {p.*} from pets p")
                .addEntity("p",Pet.class);
        pets = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return pets;
    }
    
    /**
     * This method will return user created product list
     * @param userId user id
     * @param offset offset
     * @param limit limit
     * @return List product list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Product> getMyProducts(int userId, int offset , int limit) {
        Session session = HibernateUtil.getSession();
        List<Product> products = new ArrayList<>();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("select {p.*} from products p where p.user_id = :user_id limit :limit offset :offset ")
                    .addEntity("p",Product.class)
                    .setInteger("user_id", userId)
                    .setInteger("limit", limit)
                    .setInteger("offset", offset);        
        products = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return products;
    }
    
    /**
     * This method will return closing product list
     * @param counter, counter
     * @return List product list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Product> getClosingProducts(int counter) {
        Session session = HibernateUtil.getSession();
        List<Product> products = new ArrayList<>();
        List<Product> tempProducts = new ArrayList<>();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("select {p.*} from products p ")
                    .addEntity("p",Product.class);        
        tempProducts = query.list();
        int productCounter = 1;
        TimeUtils timeUtils = new TimeUtils();
        for(Product product: tempProducts)
        {
            product.setTime(timeUtils.getEndingProductHumanToUnix(product.getAvailableFrom()));
            products.add(product);
            productCounter++;
            if(productCounter > counter)
            {
                break;
            }
        }
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        //session.getTransaction().commit();
        return products;
    }
    
    /**
     * This method will store a product under saved product list
     * @param userId user id
     * @param productId product id
     * @return boolean
     * @author nazmul hasan on 18th june 2017
     */
    public boolean addSavedProduct(int userId, int productId)
    {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("select {sp.*} from saved_products sp where user_id = :user_id and product_id = :product_id ")
                    .addEntity("sp",SavedProduct.class)
                    .setInteger("user_id", userId)
                    .setInteger("product_id", productId);
        List<SavedProduct> savedProducts =  query.list();
        if(savedProducts != null && !savedProducts.isEmpty())
        {
            return false;
        }
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        transaction = session.beginTransaction();
        User user = new User();
        user.setId(userId);
        Product product = new Product();
        product.setId(productId);
        SavedProduct savedProduct = new SavedProduct();
        savedProduct.setUser(user);
        savedProduct.setProduct(product);
        session.save(savedProduct);
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return true;
    }
    
    /**
     * This method will return user saved product list
     * @param userId user id
     * @param offset offset
     * @param limit limit
     * @return List product list
     * @author nazmul hasan on 18th june 2017
     */
    public List<Product> getSavedProducts(int userId, int offset , int limit) {
        Session session = HibernateUtil.getSession();
        List<Product> products = new ArrayList<>();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("select {sp.*}, {p.*} from saved_products sp join products p on sp.product_id = p.id  where sp.user_id = :user_id limit :limit offset :offset ")
                    .addEntity("sp",SavedProduct.class)
                    .addEntity("p",Product.class)
                    .setInteger("user_id", userId)
                    .setInteger("limit", limit)
                    .setInteger("offset", offset);        
        List<Object[]> rows = query.list();
        for(Object[] row: rows)
        {
            Product product = (Product)row[1];
            products.add(product);
        }
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return products;
    }
    
    public List<Product> getProducts(int offset , int limit) {
        Session session = HibernateUtil.getSession();
        List<Product> productList = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("select {p.*} from products p limit :limit offset :offset ")
                    .addEntity("p",Product.class)
                    .setInteger("limit", limit)
                    .setInteger("offset", offset);        
        products = query.list();
        for(Product product : products)
        {
            Image[] images = new Image[2];
            Image image1 = new Image();
            Image image2 = new Image();
            if(StringUtils.isNullOrEmpty(product.getImg()))
            {
                image1.setTitle("a.jpg");
                image2.setTitle("b.jpg");
            }
            else
            {
                image1.setTitle(product.getImg());
                image2.setTitle(product.getImg());
            }
            
            images[0] = image1;
            images[1] = image2;            
            product.setImages(images);
            productList.add(product);
        }
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return productList;
    }
    
    /**
     * This method will create a new product
     * @param product product info
     * @author nazmul hasan on 31st May 2017
     */
    public void addProduct(Product product) {
        Session session = HibernateUtil.getSession();
        //setting a reference id
        Image[] images = product.getImages();
        product.setReferenceId(StringUtils.getProductReferenceId());
        Transaction transaction = session.beginTransaction();
        session.save(product);
        if (images != null) {
            for (Image image : images) {
                image.setProductId(product.getId());
                session.save(image);
            }
        }
        List<Amenity> amenities = product.getAmenities();
        if (amenities != null) {
            for (Amenity amenity : amenities) {
                ProductAmenities productAmenities = new ProductAmenities();
                productAmenities.setAmenity(amenity);
                productAmenities.setProduct(product);
                session.save(productAmenities);
            }
        }
        List<Availability> availabilities = product.getAvailabilities();
        if (availabilities != null) {
            for (Availability availability : availabilities) {
                ProductAvailabilities productAvailabilities = new ProductAvailabilities();
                productAvailabilities.setAvailability(availability);
                productAvailabilities.setProduct(product);
                session.save(productAvailabilities);
            }
        }
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
    }
    
    /**
     * This method will create a new product
     * @param productBid product bid info
     * @author nazmul hasan on 11th June 2017
     */
    public void addProductBid(ProductBid productBid) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(productBid);
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
    }
    
    /**
     * This method will update product info
     * @param product product info
     * @author nazmul hasan on 17th June 2017
     */
    public void updateProduct(Product product) {
        Session session = HibernateUtil.getSession();
        session.clear();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        try
        {
            //delete current amenities
            Query query1 = session.createSQLQuery(" delete from products_amenities where product_id = :product_id")
                .setInteger("product_id", product.getId());
            query1.executeUpdate();
            //add amenities
            List<Amenity> amenities = product.getAmenities();
            if (amenities != null) {
                for (Amenity amenity : amenities) {
                    ProductAmenities productAmenities = new ProductAmenities();
                    productAmenities.setAmenity(amenity);
                    productAmenities.setProduct(product);
                    session.save(productAmenities);
                }
            }
            
            //delete current availabilities
            Query query2 = session.createSQLQuery(" delete from products_availabilities where product_id = :product_id")
                .setInteger("product_id", product.getId());
            query2.executeUpdate();
            //add availabilities
            List<Availability> availabilities = product.getAvailabilities();
            if (availabilities != null) {
                for (Availability availability : availabilities) {
                    ProductAvailabilities productAvailabilities = new ProductAvailabilities();
                    productAvailabilities.setAvailability(availability);
                    productAvailabilities.setProduct(product);
                    session.save(productAvailabilities);
                }
            }
        }
        catch(Exception ex)
        {
            logger.debug(ex.toString());
        }        
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
    }
    
    public List<ProductBid> getProductBidList(int productId)
    {
    List<ProductBid> productBidList = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("select {pb.*}, {p.*}, {u.*}, {c.*}, {cu.*} from product_bids pb join products p on pb.product_id = p.id join users u on pb.user_id = u.id join currencies c on pb. currency_id = c.id join currency_units cu on pb.currency_unit_id = cu.id where pb.product_id = :product_id ")
                    .addEntity("pb", ProductBid.class)
                    .addEntity("p", Product.class)
                    .addEntity("u", User.class)
                    .addEntity("c", Currency.class)
                    .addEntity("cu", CurrencyUnit.class)
                    .setInteger("product_id", productId);
        List<Object[]> rows =  query.list();
        for(Object[] row: rows)
        {
            productBidList.add((ProductBid)row[0]);
        }
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return productBidList;
    }
    
    public Product getProductInfo(int productId) {
        Product product = null;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();        
        Query query = session.createSQLQuery("select {p.*}, {pt.*} from products p join product_types pt on p.product_type_id = pt.id where p.id = :id ")
                    .addEntity("p",Product.class)
                    .addJoin("pt","p.productType")
                    .setInteger("id", productId);
        
        List<Object[]> rows = query.list();
        for (Object[] row : rows) 
        {
            product = (Product)row[0];
            break;
        }
        TimeUtils timeUtils = new TimeUtils();
        product.setTime(timeUtils.getEndingProductHumanToUnix(product.getAvailableFrom()));
        product.setAmenities(new ArrayList<>());
        product.setAvailabilities(new ArrayList<>());
        product.setImages(new Image[0]);
        try
        {
            Query query2 = session.createSQLQuery("select {a.*} from amenities a join products_amenities pa on a.id = pa.amenity_id where pa.product_id = :product_id ")
                    .addEntity("a",Amenity.class)
                    .setInteger("product_id", productId);
        
            List<Object[]> rows2 = query2.list();
            for (Object row : rows2) 
            {
                product.getAmenities().add((Amenity)row);
            }
            
            Query query3 = session.createSQLQuery("select {a.*} from availabilities a join products_availabilities pa on a.id = pa.availability_id where pa.product_id = :product_id ")
                    .addEntity("a",Availability.class)
                    .setInteger("product_id", productId);
        
            List<Object[]> rows3 = query3.list();
            for (Object row : rows3) 
            {
                product.getAvailabilities().add((Availability)row);
            }
            
            Query imageQuery = session.createSQLQuery("select {pi.*} from product_images pi join products p on pi.product_id = p.id where pi.product_id = :product_id ")
                    .addEntity("pi",Image.class)
                    .setInteger("product_id", productId);
        
            List<Object[]> imageRows = imageQuery.list();            
            if(imageRows != null && imageRows.size() > 0)
            {
                Image[] productImages = new Image[imageRows.size()];
                int imageCounter = 0;
                for (Object imageRow : imageRows) 
                {
                    productImages[imageCounter++] = (Image)imageRow;
                }
                product.setImages(productImages);
            } 
            
            Query productBidQuery = session.createSQLQuery("select {pb.*} from product_bids pb join products p on pb.product_id = p.id where pb.product_id = :product_id ")
                    .addEntity("pb",ProductBid.class)
                    .setInteger("product_id", productId);
        
            List<Object[]> productBidRows = productBidQuery.list();            
            if(productBidRows != null)
            {
                product.setTotalBids(productBidRows.size());
            }  
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
        }
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return product;
    }
    

    public void addProductImages(int productId, Image[] images) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        if (images != null) {
            for (Image image : images) {
                image.setProductId(productId);
                session.save(image);
            }
        }

        if (!transaction.wasCommitted()){
            transaction.commit();
        }
    }

    public Product getProduct(int productId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("getProductDetail")
                        .setInteger("productId", productId);
        Product product = (Product)query.uniqueResult();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return product;
    }
}
