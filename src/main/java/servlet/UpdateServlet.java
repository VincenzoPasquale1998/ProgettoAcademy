package servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DatabaseManager;

import java.io.IOException;
import java.sql.SQLException;

import bean.Automobile;
import dao.AutomobileDAO;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AutomobileDAO automobileDao;
    private DatabaseManager dbManager;

    public UpdateServlet() {
        super();
    }

    public void init() throws ServletException {
        try {
            dbManager = new DatabaseManager(); 
            automobileDao = new AutomobileDAO(dbManager.getConnection());
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Automobile a = automobileDao.getAutoByID(id);
            request.setAttribute("auto", a);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id2"));
            double prezzo = Double.parseDouble(request.getParameter("prezzo"));
            automobileDao.updateAutomobile(id, request.getParameter("nome"), request.getParameter("marca"), request.getParameter("modello"), prezzo, request.getParameter("foto"), request.getParameter("descrizione"));
            
        
            response.sendRedirect("Success.jsp");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("Error.jsp");
        } finally {
            dbManager.close(); 
        }
    }

 
    
}