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



public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       private AutomobileDAO automobileDao;

    public UpdateServlet() {
        super();

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Automobile a;
		try {
			a = automobileDao.getAutoByID(id);
			request.setAttribute("auto", a);
	        request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//(int id, String nome, String marca, String modello, double prezzo, String foto,String descrizione)
		try {
			int id= Integer.parseInt(request.getParameter("id2"));
			double prezzo=Double.parseDouble(request.getParameter("prezzo"));
			automobileDao.updateAutomobile(id,request.getParameter("nome"),request.getParameter("marca"),request.getParameter("modello"),prezzo,request.getParameter("foto"),request.getParameter("descrizione"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
