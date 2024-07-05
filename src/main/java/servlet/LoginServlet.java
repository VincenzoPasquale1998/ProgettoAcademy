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

import dao.AutomobileDAO;
import dao.UtenteDAO;
import bean.Utente;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
        	DatabaseManager dbManager = new DatabaseManager();
			UtenteDAO utenteDAO= new UtenteDAO(dbManager.getConnection());
			
			Utente u = utenteDAO.getUtenteByUsernamePassword(username, password);

            if (u != null) {
                HttpSession session = request.getSession();
                session.setAttribute("utente", u);
                session.setAttribute("isLoggedIn", true);
                
                request.setAttribute("msg", "Login avvenuto con successo");
                request.getRequestDispatcher("homePage.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            throw new ServletException("Database access error", e);
        }
    }
}
