/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.servlet;

import com.auction.util.FacebookUtil;
import com.auction.util.StringUtils;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            String code = request.getParameter("code");
            String access_token;
            
            if(StringUtils.isNullOrEmpty(code)){
                //wrong code invalid attempt
            }
            else{
                access_token = FacebookUtil.getAccessToken(code);
                if(StringUtils.isNullOrEmpty(access_token)){
                    //unauthorized access
                }
                else{
                    //access_token exists in database
                    //if(access_token exists in db){
                        //retreive users matched with access token and login
                    //}
                    //else{
                        FacebookClient facebookClient = new DefaultFacebookClient("EAAJN8HlAVdEBANAPD7u3QN6YKumESMAn6ONP8L2fikMf6w38ooQBtXlj09Xkn1k9tVEdh6ymVfo6VrlxzliysMa7DP9mLZCmr6NJeTcaBS0dg8wLJmMMpyHxQZAoWV0XnemvslLCNrZB9cvkf0rMzZApQ35Fi1oZD", Version.VERSION_2_3);
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
                        out.println("profile picture: " + ((com.restfb.json.JsonObject)js.get("data")).get("url"));
                    //}
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
