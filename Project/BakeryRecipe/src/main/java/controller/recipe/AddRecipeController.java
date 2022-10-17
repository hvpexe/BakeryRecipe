/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.recipe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
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
            String recipeName = request.getParameter("recipe-name");
            String recipeDescription = request.getParameter("recipe-description");
            String videoUrl = request.getParameter("video-url");
            String[] videoImage = request.getParameterValues("video-image");
            String[] ingreName = request.getParameterValues("ingre-name");
            String[] ingreAmount = request.getParameterValues("ingre-amount");
            String[] instImage = request.getParameterValues("inst-image");
            String[] instDescription = request.getParameterValues("inst-description");
            int cover = Integer.parseInt(request.getParameter("cover"));
            int prepareTime = Integer.parseInt(request.getParameter("prepare-time"));
            int cookTime = Integer.parseInt(request.getParameter("cook-time"));
            Part path = request.getPart("inst-image");
            out.print("<br>" + recipeName);
            out.print("<br>" + recipeDescription);
            out.print("<br>" + videoUrl);
            for (String string : videoImage)
            {
                out.print("<br>" + string);
            }
            for (String string : ingreName)
            {
                out.print("<br>" + string);
            }
            for (String string : ingreAmount)
            {
                out.print("<br>" + string);
            }
            for (String string : instImage)
            {
                out.print("<br>" + string);
            }
            for (String string : instDescription)
            {
                out.print("<br>" + string);
            }
            out.print("<br>" + videoImage[cover]);
            out.print("<br>" + prepareTime);
            out.print("<br>" + cookTime);
        }
//        request.getRequestDispatcher("addrecipe.jsp").forward(request, response);
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
