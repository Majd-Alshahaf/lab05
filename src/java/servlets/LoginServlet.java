
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

public class LoginServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        

       
        
        if(request.getParameter("logout") != null){
            
            session.invalidate();
            session = request.getSession();
            String message = "you have been successfully logged out.";
            request.setAttribute("message", message);
        }
        else  if(session.getAttribute("username") != null){
            response.sendRedirect("home");
        }
        
       
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String login = request.getParameter("login");
            String message = "Failed authentication";
            User user;
            
            if(username != null || !username.equals("") || password != null || !password.equals("") && login != null){
                AccountService accountService = new AccountService();
                user = accountService.login(username, password);
                
                if(user!= null){
                    session.setAttribute("username", username);
                    response.sendRedirect("home");
                    return;
                }
                else{
                    request.setAttribute("username", username);
                    request.setAttribute("message", message);
                }
            }
        

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        return;
    }


}
