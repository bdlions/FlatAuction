package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.util.ArrayList;

/**
 *
 * @author nazmul hasan
 */
public class ProductTypeList extends ClientResponse{
    private ArrayList<Common> productTypes;
    public ProductTypeList()
    {
        this.productTypes = new ArrayList<>();
    }

    public ArrayList<Common> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(ArrayList<Common> productTypes) {
        this.productTypes = productTypes;
    }
    
}
