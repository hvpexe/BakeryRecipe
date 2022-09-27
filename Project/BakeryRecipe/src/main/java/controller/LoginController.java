/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import stackjava.com.accessgoogle.common.GooglePojo;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String AD = "admin";
    private static final String AD_PAGE = "home.jsp";
    private static final String US = "baker";
    private static final String USER_PAGE = "home.jsp";

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
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            GooglePojo googlePojo = (GooglePojo) session.getAttribute("google");
            System.out.println(googlePojo + " dsa");
            if (googlePojo != null) {
                email = googlePojo.getEmail();
                password = "";
                if (!UserDAO.checkDuplicateEmail(email)) {
                    String firstname = email.split("@")[0];
                    String lastname = "";
                    String avatar = googlePojo.getPicture();
                    UserDAO.register(email, password, firstname, lastname, avatar);
                }
                session.removeAttribute("LOGIN_ERROR");
                session.removeAttribute("google");
            } else {
                if (password.length() < 8) {
                    request.setAttribute("LOGIN_ERROR", "Password must be at least 8 characters!");
                }
            }
            User loginUser = UserDAO.login(email, password);
            if (loginUser != null) {
                session.setAttribute("LOGIN_USER", loginUser);
                String roleID = loginUser.getRole();
                Boolean isActive = loginUser.isIsActive();
                if (isActive == false) {
                    request.setAttribute("LOGIN_ERROR", "You have been banned");
                } else {
                    if (AD.equals(roleID)) {
                        url = AD_PAGE;
                    } else if (US.equals(roleID)) {
                        url = USER_PAGE;
                    }
                }
            }
        } catch (Exception e) {
            log("Error at LoginController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
