/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.NotifyDAO;
import dto.Notify;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "NotificationController", urlPatterns = {"/notification"})
public class NotificationController extends HttpServlet {

    private static final String SUCCESS = "notification.jsp";

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
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = SUCCESS;
        try {
            int receiverID = Integer.parseInt(request.getParameter("receiverID"));
            List<Notify> nre = NotifyDAO.notifyLike(receiverID);
            request.setAttribute("LIST_LIKE", nre);
            List<Notify> listComment = NotifyDAO.followList(receiverID);
            
            request.setAttribute("LIST_COMMENT", listComment);

            List<Notify> listAllNotify = NotifyDAO.getAllNotify(receiverID);
            int unseenSize = 0;
            for (Notify notify : listAllNotify) {
                if (!notify.isIsSeen())
                    unseenSize++;
            }
            request.setAttribute("LIST_ALL_NOTIFY", listAllNotify);
            request.setAttribute("U_SIZE", unseenSize);
            System.out.println(unseenSize);
            /* TODO output your page here. You may use following sample code. */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            request.getRequestDispatcher(url).forward(request, response);
        }
        out.close();
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
        request.setAttribute("SHOW_PAGE", true);
        processRequest(request, response);
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
        request.setAttribute("SHOW_PAGE", false);
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
