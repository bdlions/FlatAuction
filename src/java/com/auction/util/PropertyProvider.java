/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author alamgir
 */
class PropertyProvider {
    private final Properties properties;
    public PropertyProvider(String fileName) throws IOException {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
	properties.load(inputStream);
    }
    
    protected String get(String key){
        return properties.getProperty(key);
    }
}



