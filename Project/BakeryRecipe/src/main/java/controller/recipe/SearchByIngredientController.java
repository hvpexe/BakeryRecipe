/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.recipe;

import dao.RecipeDAO;
import dto.Recipe;
import dto.RecipeSearch;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PhuHV
 */
public class SearchByIngredientController extends HttpServlet {

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
        String[] ingresSearchTemp = request.getParameterValues("ingre");
        List<String> ingresSearch = Arrays.asList(ingresSearchTemp);

        ArrayList<RecipeSearch> listRecipe = RecipeDAO.getRecipes();

        for (RecipeSearch recipe : listRecipe) {
            recipe.setMatch(compare2RecipeIngres(ingresSearch, recipe.getIngre()));
        }
        Collections.sort(listRecipe);
        request.setAttribute("searchByIngre", listRecipe);
        request.getRequestDispatcher("searchByIngredient.jsp").forward(request, response);
    }

    private float compare2RecipeIngres(List<String> ingresSearch, ArrayList<String> ingresRecipe) {
        int total = ingresRecipe.size();
        int match = 0;
        for (String ingre : ingresSearch) {
            if (ingresRecipe.contains(ingre)) {
                match++;
            }
        }
        float result = ((float) match) / total;
        return ((float) match / total);
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
