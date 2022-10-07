/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.baker;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VO MINH MAN
 */
public class FollowController extends HttpServlet {
private static final String ERROR = "";
    private static final String SUCCESS = "";
    private static final String FOLLOW = "Follow";
    private static final String UN_FOLLOW = "unFollow";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {

            //Ý tưởng follow xử lý trong tb.Follow nếu người userID follow với action là Follow thì sẽ add vào trong Follow
            //Ý tưởng unFollow xử lý trong tb.Follow nếu người userID unfollow với action là unFollow thì sẽ delete vào trong unFollow
            UserDAO sc = new UserDAO();
            String action = request.getParameter("action");
            int userFollow = Integer.parseInt(request.getParameter("userID"));
            int userFollowed = Integer.parseInt(request.getParameter("userID1"));
            if (action.equals(FOLLOW)) {
                url = SUCCESS;
                sc.followUSer(userFollow, userFollowed);
            } else if (action.equals(UN_FOLLOW)) {
                url = SUCCESS;
                sc.UNFollow(userFollow, userFollowed);
            }

        } catch (Exception e) {
            System.out.println("Follow Controller have a problem");
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
