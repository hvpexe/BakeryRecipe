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
  private static final long serialVersionUID = 1L;
  public LoginGoogleServlet() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    String url = "login.jsp"; 
    if (code == null || code.isEmpty()) {
        url="login.jsp";
    } else {
        System.out.println("Success");
      String accessToken = GoogleUtils.getToken(code);
      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
        HttpSession session = request.getSession();
      session.setAttribute("id", googlePojo.getId());
      session.setAttribute("name", googlePojo.getName());
      session.setAttribute("email", googlePojo.getEmail());
      session.setAttribute("gname", googlePojo.getGiven_name());
      session.setAttribute("fname", googlePojo.getFamily_name());
      session.setAttribute("image", googlePojo.getPicture());
      session.setAttribute("google", googlePojo);
        System.out.println("Login Success");
      url= "homePage.jsp";
    }
    response.sendRedirect(url);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}