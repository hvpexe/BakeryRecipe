/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.recipe;

import dao.IngredientDAO;
import dao.PictureDAO;
import dao.RecipeDAO;
import dao.UserDAO;
import dto.Comment;
import dto.Ingredient;
import dto.Instruction;
import dto.Picture;
import dto.Recipe;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "EditRecipeController", urlPatterns = {"/editrecipe"})

public class EditRecipeController extends HttpServlet {

    private static final String SUCCESS_GET = "editrecipe.jsp";
    private static final String ERROR_GET = "RecipeDetail";
    private static final String SUCCESS_POST = "RecipeDetail";
    private static final String ERROR_POST = "editrecipe.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditRecipeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditRecipeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    private void loadRecipe (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = SUCCESS_GET;
        try {
            int recipeID = Integer.parseInt(request.getParameter("recipeid"));
            Recipe recipe = RecipeDAO.getRecipeByID(recipeID);
            request.setAttribute("recipe", recipe);

            IngredientDAO dao = new IngredientDAO();

            List<Picture> picRecp;
            picRecp = PictureDAO.getPictureList(recipeID);;
            request.setAttribute("LIST_PIC", picRecp);
            System.out.println(picRecp);
            
            List<Ingredient> listIngre;
            listIngre = dao.listIngredient(recipeID);
            request.setAttribute("LIST_INGREDIENT", listIngre);

            List<Instruction> liststep;
            liststep = RecipeDAO.listStep(recipeID);
            request.setAttribute("LIST_STEP", liststep);
            
            String videoDetail = RecipeDAO.recipeVideo(recipeID);
            request.setAttribute("VIDEO_DETAIL", videoDetail);
//            recipe.commentList(recipeID);
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
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loadRecipe(request, response);
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
