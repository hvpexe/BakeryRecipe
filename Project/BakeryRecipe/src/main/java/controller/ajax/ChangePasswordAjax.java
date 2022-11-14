/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.ajax;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.HashingEncrypter.MD5;
import static utils.HashingEncrypter.getHexaDigest;

/**
 *
 * @author VO MINH MAN
 */
@WebServlet(name = "CommnetRecipeAjax", urlPatterns = {"/ChangePasswordAjax"})
public class ChangePasswordAjax extends HttpServlet {

    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String userID = request.getParameter("userID");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            System.out.println(newPassword);
            String confirmNewPassword = request.getParameter("confirmNewPassword");
            String encryptedOldPassword = getHexaDigest(MD5, oldPassword);
            String encryptedNewPassword = getHexaDigest(MD5, newPassword);
            if (!UserDAO.checkOldPassword(userID, encryptedOldPassword) && oldPassword != null) {
//                out.print("Old password wrong!");
                out.print("<div id=\"pass-error\">Old password wrong!</div>");
            } else if (newPassword.length() < 8 && newPassword.length() > 40) {
                out.print("<div id=\"pass-error\">Password must be 8 to 40 characters!</div>");
            } else if (!newPassword.equals(confirmNewPassword)) {
                out.print("<div id=\"pass-error\">Confirmation mismatched!</div>");
            } else if (UserDAO.changePassword(userID, encryptedNewPassword)) {
                out.print("Change password successfully");
                HttpSession session = request.getSession();
                session.setAttribute("login", UserDAO.getUserByID(Integer.parseInt(userID)));
            }
        } catch (Exception e) {
            System.out.println("Error at ChangePasswordController: " + e.toString());
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo () {
        return "Short description";
    }// </editor-fold>

}
