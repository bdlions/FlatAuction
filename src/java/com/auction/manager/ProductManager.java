/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.auction.dto.Image;
import com.auction.dto.Product;
import com.auction.dto.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author alamgir
 */
public class ProductManager {

    private final Logger logger = LoggerFactory.getLogger(UserManager.class);

    public void addProduct(Product product) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(product);

        session.getTransaction().commit();
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
        Session session = HibernateUtil.getSession();

        Query query = session.getNamedQuery("getProducts")
                        .setInteger("limit", limit)
                        .setInteger("offset", offset)
                        .setResultTransformer(Transformers.aliasToBean(Product.class));
        
        List<Product> products = query.list();
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
