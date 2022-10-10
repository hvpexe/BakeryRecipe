/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "GetInstructionTemplate", urlPatterns = {"/ajax/GetInstructionTemplate"})
public class GetInstructionTemplate extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //?detail=hello&count=1
            String detail = request.getParameter("detail");
            String count = request.getParameter("count");

            out.println("<div class=\"col align-items-center p-0 \" id=\"inst"+count+"\">\n"
                    + "                                <h5 class=\"text-secondary col-12 p-0\">\n"
                    + "                                    Step <span>"+count+"</span>\n"
                    + "                                    <input name=\"step\" onclick=\"this.previousElementSibling.innerText = this.value\" type=\"hidden\" value=\""+count+"\">\n"
                    + "                                </h5>\n"
                    + "                                <div class=\"col hover-highlight  p-0 pr-2 d-flex align-items-center border border-secondary rounded\" onclick=\"showDetail(this.parentElement);\">\n"
                    + "                                    <div class=\"inst-img d-inline-flex fas fa-camera position-relative align-items-center justify-content-center\" src=\"\" onclick=\"this.querySelector('input').click();\">\n"
                    + "                                        <input name=\"inst-image\"  id=\"inst-image"+count+"\" class=\"d-none\" readonly=\"\" type=\"file\" accept=\"image/*\" \n"
                    + "                                               onchange=\"changeIngrImg(this.parentElement, window.URL.createObjectURL(this.files[0]), event)\">\n"
                    + "                                    </div>\n"
                    + "                                    <input class=\"instruction-box-input col \"  value=\""+detail+"\"\n"
                    + "                                           readonly=\"\" name=\"inst-description\" id=\"inst-description"+count+"\" type=\"text\">\n"
                    + "                                    <div class=\"item-trashbin fas fa-trash ml-auto description-button\" onclick=\"removeElem(this.parentElement)\"></div>\n"
                    + "                                </div>\n"
                    + "                            </div>");
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
