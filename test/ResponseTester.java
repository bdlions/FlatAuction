
import com.auction.dto.ProductList;
import com.auction.dto.response.ClientResponse;
import com.auction.request.handler.RequestHandler;
import com.google.gson.Gson;
import java.net.InetAddress;
import org.bdlions.packet.IPacket;
import org.bdlions.packet.IPacketHeader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alamgir
 */
public class ResponseTester {
    static RequestHandler rh = new RequestHandler(new MockSessionManager());
    public static void main(String[] args) {
        ClientResponse pl = rh.getProductList(new MockSession(), new IPacket() {
            @Override
            public IPacketHeader getPacketHeader() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getPacketBody() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public InetAddress getRemoteIP() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int getRemotePort() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        System.out.println(new Gson().toJson(pl));
    }
}
