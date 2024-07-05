package dao; 


import java.awt.Image;
import java.io.InputStream;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
 
import bean.Automobile; 
 
public class AutomobileDAO { 
 private Connection connection; 
 
    public AutomobileDAO(Connection connection) { 
        this.connection = connection; 
    } 
   
    public void createAutomobile( String nome, String marca, String modello, double prezzo,InputStream foto,String descrizione) throws SQLException { 
        String query = "INSERT INTO automobile (nome, marca,modello,prezzo,foto,descrizione) VALUES (?,?,?,?,?,?)"; 
        try (PreparedStatement stmt = connection.prepareStatement(query)) { 
            stmt.setString(1, nome); 
            stmt.setString(2, marca); 
            stmt.setString(3, modello); 
            stmt.setDouble(4, prezzo); 
            stmt.setBlob(5, foto); 
            stmt.setString(6, descrizione); 
            stmt.executeUpdate(); 
        } 
    } 
 
    public List<Automobile> readAutomobile() throws SQLException { 
        List<Automobile> automobili = new ArrayList<>(); 
        String query = "SELECT * FROM automobile"; 
        try (Statement stmt = connection.createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) { 
            while (rs.next()) { 
             Automobile automobile = new Automobile(); 
             automobile.setNome(rs.getString("nome")); 
             automobile.setMarca(rs.getString("marca")); 
             automobile.setModello(rs.getString("modello")); 
             automobile.setPrezzo(rs.getDouble("prezzo")); 
             automobile.setFoto(rs.getBlob("foto")); 
             automobile.setDescrizione(rs.getString("descrizione")); 
             automobili.add(automobile); 
            } 
        } 
        return automobili; 
    } 
 
    public void updateAutomobile(int id, String nome, String marca, String modello, double prezzo, String foto,String descrizione) throws SQLException { 
        String query = "UPDATE automobile SET nome = ?, marca = ?, modello = ?, prezzo = ?, foto = ?, descrizione = ? WHERE id = ?"; 
        try (PreparedStatement stmt = connection.prepareStatement(query)) { 
          
         stmt.setString(1, nome); 
         stmt.setString(2, marca); 
         stmt.setString(3, modello); 
         stmt.setDouble(4, prezzo); 
         stmt.setString(5, foto); 
         stmt.setString(6, descrizione); 
            stmt.setInt(7, id); 
            stmt.executeUpdate(); 
        } 
    } 
 
    public void deleteAutomobile(int id) throws SQLException { 
        String query = "DELETE FROM automobile WHERE id = ?"; 
        try (PreparedStatement stmt = connection.prepareStatement(query)) { 
            stmt.setInt(1, id); 
            stmt.executeUpdate(); 
        } 
    } 
 
}
