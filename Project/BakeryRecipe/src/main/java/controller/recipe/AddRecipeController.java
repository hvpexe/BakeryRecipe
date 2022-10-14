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
            ?recipe-name=Baker+bake
            recipe-description=aaaaaaaaaaa
            cover=1
            video-url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DZOvyn72x6kQ%26ab_channel%3DAperture
            video-image=56757438_868951923446849_7427423009536737280_n.jpg
            video-image=50808996_588337204972341_8710699352852529152_n.jpg
            ingre-name=egg
            ingre-amount=1
            ingre-name=banana
            ingre-amount=123
            count=3
            step=1
            inst-image=56757438_868951923446849_7427423009536737280_n.jpg
            inst-description=Hello
            step=2
            inst-image=156a0d2872579f1ffcaa5d2127239bfd.jpg
            inst-description=Home%0D%0ACommunity%0D%0ASaved%0D%0AShopping%0D%0ASearch%0D%0ASign+up+%2F+Sign+in%0D%0A+Create+Recipe%0D%0A%0D%0ASave%0D%0ATitle%0D%0ABaker+bake%0D%0ADescription%0D%0Aaaaaaaaaaaa%0D%0AUpdate+Video%0D%0AAdd+Image%0D%0A++Set+As+Cover+Change+Image%0D%0AIngredients%0D%0A+%0D%0AEgg%0D%0AAmount%3A%0D%0A1%0D%0A+%0D%0ABanana%0D%0AAmount%3A%0D%0A123%0D%0AAdd+one+ingredient%0D%0AAmount%3A%0D%0A1+Piece%0D%0AInstructions%0D%0AStep+1%0D%0AHello%0D%0APaste+one+or+multiple+steps+%28e.g.+Finely+chop+the+garlic%29%0D%0APrepare+Time%0D%0A0%0D%0ACook+Time%0D%0A0%0D%0AAdd+recipe
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
            Part path = request.getPart("video-image");
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
