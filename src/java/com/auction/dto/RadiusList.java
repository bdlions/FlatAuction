package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.util.ArrayList;

/**
 *
 * @author nazmul hasan
 */
public class RadiusList extends ClientResponse{
    private ArrayList<Radius> radiuses;
    public RadiusList()
    {
        this.radiuses = new ArrayList<>();
    }

    public ArrayList<Radius> getRadiuses() {
        return radiuses;
    }

    public void setRadiuses(ArrayList<Radius> radiuses) {
        this.radiuses = radiuses;
    }
    
}
