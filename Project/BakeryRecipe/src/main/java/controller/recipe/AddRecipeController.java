/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.recipe;

import dao.RecipeDAO;
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

            System.out.println("running addrecipe");
            User user = (User) session.getAttribute("login");
            if (user == null) {
                url = ERROR_MISSING_USER;
                throw new NullPointerException("User not Exist");
            }
            int userId = user.getId();

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
            ingreName=Tools.toUTF8(ingreName);
            ingreAmount=Tools.toUTF8(ingreAmount);
            List<Part> instImgList = new LinkedList<Part>();//get all instuction images
            String[] instDescription = Tools.toUTF8(request.getParameterValues("inst-description"));//get all instuction descrition
            int prepareTime = Integer.parseInt(request.getParameter("prepare-time"));
            int cookTime = Integer.parseInt(request.getParameter("cook-time"));
            Collection<Part> parts = request.getParts();
            int vIndex = 0;
            int iIndex = 0;
            int cover = Integer.parseInt(request.getParameter("cover"));//video image cover
            for (String string : ingreName) {
                out.print("<br>"+string);
            }
            for (Part p : parts) {
                if (p.getName().contains("video-image")) {
                    try {
                        out.print("<hr>" + p.getName());
                        out.print("<br>" + p.getSubmittedFileName().isEmpty());
                        out.print("<br>" + p.getSubmittedFileName());
                        out.print("<br>" + p.getContentType());
                        out.print("<br>" + (vIndex == cover));
                        pictureList.add(p);
                    } catch (Exception e) {

                    }
                    vIndex++;
                }
                if (p.getName().contains("inst-image")) {
                    try {
                        out.print("<hr>" + p.getName());
                        out.print("<br>" + p.getSubmittedFileName().isEmpty());
                        out.print("<br>" + p.getSubmittedFileName());
                        out.print("<br>" + p.getContentType());
                        out.print("<br>" + instDescription[iIndex]);
                        instImgList.add(p);
                    } catch (Exception e) {

                    }
                    iIndex++;
                }
            }
            out.print("<hr>" + pictureList);
            out.print("<hr>" + instImgList);
            /*http://localhost:8080/BakeryRecipe/AddRecipe
            ?recipe-name=Baker+bake&
            recipe-description=aaaaaaaaaaa&
            cover=1&
            video-url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DZOvyn72x6kQ%26ab_channel%3DAperture&
            video-image=56757438_868951923446849_7427423009536737280_n.jpg&
            ingre-name=egg&
            ingre-amount=1&
            ingre-name=banana&
            ingre-amount=123&
            count=3&
            step=1&
            inst-image=56757438_868951923446849_7427423009536737280_n.jpg
            inst-description=Hello
            step=2
            count=3
            prepare-time=180
            cook-time=180*/
            boolean recipeAdded
                    = RecipeDAO.addRecipe(recipeName, recipeDescription, videoUrl, pictureList, ingreName,
                            ingreAmount, instImgList, instDescription, prepareTime, cookTime, userId, cover, sc);
            if (recipeAdded) {
                url = SUCCESS;
                session.setAttribute("ADD_RECIPE_SUCCESS","Recipe added!");
            }else{
                session.setAttribute("ADD_RECIPE_FAILED","Recipe adding failed!");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
            e.printStackTrace();
        } finally {
            response.sendRedirect(url);
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
        request.getRequestDispatcher(ERROR).forward(request, response);
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
