/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.recipe;

import dao.IngredientDAO;
import dao.RecipeDAO;
import dto.Recipe;
import dto.RecipeSearch;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    HashMap<String, Integer> listIngre;

    public SearchByIngredientController() throws SQLException {
        this.listIngre = IngredientDAO.getAllIngredientsWithPoint();
    }

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
        response.setContentType("text/html;charset=UTF-8");
        String[] ingresSearchTemp = request.getParameterValues("ingre");
        if (ingresSearchTemp == null) {
            request.setAttribute("ERROR_MESSAGE", "Please enter some ingredients");
            request.getRequestDispatcher("searchByIngredient.jsp").forward(request, response);
        }
        List<String> ingresSearch = Arrays.asList(ingresSearchTemp);

        ArrayList<RecipeSearch> listRecipe = RecipeDAO.getRecipes();

        for (RecipeSearch recipe : listRecipe) {
            recipe.setMatch(compare2RecipeIngres(ingresSearch, recipe.getIngre()));
            recipe.setIngreFound(findIngrefound(ingresSearch, recipe.getIngre()));
        }
        Collections.sort(listRecipe);
        request.setAttribute("searchByIngre", listRecipe);
        request.getRequestDispatcher("searchByIngredient.jsp").forward(request, response);
    }

    private int calculateTotalPointOfIngres(HashMap<String, Integer> ingresRecipe) {
        int total = 0;
        for (String ingre : ingresRecipe.keySet()) {
            if (listIngre.containsKey(ingre)) {
                total += listIngre.get(ingre);
            }
        }
        return total;
    }

    private float compare2RecipeIngres(List<String> ingresSearch, HashMap<String, Integer> ingresRecipe) {
        int total = calculateTotalPointOfIngres(ingresRecipe);
        if (total == 0) {
            return 0;
        }
        int match = 0;
        for (String ingre : ingresSearch) {
            if (ingresRecipe.containsKey(ingre)) {
                match += ingresRecipe.get(ingre);
            }
        }
        float result = ((float) match) / total;
        return result;
    }

    private HashMap<String, Boolean> findIngrefound(List<String> ingresSearch, HashMap<String, Integer> ingresRecipe) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String name : ingresRecipe.keySet()) {
            map.put(name, ingresSearch.contains(name));
        }
        return map;
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
            Logger.getLogger(SearchByIngredientController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchByIngredientController.class.getName()).log(Level.SEVERE, null, ex);
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
