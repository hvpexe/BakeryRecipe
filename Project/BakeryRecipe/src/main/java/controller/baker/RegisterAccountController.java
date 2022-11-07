/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.baker;

import dao.UserDAO;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import utils.Tools;

/**
 *
 * @author PhuHV
 */
@WebServlet(name = "RegisterAccountController", urlPatterns = {"/register"})
public class RegisterAccountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String role = "user";
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        firstname = Tools.toUTF8(firstname);
        lastname = Tools.toUTF8(lastname);
        String password = (String) request.getParameter("password");
        String hashedpassword = (String) request.getAttribute("password");
        String rePassword = request.getParameter("re-password");
        Date dateRegister = new Date(System.currentTimeMillis());
        
        if (UserDAO.checkDuplicateEmail(email)) {
            request.setAttribute("REGISTER_ERROR", "Email alreadly exist!");
        } else if (password.length() < 8) {
            request.setAttribute("REGISTER_ERROR", "Password must be at least 8 characters!");
        } else if (!rePassword.equals(password)) {
            request.setAttribute("REGISTER_ERROR", "Password mismatched");
        } else {
            UserDAO.register(email, hashedpassword, firstname, lastname);
            User user = UserDAO.login(email, hashedpassword);
            HttpSession session = request.getSession();
            session.setAttribute("LOGIN_USER", user);
            response.sendRedirect("home.jsp");
            return;
        }
        if(request.getAttribute("REGISTER_ERROR")!=null){
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
