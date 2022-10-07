/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
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
 * @author kichi
 */
@WebServlet(name = "EditInformationController", urlPatterns = {"/ProfileInfo"})
public class EditInformationController extends HttpServlet {
    private static final String ERROR = "profileInfo.jsp";
    private static final String SUCCESS = "profile.jsp";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            User user = null;
            User userLogin = (User) session.getAttribute("login");
            
            String ID = request.getParameter("userID"); 
            int userID = Integer.parseInt(ID);
            user = UserDAO.getUserByID(userID);
            String firstname = Tools.toUTF8(request.getParameter("firstname"));
            String lastname = Tools.toUTF8(request.getParameter("lastname"));
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
 //           Part part = request.getPart("avatar");
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setBirthday(birthday);
            user.setGender(gender);
            user.setPhone(phone);
            user.setAddress(address);
 //           String avatar = null;
           /*if (!part.getSubmittedFileName().isEmpty()) {
                int id = user.getId();
                String userid = Integer.toString(id);
                avatar = UserDAO.saveAvatar(userid, part, getServletContext());
            }
            if (avatar != null) {
                user.setAvatar(avatar);
            }
            System.out.println("avatar:"+avatar);*/
            if (UserDAO.EditInfo(user)) {
                session.setAttribute("login", user);
                url = SUCCESS;
            }
            
        } catch (Exception e) {
            System.out.println("Error at EditInformationController: " + e.toString());
        } finally{
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
