package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.util.ArrayList;

/**
 *
 * @author nazmul hasan
 */
public class RadiusList extends ClientResponse{
    private ArrayList<Common> radiuses;
    public RadiusList()
    {
        this.radiuses = new ArrayList<>();
    }

    public ArrayList<Common> getRadiuses() {
        return radiuses;
    }

    public void setRadiuses(ArrayList<Common> radiuses) {
        this.radiuses = radiuses;
    }
    
}
