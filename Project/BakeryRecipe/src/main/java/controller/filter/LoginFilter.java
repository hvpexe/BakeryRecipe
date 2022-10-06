/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package controller.filter;

import dao.UserDAO;
import dto.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import utils.Tools;

/**
 *
 * @author Admin
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/login"})
public class LoginFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public LoginFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LoginFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LoginFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("LoginFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        /**
         * ?code=eyJhbGciOiJSUzI1NiIsImtpZCI6ImJhMDc5YjQyMDI2NDFlNTRhYmNlZDhmYjEzNTRjZTAzOTE5ZmIyOTQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJuYmYiOjE2NjQzNzQ2OTYsImF1ZCI6IjI0MzA1NzQ3NzY3NS1rdDU4bXI5bGF2OGVoNnRpOWJmcmo4cDc4Mmo3dW5rZC5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjExMTMwNTc2OTIzMjI0MzUwNTQ2OCIsImhkIjoiZnB0LmVkdS52biIsImVtYWlsIjoiYmluaG50c2UxNjA4NjBAZnB0LmVkdS52biIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhenAiOiIyNDMwNTc0Nzc2NzUta3Q1OG1yOWxhdjhlaDZ0aTliZnJqOHA3ODJqN3Vua2QuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJuYW1lIjoiTmd1eWVuIFRoYW5oIEJpbmggKEsxNl9IQ00pIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hLS9BQ05QRXU5N1JOY2FlS0lUckZ2Vk5zSFkwZFBPWXZJeENXbFF1aExEOU42N3ZRPXM5Ni1jIiwiZ2l2ZW5fbmFtZSI6Ik5ndXllbiBUaGFuaCBCaW5oIiwiZmFtaWx5X25hbWUiOiIoSzE2X0hDTSkiLCJpYXQiOjE2NjQzNzQ5OTYsImV4cCI6MTY2NDM3ODU5NiwianRpIjoiMWVjNWRiYjg5YjVmMDY0N2M3OGI3NzBhMWI4N2M5ZjNiOTI0ZWI4ZSJ9.SJRYBYZbTIXVM-7O_Xxi7qTKbn-uPN4nQcH2dPXduz2Kp5kXjwC9bFJJG0b3YZqol4vdaPoWWQMSuqJtX3uPhtsYb35d7hE7UGxEz4GfKSqOfua6mOYZ5FsZeZt41TKOx05pym2-MRoSzR-dcCMfMaUlFyrzI93Ttdy6FkSM1ZhLHjOui8c7cwdzmqSza2D95tCz-HN37_Wm4qAHgx9GJqJKAdhKif_iCg5_oYvPzqNlFZiGiA2eiA1iizJsmGwMcGWYS53CFjGFnLOnECo9S7W6f20cblWSH44PvIYWCMYMv8EvwgSXaP6yRfnNadmTjVvLpDNxIm8w6vS1hbZu8g
         * &email=binhntse160860%40fpt.edu.vn
         * &name=Nguyen+Thanh+Binh+%28K16_HCM%29
         * &avatar=https%3A%2F%2Flh3.googleusercontent.com%2Fa-%2FACNPEu97RNcaeKITrFvVNsHY0dPOYvIxCWlQuhLD9N67vQ%3Ds96-c
         * &lastname=%28K16_HCM%29 &firstname=Nguyen+Thanh+Binh
         */
        try {
            
            String code = request.getParameter("code");
            String email = request.getParameter("email");
            if (!(code == null || code.isEmpty())) {
                User user = UserDAO.loginWithGoogle(email);
                if (user != null) {
                    request.setAttribute("LOGIN_USER", user);
                    System.out.println("Login Google Filter " + user);

                } else {
                    String name = Tools.toUTF8(request.getParameter("name"));
                    String avatar = request.getParameter("avatar");
                    String lastname = Tools.toUTF8(request.getParameter("lastname"));
                    String firstname = Tools.toUTF8(request.getParameter("firstname"));
                    UserDAO.register(email, "", firstname, lastname, avatar);
                }
            }
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("LoginFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("LoginFilter()");
        }
        StringBuffer sb = new StringBuffer("LoginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
