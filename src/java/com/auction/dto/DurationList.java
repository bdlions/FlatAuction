package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.util.ArrayList;

/**
 *
 * @author nazmul hasan
 */
public class DurationList extends ClientResponse{
    private ArrayList<Common> durations;
    public DurationList()
    {
        this.durations = new ArrayList<>();
    }

    public ArrayList<Common> getDurations() {
        return durations;
    }

    public void setDurations(ArrayList<Common> durations) {
        this.durations = durations;
    }
    
}
