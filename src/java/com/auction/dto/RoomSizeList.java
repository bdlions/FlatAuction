package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.util.ArrayList;

/**
 *
 * @author nazmul hasan
 */
public class RoomSizeList extends ClientResponse{
    private ArrayList<Common> roomSizes;
    public RoomSizeList()
    {
        this.roomSizes = new ArrayList<>();
    }   

    public ArrayList<Common> getRoomSizes() {
        return roomSizes;
    }

    public void setRoomSizes(ArrayList<Common> roomSizes) {
        this.roomSizes = roomSizes;
    }
    
}
