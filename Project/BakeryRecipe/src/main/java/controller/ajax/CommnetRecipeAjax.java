/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.ajax;

import dao.CommentDAO;
import dao.NotifyDAO;
import dao.RecipeDAO;
import dao.UserDAO;
import dto.Comment;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Tools;

/**
 *
 * @author VO MINH MAN
 */
@WebServlet(name = "CommnetRecipeAjax", urlPatterns = {"/ajax/CommnetRecipeAjax"})
public class CommnetRecipeAjax extends HttpServlet {

    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //        Timestamp date = new Timestamp(System.currentTimeMillis());Date currentDate = new Date (1665559539000)
            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            int bakerID = Integer.parseInt(request.getParameter("bakerID"));
            String comment = request.getParameter("txtCmt");
            int recipeID = Integer.parseInt(request.getParameter("RecipeID"));
            User baker;
            boolean check = false;
            Integer cmtID = CommentDAO.commentRecipe(comment, bakerID, recipeID);
            baker = UserDAO.getUserByID(bakerID);
//           CommentDAO cmtD  = new CommentDAO();
            if (cmtID != null) {
                check = NotifyDAO.AddNotifyComment(bakerID, recipeID, cmtID, bakerID);
                if (check)
                    out.print(" <div class=\"d-flex flex-start mb-4\"   >\n"
                            + "                                        <img class=\"rounded-circle mr-2\"\n"
                            + "                                             src=\"" + baker.getAvatar() + "\" alt=\"avatar\"\n"
                            + "                                             width=\"60\" height=\"60\" />\n"
                            + "                                        <div class=\"card w-100\">\n"
                            + "                                            <div class=\"card-body p-4\">\n"
                            + "                                                <div class=\"\">\n"
                            + "                                                    <h5>" + baker.getName() + "</h5>\n"
                            + "                                                    <p class=\"small\">" + Tools.formatDate(currentDate) + "</p>\n"
                            + "                                                    <p>\n"
                            + "                                                        " + comment + "\n"
                            + "                                                    </p>\n"
                            + "                                                </div>\n"
                            + "                                            </div>\n"
                            + "                                        </div>\n"
                            + "                                    </div>");

            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CommnetRecipeAjax.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CommnetRecipeAjax.class.getName()).log(Level.SEVERE, null, ex);
        }
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
