package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.DatabaseManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dao.AutomobileDAO;
import dao.UtenteDAO;
import bean.Automobile;
import bean.Utente;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			
		} 
		catch (Exception e) 
		{
			throw new ServletException(e);
		}
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //aaaa
        try {
        	DatabaseManager dbManager = new DatabaseManager();
			UtenteDAO utenteDAO= new UtenteDAO(dbManager.getConnection());
			
			Utente u = utenteDAO.getUtenteByUsernamePassword(username, password);

            if (u != null&&u.getPermesso()==0) {
                HttpSession session = request.getSession();
                session.setAttribute("utente", u);
                session.setAttribute("isLoggedIn", true);
                
                request.setAttribute("msg", "Login avvenuto con successo");
                request.getRequestDispatcher("homepage.jsp").forward(request, response);
            }
            else if(u.getPermesso()==1&&u!=null) {
            	HttpSession session = request.getSession();
                session.setAttribute("utente", u);
                session.setAttribute("isLoggedIn", true);
                
                request.setAttribute("msg", "Login avvenuto con successo");
                request.getRequestDispatcher("/catalogo").forward(request, response);
            }
            	else {
                response.sendRedirect("login.jsp");
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); 
            throw new ServletException("Database access error", e);
        }
    }
}
