package dao; 
 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
 
import bean.Utente; 
 
 
public class UtenteDAO { 
 private Connection connection; 
 
    public UtenteDAO(Connection connection) { 
        this.connection = connection; 
    } 
 
    public void createUtente(String nome, String password, int permesso) throws SQLException { 
        String query = "INSERT INTO utente (nome, password,permesso) VALUES (?, ?,?)"; 
        try (PreparedStatement stmt = connection.prepareStatement(query)) { 
            stmt.setString(1, nome); 
            stmt.setString(2, password); 
            stmt.setInt(3,permesso); 
            stmt.executeUpdate(); 
        } 
    } 
 
    public List<Utente> readUtente() throws SQLException { 
        List<Utente> utenti = new ArrayList<>(); 
        String query = "SELECT * FROM utente"; 
        try (Statement stmt = connection.createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) { 
            while (rs.next()) { 
             Utente utente = new Utente(); 
             utente.setId(rs.getInt("id")); 
             utente.setNome(rs.getString("nome")); 
             utente.setPassword(rs.getString("password")); 
             utente.setPermesso(rs.getInt("permesso")); 
             utenti.add(utente); 
            } 
        } 
        return utenti; 
    } 
 
    public void updateUtente(int id, String nome, String password, int permesso) throws SQLException { 
        String query = "UPDATE Utente SET nome = ?, password = ?, permesso = ? WHERE id = ?"; 
        try (PreparedStatement stmt = connection.prepareStatement(query)) { 
         stmt.setString(1, nome); 
         stmt.setString(2, password); 
         stmt.setInt(3, permesso); 
            stmt.setInt(4, id); 
            stmt.executeUpdate(); 
        } 
    } 
    public Utente getUtenteByUsernamePassword(String nome,String password) { 
  //Restituisce l'account relativo a username e password passati 
  String query = "SELECT * FROM utente WHERE nome = ? AND password = ? "; 
  PreparedStatement ps = null; 
  ResultSet resultSet = null; 
        Utente utente = new Utente(); 
  try { 
   ps = connection.prepareStatement(query); 
   ps.setString(1, nome); 
   ps.setString(2, password); 
   resultSet = ps.executeQuery(); //DQL 
            int rsCount = 0; 
            while (resultSet.next()) { 
             String curNome=resultSet.getString("nome"); 
             String curPassword=resultSet.getString("password"); 
             int curRuolo=resultSet.getInt("permesso"); 
                if (curNome.equals(nome) && curPassword.equals(password)) { 
                 rsCount = rsCount + 1; 
                 utente.setNome(nome); 
                 utente.setPassword(password); 
                 utente.setPermesso(curRuolo); 
                } 
            } 
            if (rsCount==0) utente=null; 
  } catch (SQLException e) { 
   // TODO Auto-generated catch block 
   e.printStackTrace(); 
  } 
 
  return utente; 
 } 
 
 
    public void deleteUtente(int id) throws SQLException { 
        String query = "DELETE FROM Utente WHERE id = ?"; 
        try (PreparedStatement stmt = connection.prepareStatement(query)) { 
            stmt.setInt(1, id); 
            stmt.executeUpdate(); 
        } 
    } 
 
}