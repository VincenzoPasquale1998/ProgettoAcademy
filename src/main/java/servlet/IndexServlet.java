package servlet;


import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DatabaseManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.Automobile;

import dao.AutomobileDAO;


/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private AutomobileDAO automobileDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() throws ServletException 
	{
		try {
			DatabaseManager dbManager = new DatabaseManager();
			automobileDao= new AutomobileDAO(dbManager.getConnection());
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
    public IndexServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			List<Automobile> automobili = automobileDao.readAutomobile();
			
				
				request.setAttribute("automobili", automobili);
				
				request.getRequestDispatcher("homepage.jsp").forward(request, response);
			
		} 
		catch (SQLException e) 
		{
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
