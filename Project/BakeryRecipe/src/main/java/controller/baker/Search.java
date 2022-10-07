/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.baker;

import dao.RecipeDAO;
import dao.UserDAO;
import dto.Recipe;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VO MINH MAN
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})

public class Search extends HttpServlet {

    private static final String ERROR = "search.jsp";
    private static final String SEARCH_NAME = "Baker";
    private static final String SUCCESS = "search.jsp";
    private static final String SEARCH_RECIPE = "Recipe";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            String searchK = request.getParameter("searchKey");
            if (SEARCH_RECIPE.equals(action)) {
                RecipeDAO recipe = new RecipeDAO();
                List<Recipe> listRecipe = recipe.searchRecipe(searchK);
                System.out.println(listRecipe);
                if (!listRecipe.isEmpty()) {
                    request.setAttribute("LIST_RECIPE", listRecipe);
                    url = SUCCESS;
                }

            } else if (SEARCH_NAME.equals(action)) {
                UserDAO user = new UserDAO();
                List<User> listUser = user.searchName(searchK);
                if (!listUser.isEmpty()) {
                    request.setAttribute("LIST_BAKER", listUser);
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {

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
