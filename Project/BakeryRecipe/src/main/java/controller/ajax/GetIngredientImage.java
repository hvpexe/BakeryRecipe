/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.ajax;

import dao.IngredientDAO;
import dto.Ingredient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "GetIngredientImage", urlPatterns =
{
    "/ajax/GetIngredientImage"
})
public class GetIngredientImage extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("iname").trim();
            String amount = request.getParameter("iamount").trim();
            Ingredient item = IngredientDAO.getIngredientByName(name);
            String count = request.getParameter("count");

            if (item == null)
            {
                item = new Ingredient( name, null, amount);
            }
            out.println("<div class=\"col p-0  align-items-center p-0 pr-2 border border-secondary\" id=\"item" + count + "\">\n"
                    + "                                <img src=\"" + item.getImg() + "\" alt=' ' > \n"
                    + "                                <input name=\"ingre-name\" readonly class=\"col text-capitalize\"  value=\"" + item.getName() + "\">\n"
                    + "                                <span>Amount:</span> \n"
                    + "                                <input name=\"ingre-amount\" class=\"col-2 bg-white ml-2 mr-4\" placeholder=\"1 \" value=\"" + amount + "\"> \n"
                    + "                                <div class=\"item-trashbin fas fa-trash ml-auto description-button\" onclick=\"this.parentElement.remove()\"></div>\n"
                    + "                            </div>");
        }
    }
//<editor-fold defaultstate="collapsed">

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
            Logger.getLogger(GetIngredientImage.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GetIngredientImage.class.getName()).log(Level.SEVERE, null, ex);
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
