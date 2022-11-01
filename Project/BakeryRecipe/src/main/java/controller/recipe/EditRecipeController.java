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
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import utils.Tools;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditRecipeController", urlPatterns = {"/editrecipe"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 100, // 50MB
        maxFileSize = 1024 * 1024 * 100, // 50MB
        maxRequestSize = 1024 * 1024 * 100) // 50MB
public class EditRecipeController extends HttpServlet {

    private static final String SUCCESS_GET = "editrecipe.jsp";
    private static final String ERROR_GET = "RecipeDetail";
    private static final String SUCCESS_POST = "RecipeDetail";
    private static final String ERROR_POST_MISSING_USER = "login.jsp";
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ServletContext sc = getServletContext();
        String url = ERROR_POST;
        try {

            /* TODO output your page here. You may use following sample code. */
            User user = (User) session.getAttribute("login");
            if (user == null) {
                url = ERROR_POST_MISSING_USER;
                throw new NullPointerException("User not Exist");
            }
            int userId = user.getId();

            int recipeId = Integer.parseInt(request.getParameter("recipe-id"));
            String recipeName = Tools.toUTF8(request.getParameter("recipe-name"));
            String recipeDescription = Tools.toUTF8(request.getParameter("recipe-description"));
            String videoUrl = request.getParameter("video-url");
            List<Part> pictureList = new ArrayList<Part>();//get all video-image
            // get video code if string exist
            if (!Tools.isNullOrEmpty(videoUrl)) {
                int index = videoUrl.indexOf("?v=");
                out.print("<br>" + videoUrl);
                videoUrl = videoUrl.substring(index + 3, index + 14);
                out.print("<br>" + videoUrl);
            }
            String[] ingreName = request.getParameterValues("ingre-name");//get all name
            String[] ingreAmount = request.getParameterValues("ingre-amount");//get all amount
            if (ingreName != null) {
                ingreName = Tools.toUTF8(ingreName);
                ingreAmount = Tools.toUTF8(ingreAmount);
            }
            List<Part> instImgList = new LinkedList<Part>();//get all instuction images
            String[] instDescription = request.getParameterValues("inst-description");//get all instuction descrition
            if (instDescription != null) {
                instDescription = Tools.toUTF8(instDescription);
            }
            int prepareTime = Integer.parseInt(request.getParameter("prepare-time"));
            int cookTime = Integer.parseInt(request.getParameter("cook-time"));
            Collection<Part> parts = request.getParts();
            int vIndex = 0;
            int iIndex = 0;
            int cover = Integer.parseInt(request.getParameter("cover"));//video image cover
            out.print("<br>" + recipeId);
            out.print("<br>" + recipeName);
            out.print("<br>" + recipeDescription);

            for (Part p : parts) {
                if (p.getName().contains("video-image")) {
                    try {
                        out.print("<hr>" + p.getName());
                        out.print(", " + p.getSubmittedFileName().isEmpty());
                        out.print(", " + p.getSubmittedFileName());
                        out.print(", " + p.getContentType());
                        out.print(", " + (vIndex == cover));
                        pictureList.add(p);
                    } catch (Exception e) {

                    }
                    vIndex++;
                }
                if (p.getName().contains("inst-image")) {
                    try {
                        out.print("<hr>" + p.getName());
                        out.print(", " + p.getSubmittedFileName().isEmpty());
                        out.print(", " + p.getSubmittedFileName());
                        out.print(", " + p.getContentType());
                        out.print(", " + instDescription[iIndex]);
                        instImgList.add(p);
                    } catch (Exception e) {

                    }
                    iIndex++;
                }
            }
            out.print("<hr>" + pictureList);
            out.print("<hr>" + instImgList);
            out.print("<br>" + prepareTime);
            out.print("<br>" + cookTime);
            boolean recipeUpdated
                    = RecipeDAO.updateRecipe(recipeName, recipeDescription, videoUrl, pictureList, ingreName,
                            ingreAmount, instImgList, instDescription, prepareTime, cookTime, userId, recipeId, cover, sc);
            if (recipeUpdated) {
                url = SUCCESS_POST;
                session.setAttribute("EDIT_RECIPE_SUCCESS", "Recipe Edited!");
            } else {
                session.setAttribute("EDIT_RECIPE_FAILED", "Recipe Edit failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            request.getRequestDispatcher(url).forward(request, response);
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
