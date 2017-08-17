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
import com.auction.dto.SearchParams;
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
 * @author nazmul hasan
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
        Transaction transaction = null;
        List<ProductType> productTypes = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select {pt.*} from product_types pt")
                    .addEntity("pt",ProductType.class);
            productTypes = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            productTypes = new ArrayList<>();
//        }        
        return productTypes;
    }
    
    /**
     * This method will return all product sizes
     * @return List product size list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductSize> getProductSizes() {
        Transaction transaction = null;
        List<ProductSize> productSizes = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select {ps.*} from product_sizes ps")
                    .addEntity("ps",ProductSize.class);
            productSizes = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            productSizes = new ArrayList<>();
//        }        
        return productSizes;
    }
    
    /**
     * This method will return all product categories
     * @return List product category list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductCategory> getProductCategories() {
        Transaction transaction = null;
        List<ProductCategory> productCategories = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select {pc.*} from product_categories pc")
                    .addEntity("pc",ProductCategory.class);
            productCategories = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            productCategories = new ArrayList<>();
//        }        
        return productCategories;
    }
    
    /**
     * This method will return all locations
     * @return List location list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Location> getLocations() {
        Transaction transaction = null;
        List<Location> locations = new ArrayList<>();
        
//        try
//        {
            Session session = HibernateUtil.getSession();            
            session.clear();            
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {l.*} from locations l")
                    .addEntity("l",Location.class);
            locations = query.list();            
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            locations = new ArrayList<>();
//        }        
        return locations;
    }
    
    /**
     * This method will return all amenities
     * @return List amenity list
     * @author nazmul hasan on 11th July 2017
     */
    public List<Amenity> getAmenities() {
        Transaction transaction = null;
        List<Amenity> amenities = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select {a.*} from amenities a")
                    .addEntity("a",Amenity.class);
            amenities = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            amenities = new ArrayList<>();
//        }        
        return amenities;
    }
    
    /**
     * This method will return availability list
     * @return List stay list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Availability> getAvailabilities() {
        Transaction transaction = null;
        List<Availability> availabilities = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select {a.*} from availabilities a")
                    .addEntity("a",Availability.class);
            availabilities = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            availabilities = new ArrayList<>();
//        }        
        return availabilities;
    }
    
    /**
     * This method will return stay list
     * @return List stay list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Stay> getStays() {
        Transaction transaction = null;
        List<Stay> stays = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select {s.*} from stays s")
                    .addEntity("s",Stay.class);
            stays = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            stays = new ArrayList<>();
//        }        
        return stays;
    }
    
    /**
     * This method will return smoking list
     * @return List smoking list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Smoking> getSmokings() {
        Transaction transaction = null;
        List<Smoking> smokings = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select {s.*} from smokings s")
                    .addEntity("s",Smoking.class);
            smokings = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            smokings = new ArrayList<>();
//        }        
        return smokings;
    }
    
    /**
     * This method will return occupation list
     * @return List occupation list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Occupation> getOccupations() {
        Transaction transaction = null;
        List<Occupation> occupations = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();            
            Query query = session.createSQLQuery("select {o.*} from occupations o")
                    .addEntity("o",Occupation.class);
            occupations = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            occupations = new ArrayList<>();
//        }
        
        return occupations;
    }
    
    /**
     * This method will return pet list
     * @return List pet list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Pet> getPets() {
        Transaction transaction = null;
        List<Pet> pets = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();            
            Query query = session.createSQLQuery("select {p.*} from pets p")
                    .addEntity("p",Pet.class);
            pets = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            pets = new ArrayList<>();
//        }        
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
        Transaction transaction = null;
        List<Product> products = new ArrayList<>();
        try
        {
            Session session = HibernateUtil.getSession();     
            session.clear();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {p.*} from products p where p.user_id = :user_id limit :limit offset :offset ")
                        .addEntity("p",Product.class)
                        .setInteger("user_id", userId)
                        .setInteger("limit", limit)
                        .setInteger("offset", offset);        
            products = query.list();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            products = new ArrayList<>();
        }
        return products;
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
        Transaction transaction = null;
        List<Product> products = new ArrayList<>();
        try
        {
            Session session = HibernateUtil.getSession(); 
            session.clear();
            transaction = session.beginTransaction();
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
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            products = new ArrayList<>();
        }        
        return products;
    }
    
    /**
     * This method will return closing product list
     * @param limit, limit
     * @return List product list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Product> getClosingProducts(int limit) {
        Transaction transaction = null;
        List<Product> products = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            TimeUtils timeUtils = new TimeUtils();
            long currentUnixTime = timeUtils.getCurrentTime();
            List<Product> tempProducts = new ArrayList<>();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {p.*} from products p where p.unix_bid_start <= :unix_bid_start and p.unix_bid_end >= :unix_bid_end order by p.unix_bid_end limit :limit")
                    .addEntity("p",Product.class)
                    .setLong("unix_bid_start", currentUnixTime)
                    .setLong("unix_bid_end", currentUnixTime)
                    .setInteger("limit", limit);        
            tempProducts = query.list();
            
            for(Product product: tempProducts)
            {
                long availableTime = product.getUnixBidEnd() - currentUnixTime;
                if( availableTime > 0 )
                {
                    product.setTime(availableTime);
                    products.add(product);
                }
            }
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            products = new ArrayList<>();
//        }
        return products;
    }
    
    /**
     * This method will check whether a product is in saved product list or not of an user
     * @param userId user id
     * @param productId product id
     * @return boolean flast whether a product is in saved product list or not of an user
     * @author nazmul hasan on 18th june 2017
     */
    public boolean isSavedProduct(int userId, int productId)
    {
        boolean response = false;
        Transaction transaction = null;
        try
        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();
            //checking whether product is already saved or not
            Query query = session.createSQLQuery("select {sp.*} from saved_products sp where user_id = :user_id and product_id = :product_id ")
                        .addEntity("sp",SavedProduct.class)
                        .setInteger("user_id", userId)
                        .setInteger("product_id", productId);
            List<SavedProduct> savedProducts =  query.list();
            if(savedProducts != null && !savedProducts.isEmpty())
            {
                response = true;
            }
            else
            {
                response = false;
            }
            if (!transaction.wasCommitted()){
                transaction.commit();
            }  
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }   
            response = false;
        }
        return response;
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
        Transaction transaction = null;
        try
        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();
            //checking whether product is already saved or not
            Query query = session.createSQLQuery("select {sp.*} from saved_products sp where user_id = :user_id and product_id = :product_id ")
                        .addEntity("sp",SavedProduct.class)
                        .setInteger("user_id", userId)
                        .setInteger("product_id", productId);
            List<SavedProduct> savedProducts =  query.list();
            if(savedProducts != null && !savedProducts.isEmpty())
            {
                //product is previously saved
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
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }   
            return false;
        }
    }
    
    /**
     * This method will create a new product
     * @param product product info
     * @return boolean whether product is created or not
     * @author nazmul hasan on 31st May 2017
     */
    public boolean addProduct(Product product) {
        Transaction transaction = null;
        try
        {
            Session session = HibernateUtil.getSession();
            session.clear();
            //setting a reference id
            Image[] images = product.getImages();
            product.setReferenceId(StringUtils.getProductReferenceId());
            TimeUtils timeUtils = new TimeUtils();
            product.setUnixAvailableFrom(timeUtils.getHumanToUnix(product.getAvailableFrom(), ""));
            product.setUnixAvailableTo(timeUtils.getHumanToUnix(product.getAvailableTo(), ""));
            product.setUnixBidStart(timeUtils.getHumanToUnix(product.getBidStartDate(), "") + timeUtils.convertTimeToUnix(product.getBidStartTime()));
            product.setUnixBidEnd(timeUtils.getHumanToUnix(product.getBidEndDate(), "") + timeUtils.convertTimeToUnix(product.getBidEndTime()));
            transaction = session.beginTransaction();
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
            return true;
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            return false;
        }        
    }
    
    /**
     * This method will return product info
     * @param productId product id
     * @return Product product info
     * @author nazmul hasan on 31st May 2017
     */
    public Product getProductInfo(int productId) {
        Transaction transaction = null;
        Product product = null;
//        try
//        {            
            TimeUtils timeUtils = new TimeUtils();
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select {p.*}, {pt.*}, {u.*} from products p join product_types pt on p.product_type_id = pt.id join users u on u.id = p.user_id where p.id = :id ")
                        .addEntity("p",Product.class)
                        .addJoin("pt","p.productType")
                        .addJoin("u","p.user")
                        .setInteger("id", productId);

            List<Object[]> rows = query.list();
            for (Object[] row : rows) 
            {
                product = (Product)row[0];
                break;
            }
            //handle if product is null
            if(product != null)
            {            
                product.setAvailableFrom(timeUtils.convertUnixToHumanDate(product.getUnixAvailableFrom()));
                product.setAvailableTo(timeUtils.convertUnixToHumanDate(product.getUnixAvailableTo()));
                product.setBidStartDate(timeUtils.convertUnixToHumanDate(product.getUnixBidStart()));
                product.setBidStartTime(timeUtils.convertUnixToHumanTime(product.getUnixBidStart()));
                product.setBidEndDate(timeUtils.convertUnixToHumanDate(product.getUnixBidEnd()));
                product.setBidEndTime(timeUtils.convertUnixToHumanTime(product.getUnixBidEnd()));
                
                long currentUnixTime = timeUtils.getCurrentTime();
                long availableTime = product.getUnixBidEnd() - currentUnixTime;
                if( availableTime > 0 )
                {
                    product.setTime(availableTime);
                }
                else
                {
                    product.setTime(0);
                }
                product.setAmenities(new ArrayList<>());
                product.setAvailabilities(new ArrayList<>());
                product.setImages(new Image[0]);
                try
                {
//                    Query productUser = session.createSQLQuery("select {u.*} from users u join products p on u.id = p.user_id where p.id = :product_id ")
//                            .addEntity("u",User.class)
//                            .setInteger("product_id", productId);
//
//                    List<Object[]> userRows = productUser.list();
//                    for (Object user : userRows) 
//                    {
//                        product.setUser((User)user);
//                        break;
//                    }
                    
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
            }
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//        }        
        return product;
    }
    
    /**
     * This method will return summary of product info
     * @param productId product id
     * @return Product product info
     * @author nazmul hasan on 31st May 2017
     */
    public Product getProduct(int productId) {
        Transaction transaction = null;
        Product product = null;
        try
        {            
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select {p.*} from products p where p.id = :id ")
                        .addEntity("p",Product.class)
                        .setInteger("id", productId);

            List<Object> rows = query.list();
            for (Object row : rows) 
            {
                product = (Product)row;
                break;
            }
            
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
        }        
        return product;
    }
    
    /**
     * This method will return user id of a product
     * @param productId product id
     * @return int user id of the product
     * @author nazmul hasan on 11th august 2017
     */
    public int getProductUserId(int productId)
    {
        int userId = 0;
        Transaction transaction = null;
        try
        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();        
            Query query = session.createSQLQuery("select user_id from products where products.id = :id ")
                        .setInteger("id", productId);

            List<Object> rows = query.list();
            for (Object row : rows) 
            {
                userId = (int)row;
                return userId;
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
        }
        return 0;
    }
    
    /**
     * This method will update product info
     * @param product product info
     * @return boolean whether product is updated or not
     * @author nazmul hasan on 17th June 2017
     */
    public boolean updateProduct(Product product) {
        Transaction transaction = null;
        try
        {
            if(product == null || product.getId() == 0)
            {
                return false;
            }
            TimeUtils timeUtils = new TimeUtils();
            product.setUnixAvailableFrom(timeUtils.getHumanToUnix(product.getAvailableFrom(), ""));
            product.setUnixAvailableTo(timeUtils.getHumanToUnix(product.getAvailableTo(), ""));
            product.setUnixBidStart(timeUtils.getHumanToUnix(product.getBidStartDate(), "") + timeUtils.convertTimeToUnix(product.getBidStartTime()));
            product.setUnixBidEnd(timeUtils.getHumanToUnix(product.getBidEndDate(), "") + timeUtils.convertTimeToUnix(product.getBidEndTime()));
            Session session = HibernateUtil.getSession();            
            session.clear();
            transaction = session.beginTransaction();        
            session.update(product);
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
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
            return true;
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            return false;
        }        
    }
    
    /**
     * This method will create a new product
     * @param productBid product bid info
     * @return boolean whether product bid is added or not
     * @author nazmul hasan on 11th June 2017
     */
    public boolean addProductBid(ProductBid productBid) {
        Transaction transaction = null;
        try
        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();
            
            //setting current unix time
            TimeUtils timeUtils = new TimeUtils();
            productBid.setCreatedOn(timeUtils.getCurrentTime());
            
            session.save(productBid);
            if (!transaction.wasCommitted())
            {
                transaction.commit();
            }
            return true;
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            return false;
        }
    }
    
    /**
     * This method will return bid list of a product
     * @param productId product id
     * @return List product bid list
     * @author nazmul hasan on 11th June 2017
     */
    public List<ProductBid> getProductBidList(int productId)
    {
        Transaction transaction = null;
        List<ProductBid> productBidList = new ArrayList<>();
//        try
//        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {pb.*}, {p.*}, {u.*}, {c.*}, {cu.*} from product_bids pb join products p on pb.product_id = p.id join users u on pb.user_id = u.id join currencies c on pb. currency_id = c.id join currency_units cu on pb.currency_unit_id = cu.id where pb.product_id = :product_id order by pb.created_on desc ")
                        .addEntity("pb", ProductBid.class)
                        .addEntity("p", Product.class)
                        .addEntity("u", User.class)
                        .addEntity("c", Currency.class)
                        .addEntity("cu", CurrencyUnit.class)
                        .setInteger("product_id", productId);
            List<Object[]> rows =  query.list();
            TimeUtils timeUtils = new TimeUtils();
            for(Object[] row: rows)
            {
                ProductBid productBid = (ProductBid)row[0];
                productBid.setCreatedTime(timeUtils.convertUnixToHuman(productBid.getCreatedOn()));
                productBidList.add(productBid);
            }
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            productBidList = new ArrayList<>();
//        }
        return productBidList;
    }
    
    
    /**
     * This method will return product list
     * @param searchParams search parameters
     * @param offset offset
     * @param limit limit
     * @return List product list
     * @author nazmul hasan on 11th June 2017
     */
    public List<Product> getProducts(SearchParams searchParams, int offset , int limit) {
        Transaction transaction = null;
        List<Product> productList = new ArrayList<>();
//        try
//        {
            String where = "";
            if(searchParams != null)
            {
                if(!StringUtils.isNullOrEmpty(searchParams.getReferenceId()))
                {
                    if(where.equals(""))
                    {
                        where += " where p.reference_id = '" + searchParams.getReferenceId()+"' ";
                    }
                    else
                    {
                        where += " AND p.reference_id = '" + searchParams.getReferenceId()+"' ";
                    }
                    
                }
                if(searchParams.getProductType() != null && searchParams.getProductType().getId() > 0)
                {
                    if(where.equals(""))
                    {
                        where += " where p.product_type_id = " + searchParams.getProductType().getId() + " ";
                    }
                    else
                    {
                        where += " AND p.product_type_id = " + searchParams.getProductType().getId() +" ";
                    }
                }
                if(searchParams.getLocation()!= null && searchParams.getLocation().getId() > 0)
                {
                    if(where.equals(""))
                    {
                        where += " where p.location_id = " + searchParams.getLocation().getId() + " ";
                    }
                    else
                    {
                        where += " AND p.location_id = " + searchParams.getLocation().getId() +" ";
                    }
                }
                if(searchParams.getProductSize() != null && searchParams.getProductSize().getId() > 0)
                {
                    if(where.equals(""))
                    {
                        where += " where p.product_size_id = " + searchParams.getProductSize().getId() + " ";
                    }
                    else
                    {
                        where += " AND p.product_size_id = " + searchParams.getProductSize().getId() +" ";
                    }
                }
                if(searchParams.getOccupation() != null && searchParams.getOccupation().getId() > 0)
                {
                    if(where.equals(""))
                    {
                        where += " where p.occupation_id = " + searchParams.getOccupation().getId() + " ";
                    }
                    else
                    {
                        where += " AND p.occupation_id = " + searchParams.getOccupation().getId() +" ";
                    }
                }
                if(searchParams.getPet() != null && searchParams.getOccupation().getId() > 0)
                {
                    if(where.equals(""))
                    {
                        where += " where p.pet_id = " + searchParams.getPet().getId() + " ";
                    }
                    else
                    {
                        where += " AND p.pet_id = " + searchParams.getPet().getId() +" ";
                    }
                }
                if(searchParams.getMinPrice() >= 0 )
                {
                    if(where.equals(""))
                    {
                        where += " where p.base_price >= " + searchParams.getMinPrice() + " ";
                    }
                    else
                    {
                        where += " AND p.base_price >= " + searchParams.getMinPrice() +" ";
                    }
                }
                if(searchParams.getMaxPrice() > 0 )
                {
                    if(where.equals(""))
                    {
                        where += " where p.base_price <= " + searchParams.getMaxPrice() + " ";
                    }
                    else
                    {
                        where += " AND p.base_price <= " + searchParams.getMaxPrice() +" ";
                    }
                }
            }
            Session session = HibernateUtil.getSession(); 
            session.clear();
            List<Product> products = new ArrayList<>();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {p.*} from products p " + where + " limit :limit offset :offset ")
                        .addEntity("p",Product.class)
                        .setInteger("limit", limit)
                        .setInteger("offset", offset);        
            products = query.list();
            for(Product product : products)
            {
                TimeUtils timeUtils = new TimeUtils();
                product.setAvailableFrom(timeUtils.covertDBToUserDate(product.getAvailableFrom()));
                product.setAvailableTo(timeUtils.covertDBToUserDate(product.getAvailableTo()));
                product.setBidStartDate(timeUtils.covertDBToUserDate(product.getBidStartDate()));
                product.setBidEndDate(timeUtils.covertDBToUserDate(product.getBidEndDate()));

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
//        }
//        catch(Exception ex)
//        {
//            logger.error(ex.toString());
//            if(transaction != null)
//            {
//                transaction.rollback();
//            }
//            productList = new ArrayList<>();
//        }        
        return productList;
    }
    
//    public void addProductImages(int productId, Image[] images) {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        if (images != null) {
//            for (Image image : images) {
//                image.setProductId(productId);
//                session.save(image);
//            }
//        }
//
//        if (!transaction.wasCommitted()){
//            transaction.commit();
//        }
//    }

//    public Product getProduct(int productId) {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.getNamedQuery("getProductDetail")
//                        .setInteger("productId", productId);
//        Product product = (Product)query.uniqueResult();
//        if (!transaction.wasCommitted()){
//            transaction.commit();
//        }
//        return product;
//    }
}
