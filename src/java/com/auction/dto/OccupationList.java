package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.util.ArrayList;

/**
 *
 * @author nazmul hasan
 */
public class OccupationList extends ClientResponse{
    private ArrayList<Common> occupations;
    public OccupationList()
    {
        this.occupations = new ArrayList<>();
    }

    public ArrayList<Common> getOccupations() {
        return occupations;
    }

    public void setOccupations(ArrayList<Common> occupations) {
        this.occupations = occupations;
    }
    
}
