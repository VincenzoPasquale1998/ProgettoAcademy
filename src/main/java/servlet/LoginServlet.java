package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.UtenteDAO;
import bean.Utente;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrent", "root", "password");

            UtenteDAO utenteDAO = new UtenteDAO(connection);
            Utente utente = utenteDAO.getUtenteByUsernamePassword(username, password);

            if (utente != null) {
                HttpSession session = request.getSession();
                session.setAttribute("utente", utente);
                session.setAttribute("isLoggedIn", true);
                
                request.setAttribute("msg", "Login avvenuto con successo");
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            throw new ServletException("Database access error", e);
        }
    }
}
