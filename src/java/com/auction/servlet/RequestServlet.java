package com.auction.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.bdlions.packet.IPacket;
import org.bdlions.packet.IPacketHeader;
import com.auction.packet.PacketHeaderImpl;
import com.auction.dto.response.ClientFailedResponse;
import com.auction.commons.ClientMessages;
import com.auction.util.ClientRequestHandler;
import com.auction.dto.response.ClientResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bdlions.packet.RequestPacketImpl;

/**
 *
 * @author alamgir
 */
@WebServlet(urlPatterns = {"/RequestServlet"})
public class RequestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        //response.addHeader("Access-Control-Allow-Origin", "*");
        Gson gson = new GsonBuilder().create();

        PrintWriter out = response.getWriter();
        try {
            request.setCharacterEncoding("UTF-8");
     
            JsonParser parser = new JsonParser();
            //JsonObject jsonObject = (JsonObject)parser.parse(request.getReader());
            JsonElement packetHeaderText = parser.parse(request.getParameter("packetHeader"));
            String packetBody = request.getParameter("packetBody");
            if(packetHeaderText == null){
                ClientResponse cr = new ClientFailedResponse();
                cr.setMessage(ClientMessages.PACKET_HEADER_MISSING);
                out.println(gson.toJson(cr));
                return;
            }
            
            /* TODO output your page here. You may use following sample code. */
            IPacketHeader packetHeader = gson.fromJson(packetHeaderText, PacketHeaderImpl.class);

            IPacket packet = new RequestPacketImpl(packetHeader, packetBody, request.getRemoteAddr(), request.getRemotePort());
            ClientResponse clientResponse = (ClientResponse)ClientRequestHandler.getInstance().executeRequest(packet);
            
            if (clientResponse != null) {
                out.println(gson.toJson(clientResponse));
            } else {
                ClientResponse cr = new ClientFailedResponse();
                cr.setMessage(ClientMessages.REQUEST_DID_NOT_PROCESSED_SUCCESSFULLY);
                out.println(gson.toJson(cr));
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
            ClientResponse cr = new ClientFailedResponse() ;
            cr.setMessage(ClientMessages.REQUEST_DID_NOT_PROCESSED_SUCCESSFULLY);
            out.println(gson.toJson(cr));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
