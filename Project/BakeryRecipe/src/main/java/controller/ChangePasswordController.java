/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static utils.HashingEncrypter.MD5;
import static utils.HashingEncrypter.getHexaDigest;

/**
 *
 * @author kichi
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/ChangePasswordController"})
public class ChangePasswordController extends HttpServlet {

    private static final String ERROR = "profileChangePass.jsp";
    private static final String SUCCESS = "profile";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmNewPassword = request.getParameter("confirmNewPassword");
            String encryptedOldPassword = getHexaDigest(MD5, oldPassword);
            String encryptedNewPassword = getHexaDigest(MD5, newPassword);
            if (!UserDAO.checkOldPassword(userID, encryptedOldPassword)) {
                request.setAttribute("PASSWORD_ERROR", "Old password wrong!");
            } else if (newPassword.length() < 8 && newPassword.length() > 40) {
                request.setAttribute("PASSWORD_ERROR", "Password must be 8 to 40 characters!");
            } else if (!newPassword.equals(confirmNewPassword)) {
                request.setAttribute("PASSWORD_ERROR", "Confirmation mismatched");
            } else if (UserDAO.changePassword(userID, encryptedNewPassword)) {
                request.setAttribute("PASSWORD_SUCCESS", "Change password successfully");
                url = SUCCESS;
            }
        } catch (Exception e) {
            System.out.println("Error at ChangePasswordController: " + e.toString());
            e.printStackTrace();
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
