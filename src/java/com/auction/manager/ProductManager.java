/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.auction.dto.Currency;
import com.auction.dto.CurrencyUnit;
import com.auction.dto.Image;
import com.auction.dto.Location;
import com.auction.dto.Message;
import com.auction.dto.MessageText;
import com.auction.dto.Occupation;
import com.auction.dto.Pet;
import com.auction.dto.Product;
import com.auction.dto.ProductBid;
import com.auction.dto.ProductCategory;
import com.auction.dto.ProductSize;
import com.auction.dto.ProductType;
import com.auction.dto.SavedProduct;
import com.auction.dto.Smoking;
import com.auction.dto.Stay;
import com.auction.dto.User;
import com.auction.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
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
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<ProductType> productTypes = new ArrayList<>();
        Query query = session.getNamedQuery("getProductTypes");
        productTypes = query.list();
        session.getTransaction().commit();
        return productTypes;
    }
    
    /**
     * This method will return all product sizes
     * @return List product size list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductSize> getProductSizes() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<ProductSize> productSizes = new ArrayList<>();
        Query query = session.getNamedQuery("getProductSizes");
        productSizes = query.list();
        session.getTransaction().commit();
        return productSizes;
    }
    
    /**
     * This method will return all product categories
     * @return List product category list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductCategory> getProductCategories() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<ProductCategory> productCategories = new ArrayList<>();
        Query query = session.getNamedQuery("getProductCategories");
        productCategories = query.list();
        session.getTransaction().commit();
        return productCategories;
    }
    
    /**
     * This method will return all locations
     * @return List location list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Location> getLocations() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Location> locations = new ArrayList<>();
        Query query = session.getNamedQuery("getLocations");
        locations = query.list();
        session.getTransaction().commit();
        return locations;
    }
    
    /**
     * This method will return stay list
     * @return List stay list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Stay> getStays() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Stay> stays = new ArrayList<>();
        Query query = session.getNamedQuery("getStays");
        stays = query.list();
        session.getTransaction().commit();
        return stays;
    }
    
    /**
     * This method will return smoking list
     * @return List smoking list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Smoking> getSmokings() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Smoking> smokings = new ArrayList<>();
        Query query = session.getNamedQuery("getSmokings");
        smokings = query.list();
        session.getTransaction().commit();
        return smokings;
    }
    
    /**
     * This method will return occupation list
     * @return List occupation list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Occupation> getOccupations() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Occupation> occupations = new ArrayList<>();
        Query query = session.getNamedQuery("getOccupations");
        occupations = query.list();
        session.getTransaction().commit();
        return occupations;
    }
    
    /**
     * This method will return pet list
     * @return List pet list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Pet> getPets() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Pet> pets = new ArrayList<>();
        Query query = session.getNamedQuery("getPets");
        pets = query.list();
        session.getTransaction().commit();
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
        session.beginTransaction();
        Query query = session.createSQLQuery("select {p.*} from products p where p.user_id = :user_id limit :limit offset :offset ")
                    .addEntity("p",Product.class)
                    .setInteger("user_id", userId)
                    .setInteger("limit", limit)
                    .setInteger("offset", offset);        
        products = query.list();
        session.getTransaction().commit();
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
        session.beginTransaction();
        Query query = session.createSQLQuery("select {sp.*} from saved_products sp where user_id = :user_id and product_id = :product_id ")
                    .addEntity("sp",SavedProduct.class)
                    .setInteger("user_id", userId)
                    .setInteger("product_id", productId);
        List<SavedProduct> savedProducts =  query.list();
        if(savedProducts != null && !savedProducts.isEmpty())
        {
            return false;
        }
        session.getTransaction().commit();
        session.beginTransaction();
        User user = new User();
        user.setId(userId);
        Product product = new Product();
        product.setId(productId);
        SavedProduct savedProduct = new SavedProduct();
        savedProduct.setUser(user);
        savedProduct.setProduct(product);
        session.save(savedProduct);
        session.getTransaction().commit();
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
        session.beginTransaction();
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
        session.getTransaction().commit();
        return products;
    }
    
    public List<Product> getProducts(int offset , int limit) {
        Session session = HibernateUtil.getSession();
        List<Product> productList = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        session.beginTransaction();
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
        session.getTransaction().commit();
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
        session.beginTransaction();
        session.save(product);
        if (images != null) {
            for (Image image : images) {
                image.setProductId(product.getId());
                session.save(image);
            }
        }
        session.getTransaction().commit();
    }
    
    /**
     * This method will create a new product
     * @param productBid product bid info
     * @author nazmul hasan on 11th June 2017
     */
    public void addProductBid(ProductBid productBid) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(productBid);
        session.getTransaction().commit();
    }
    
    /**
     * This method will update product info
     * @param product product info
     * @author nazmul hasan on 17th June 2017
     */
    public void updateProduct(Product product) {
        Session session = HibernateUtil.getSession();
        session.clear();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
    }
    
    public List<ProductBid> getProductBidList(int productId)
    {
    List<ProductBid> productBidList = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
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
        session.getTransaction().commit();
        return productBidList;
    }
    
    public Product getProductInfo(int productId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("select {p.*} from products p where id = :id ")
                    .addEntity("p",Product.class)
                    .setInteger("id", productId);
        List<Product> products =  query.list();
        if(products != null && products.size() == 1)
        {
            return products.get(0);
        }
        session.getTransaction().commit();
        return null;
    }
    

    public void addProductImages(int productId, Image[] images) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        if (images != null) {
            for (Image image : images) {
                image.setProductId(productId);
                session.save(image);
            }
        }

        session.getTransaction().commit();
    }

    public Product getProduct(int productId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("getProductDetail")
                        .setInteger("productId", productId);
        Product product = (Product)query.uniqueResult();
        session.getTransaction().commit();
        return product;
    }
}
