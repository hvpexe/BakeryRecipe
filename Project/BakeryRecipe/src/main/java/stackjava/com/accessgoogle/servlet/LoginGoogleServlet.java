package stackjava.com.accessgoogle.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import stackjava.com.accessgoogle.common.GooglePojo;

import stackjava.com.accessgoogle.common.GoogleUtils;

@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {

    private static final String LOGIN_FAILED = "login.jsp";
    private static final String LOGIN_SUCCESS = "login";
    private static final long serialVersionUID = 1L;

    public LoginGoogleServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String url = "";
        if (code == null || code.isEmpty()) {
            url = LOGIN_FAILED;
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
            HttpSession session = request.getSession();
            session.setAttribute("google", googlePojo);
            url = LOGIN_SUCCESS;
        }
        response.sendRedirect(url);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
