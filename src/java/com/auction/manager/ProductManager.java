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
import com.auction.dto.Occupation;
import com.auction.dto.Pet;
import com.auction.dto.Product;
import com.auction.dto.ProductBid;
import com.auction.dto.ProductCategory;
import com.auction.dto.ProductSize;
import com.auction.dto.ProductType;
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
    Session session = HibernateUtil.getSession();
    /**
     * This method will return all product types
     * @return List product type list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductType> getProductTypes() {
        //Session session = HibernateUtil.getSession();
        List<ProductType> productTypes = new ArrayList<>();
        Query query = session.getNamedQuery("getProductTypes");
        productTypes = query.list();
        return productTypes;
    }
    
    /**
     * This method will return all product sizes
     * @return List product size list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductSize> getProductSizes() {
        //ession session = HibernateUtil.getSession();
        List<ProductSize> productSizes = new ArrayList<>();
        Query query = session.getNamedQuery("getProductSizes");
        productSizes = query.list();
        return productSizes;
    }
    
    /**
     * This method will return all product categories
     * @return List product category list
     * @author nazmul hasan on 31st May 2017
     */
    public List<ProductCategory> getProductCategories() {
        //Session session = HibernateUtil.getSession();
        List<ProductCategory> productCategories = new ArrayList<>();
        Query query = session.getNamedQuery("getProductCategories");
        productCategories = query.list();
        return productCategories;
    }
    
    /**
     * This method will return all locations
     * @return List location list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Location> getLocations() {
        //Session session = HibernateUtil.getSession();
        List<Location> locations = new ArrayList<>();
        Query query = session.getNamedQuery("getLocations");
        locations = query.list();
        return locations;
    }
    
    /**
     * This method will return stay list
     * @return List stay list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Stay> getStays() {
        //Session session = HibernateUtil.getSession();
        List<Stay> stays = new ArrayList<>();
        Query query = session.getNamedQuery("getStays");
        stays = query.list();
        return stays;
    }
    
    /**
     * This method will return smoking list
     * @return List smoking list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Smoking> getSmokings() {
        //Session session = HibernateUtil.getSession();
        List<Smoking> smokings = new ArrayList<>();
        Query query = session.getNamedQuery("getSmokings");
        smokings = query.list();
        return smokings;
    }
    
    /**
     * This method will return occupation list
     * @return List occupation list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Occupation> getOccupations() {
        //Session session = HibernateUtil.getSession();
        List<Occupation> occupations = new ArrayList<>();
        Query query = session.getNamedQuery("getOccupations");
        occupations = query.list();
        return occupations;
    }
    
    /**
     * This method will return pet list
     * @return List pet list
     * @author nazmul hasan on 31st May 2017
     */
    public List<Pet> getPets() {
        //Session session = HibernateUtil.getSession();
        List<Pet> pets = new ArrayList<>();
        Query query = session.getNamedQuery("getPets");
        pets = query.list();
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
        List<Product> products = new ArrayList<>();
        
        Query query = session.createSQLQuery("select {p.*} from products p where p.user_id = :user_id limit :limit offset :offset ")
                    .addEntity("p",Product.class)
                    .setInteger("user_id", userId)
                    .setInteger("limit", limit)
                    .setInteger("offset", offset);        
        products = query.list();
        return products;
    }
    
    /**
     * This method will create a new product
     * @param product product info
     * @author nazmul hasan on 31st May 2017
     */
    public void addProduct(Product product) {
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
        session.beginTransaction();
        session.save(productBid);
        session.getTransaction().commit();
    }
    
    public List<ProductBid> getProductBidList(int productId)
    {
    List<ProductBid> productBidList = new ArrayList<>();
        Session session = HibernateUtil.getSession();
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
        return productBidList;
    }
    
    public Product getProductInfo(int productId) {
        Session session = HibernateUtil.getSession();
        Query query = session.createSQLQuery("select {p.*} from products p where id = :id ")
                    .addEntity("p",Product.class)
                    .setInteger("id", productId);
        List<Product> products =  query.list();
        if(products != null && products.size() == 1)
        {
            return products.get(0);
        }
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

    public List<Product> getProducts(int offset , int limit) {
        /*Session session = HibernateUtil.getSession();

        Query query = session.getNamedQuery("getProducts")
                        .setInteger("limit", limit)
                        .setInteger("offset", offset)
                        .setResultTransformer(Transformers.aliasToBean(Product.class));
        
        List<Product> products = query.list();
        return products;*/
        List<Product> products = new ArrayList<>();
        
        Query query = session.createSQLQuery("select {p.*} from products p limit :limit offset :offset ")
                    .addEntity("p",Product.class)
                    .setInteger("limit", limit)
                    .setInteger("offset", offset);        
        products = query.list();
        return products;
    }
    public Product getProduct(int productId) {
        Session session = HibernateUtil.getSession();
        Query query = session.getNamedQuery("getProductDetail")
                        .setInteger("productId", productId);
        Product product = (Product)query.uniqueResult();
        return product;
    }
}
