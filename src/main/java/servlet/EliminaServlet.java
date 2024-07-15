package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DatabaseManager;

import java.io.IOException;
import java.sql.SQLException;

import dao.AutomobileDAO;

/**
 * Servlet implementation class EliminaServlet
 */
public class EliminaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AutomobileDAO automobileDao;
    DatabaseManager dbManager;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException { //init non è obbligatorio ma è tipo un costruttore 
        //init viene chiamato ogni volta che viene richiamata  la servlet 
        try {
            DatabaseManager dbManager = new DatabaseManager(); // crea il dbManager e crea la connesione, ogni volta che chiami init chiama la connessione
            automobileDao = new AutomobileDAO(dbManager.getConnection());

        } catch (SQLException e) {

            throw new ServletException(e);
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			automobileDao.deleteAutomobile(id);
			request.setAttribute("msg", "Auto Eliminata");
			request.getRequestDispatcher("/catalogo").forward(request, response);
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			dbManager.close();
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
