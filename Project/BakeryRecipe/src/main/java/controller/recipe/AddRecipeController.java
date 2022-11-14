/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.recipe;

import dao.IngredientDAO;
import dao.RecipeDAO;
import dto.Recipe;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 100, // 50MB
        maxFileSize = 1024 * 1024 * 100, // 50MB
        maxRequestSize = 1024 * 1024 * 100) // 50MB
public class AddRecipeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    private static final String ERROR = "addrecipe.jsp";
    private static final String ERROR_MISSING_USER = "login.jsp";
    private static final String SUCCESS = "profile";

    protected void processRequest (HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ServletContext sc = request.getServletContext();
        String url = ERROR;
        try {
            /* TODO output your page here. You may use following sample code. */

 /* TODO output your page here. You may use following sample code. */
            User user = (User) session.getAttribute("login");
            if (user == null) {
                url = ERROR_MISSING_USER;
                throw new NullPointerException("User not Exist");
            }
            int userId = user.getId();

            String recipeName = Tools.toUTF8(request.getParameter("recipe-name"));
            if (recipeName.isEmpty()) {
                request.setAttribute("ADD_RECIPE_FAILED", "Please Add Recipe Name");
                throw new Exception("Recipe Name Empty");
            }
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
            //set default number
            int prepareTime = 30;
            int cookTime = 30;
            int cover = 0;//video image cover

            try {
                prepareTime = Integer.parseInt(request.getParameter("cook-time"));
                cookTime = Integer.parseInt(request.getParameter("prepare-time"));
                cover = Integer.parseInt(request.getParameter("cover"));
            } catch (NumberFormatException e) {

            }
            Collection<Part> parts = request.getParts();
            int vIndex = 0;
            int iIndex = 0;
            out.print("<br>" + recipeName);
            out.print("<br>" + recipeDescription);
            out.print("<hr>" + "Pictures " + cover);
            for (Part p : parts) {
                if (p.getName().contains("video-image")) {
                    try {
                        out.print("<br>" + p.getName());
                        out.print(", " + p.getSubmittedFileName().isEmpty());
                        out.print(", " + p.getSubmittedFileName());
                        out.print(", " + p.getContentType());
                        out.print(", " + (vIndex++ == cover));
                        pictureList.add(p);
                    } catch (Exception e) {
                    }
                }
                if (p.getName().contains("inst-image")) {
                    try {
                        out.print("<br>" + p.getName());
                        out.print(", " + p.getSubmittedFileName().isEmpty());
                        out.print(", " + p.getSubmittedFileName());
                        out.print(", " + p.getContentType());
                        out.print(", " + instDescription[iIndex++]);
                        instImgList.add(p);
                    } catch (Exception e) {
                    }
                }
            }
            out.print("<hr>" + "Ingredients");
            if (ingreName != null)
                for (int i = 0; i < ingreName.length; i++) {
                    if (ingreAmount[i].isEmpty())
                        ingreAmount[i] = "1 oz";
                    out.print("<br>" + ingreAmount[i] + " of " + ingreName[i]);
                }
            boolean recipeAdded
                    = RecipeDAO.addRecipe(recipeName, recipeDescription, videoUrl, pictureList, ingreName,
                            ingreAmount, instImgList, instDescription, prepareTime, cookTime, userId, cover, sc);
            if (recipeAdded) {
                url = SUCCESS;
                session.setAttribute("ADD_RECIPE_SUCCESS", "Recipe added!");
            } else {
                session.setAttribute("ADD_RECIPE_FAILED", "Recipe adding failed!");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
            e.printStackTrace();
        } finally {
//            response.sendRedirect(url);
        }
//        request.getRequestDispatcher("addrecipe.jsp").forward(request, response);
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
    protected void doGet (HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        try {
            
            session.setAttribute("IP_INGREDIENTS", IngredientDAO.getAllIngredients());
            session.setAttribute("IP_INGAMOUNTS", IngredientDAO.MEASUREMENTS);
        } catch (SQLException ex) {
            Logger.getLogger(AddRecipeController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.getRequestDispatcher(ERROR).forward(request, response);
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
    protected void doPost (HttpServletRequest request,
            HttpServletResponse response)
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
