/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.recipe;

import dao.IngredientDAO;
import dao.RecipeDAO;
import dao.UserDAO;
import dto.Comment;
import dto.Ingredient;
import dto.Instruction;
import dto.Recipe;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VO MINH MAN
 */
@WebServlet(name = "RecipeDetailController", urlPatterns = {"/RecipeDetail"})
public class RecipeDetailController extends HttpServlet {

    private static final String SUCCESS = "recipeDetail.jsp";
    private static final String ERROR = "recipeDetail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
//            int loginID = Integer.parseInt(request.getParameter("loginID"));
            HttpSession session = request.getSession();
            User userLogin = (User) session.getAttribute("login");
//           Recipe ID = (Recipe) session.getAttribute("RECIPE_DETAIL");
            int recipeID = Integer.parseInt(request.getParameter("recipeID"));
            RecipeDAO recipe = new RecipeDAO();
User sc ;
            sc =   UserDAO.userDetail(recipeID);
            int ID = sc.getId();
            List<String> picRecp;
            picRecp = recipe.listPicture(recipeID);
            request.setAttribute("LIST_PIC", picRecp);

            User user;
            user = UserDAO.userDetail(recipeID);
            request.setAttribute("USER_DETAIL", user);

            IngredientDAO dao = new IngredientDAO();

            List<Ingredient> listIngre;
            listIngre = dao.listIngredient(recipeID);
            request.setAttribute("LIST_INGREDIENT", listIngre);

            List<Instruction> liststep;
            liststep = recipe.listStep(recipeID);
            request.setAttribute("LIST_STEP", liststep);

            Recipe recipedl;
            recipedl = recipe.recipeDetail(recipeID);
            request.setAttribute("RECIPE_DETAIL", recipedl);

            String videoDetail = recipe.recipeVideo(recipeID);
            request.setAttribute("VIDEO_DETAIL", videoDetail);

            List<Recipe> relateRecipe = recipe.listRelate(recipeID);
            request.setAttribute("RELATED_TOPIC", relateRecipe);

//            recipe.commentList(recipeID);
            List<Comment> cmt = recipe.commentList(recipeID);
            request.setAttribute("COMMENT_LIST", cmt);

           
            
//          check save
//            boolean checksave = UserDAO.checkSaveRecipe(userLogin.getId(), recipeID);
//            request.setAttribute("checksave", checksave);
            
            boolean checklike = UserDAO.checkLikeRecipe(userLogin.getId(), recipeID);
            request.setAttribute("checklike", checklike);
            
            boolean checkfollow = UserDAO.checkFollowUser(userLogin.getId(), ID);
            request.setAttribute("CHECK_FOLLOW", checkfollow);
            
            
           
            
            
           
            url = SUCCESS;

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
