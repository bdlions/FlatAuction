package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.util.ArrayList;

/**
 *
 * @author nazmul hasan
 */
public class GenderList extends ClientResponse{
    private ArrayList<Common> genders;
    public GenderList()
    {
        this.genders = new ArrayList<>();
    }

    public ArrayList<Common> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<Common> genders) {
        this.genders = genders;
    }
    
}
