package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import util.DatabaseManager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import bean.Automobile;
import dao.AutomobileDAO;
//aaaaaa
@WebServlet("/uploadAutomobile")
@MultipartConfig(maxFileSize = 16177215) // 16MB
public class UploadAutomobileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AutomobileDAO automobileDao;

    public void init() throws ServletException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            automobileDao = new AutomobileDAO(dbManager.getConnection());
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{		
				request.getRequestDispatcher("update.jsp").forward(request, response);
			
		} 
		catch (Exception e) 
		{
			throw new ServletException(e);
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String modello = request.getParameter("modello");
        double prezzo = Double.parseDouble(request.getParameter("prezzo"));
        String descrizione = request.getParameter("descrizione");

        InputStream foto = null;
        Part filePart = request.getPart("foto");
        if (filePart != null) {
            foto = filePart.getInputStream();
        }

        try {
            automobileDao.createAutomobile(nome, marca, modello, prezzo, foto, descrizione);
            response.sendRedirect("homepage.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
