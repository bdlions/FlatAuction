package com.auction.dto;

import com.auction.dto.response.ClientResponse;
import java.util.ArrayList;

/**
 *
 * @author nazmul hasan
 */
public class RoomSizeList extends ClientResponse{
    private ArrayList<RoomSize> roomSizes;
    public RoomSizeList()
    {
        this.roomSizes = new ArrayList<>();
    }   

    public ArrayList<RoomSize> getRoomSizes() {
        return roomSizes;
    }

    public void setRoomSizes(ArrayList<RoomSize> roomSizes) {
        this.roomSizes = roomSizes;
    }
    
}
