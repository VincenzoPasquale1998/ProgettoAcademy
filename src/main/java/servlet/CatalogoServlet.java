package servlet;
 
import jakarta.servlet.ServletException; 
 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
import java.sql.SQLException; 
import java.util.List; 
 
import bean.Automobile; 
import dao.AutomobileDAO; 
 
public class CatalogoServlet extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
     
 private AutomobileDAO automobileDao; 
  
    public CatalogoServlet() { 
        super(); 
         
    } 
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
   
  try { 
   List<Automobile> listaAuto = automobileDao.readAutomobile(); 
   request.setAttribute("listaAuto", listaAuto ); 
   request.getRequestDispatcher("catalogo.jsp").forward(request,response); 
    
   
    
  } catch (SQLException e) { 
   throw new 
   ServletException("Errore non riesco a recuperare le automobili", e ); 
  } 
 } 
 
 
   
  
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
   
  doGet(request, response); 
 } 
 
}