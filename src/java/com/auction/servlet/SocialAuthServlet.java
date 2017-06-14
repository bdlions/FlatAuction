/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.servlet;

import com.auction.util.FacebookConfig;
import com.auction.util.StringUtils;
import com.auction.util.URIBuilder;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.FacebookClient.DebugTokenInfo;

/**
 *
 * @author alamgir
 */
@WebServlet(name = "SocialAuthServlet", urlPatterns = {"/SocialAuthServlet"})
public class SocialAuthServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String REQUEST_TYPE = request.getParameter("request");

            if (REQUEST_TYPE != null) {
                URIBuilder uriBuilder = new URIBuilder(FacebookConfig.getInstance().get(FacebookConfig.AUTH_URL));
                uriBuilder.addParameter("client_id", FacebookConfig.getInstance().get(FacebookConfig.APP_ID));
                uriBuilder.addParameter("redirect_uri", FacebookConfig.getInstance().get(FacebookConfig.CALLBACK_URL));
                uriBuilder.addParameter("scope", FacebookConfig.getInstance().get(FacebookConfig.SCOPE));
                String url = uriBuilder.toString();

                if (REQUEST_TYPE.equals("SIGN_IN")) {
                    //do something for sign in
                } else if (REQUEST_TYPE.equals("REGISTER")) {
                    //do something for register
                }
                response.sendRedirect(url);
            } else {
                String code = request.getParameter("code");

                AccessToken accessToken;

                if (StringUtils.isNullOrEmpty(code)) {
                    //wrong code invalid attempt
                } else {

                    String clientId = FacebookConfig.getInstance().get(FacebookConfig.APP_ID);
                    String redirectURI = FacebookConfig.getInstance().get(FacebookConfig.CALLBACK_URL);
                    String clientSecret = FacebookConfig.getInstance().get(FacebookConfig.APP_SECRET);

                    FacebookClient facebookClient = new DefaultFacebookClient(Version.VERSION_2_3);
                    accessToken = facebookClient.obtainUserAccessToken(clientId, clientSecret, redirectURI, code);

                    if (accessToken != null) {
                        if (StringUtils.isNullOrEmpty(accessToken.getAccessToken())) {
                            //unauthorized access
                        } else {
                            //if(access_token exists in db){
                                //retreive users matched with access token and login
                            //}
                            //else{
                                facebookClient = new DefaultFacebookClient(accessToken.getAccessToken(), clientSecret, Version.VERSION_2_3);
                                DebugTokenInfo debugToken = facebookClient.debugToken(accessToken.getAccessToken());
                                //if(debugToken.isValid()){
                                    //if(debugToken.getUserId() exists in db){
                                        //retreive users matched with access token and login
                                    //}
                                    //else{
                                        //first time in this site
                                        //insert access token and user id
                                    //}
                                    accessToken = facebookClient.obtainExtendedAccessToken(clientId, clientSecret);
                                    facebookClient = new DefaultFacebookClient(accessToken.getAccessToken(), Version.VERSION_2_3);
                                    User user = facebookClient.fetchObject("me", User.class);
                                    out.println("Name: " + user.getName());
                                    out.println("</br>");
                                    out.println("Email: " + user.getEmail());
                                    out.println("</br>");
                                    out.println("Date of birth: " + user.getBirthday());
                                    out.println("</br>");
                                    out.println("Gender: " + user.getGender());
                                    out.println("</br>");
                                    com.restfb.json.JsonObject js = facebookClient.fetchObject("/me/picture", com.restfb.json.JsonObject.class,
                                            Parameter.with("type", "large"), // the image size
                                            Parameter.with("redirect", "false")); // don't redirect
                                    out.println("profile picture: " + ((com.restfb.json.JsonObject) js.get("data")).get("url"));
                                //}
                                //else{
                                    //invalid accss token
                                //}
                            //}
                        }
                    }
                    else{
                        // invalid access token
                    }
                }
            }

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
