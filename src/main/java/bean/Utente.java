package bean; 
 
public class Utente { 
 private int id; 
 private String nome, password; 
 private int permesso; 
 
 public Utente() { 
  super(); 
  // TODO Auto-generated constructor stub 
 } 
 
 public Utente(int id, String nome, String password, int permesso) { 
  super(); 
  this.id = id; 
  this.nome = nome; 
  this.password = password; 
  this.permesso = permesso; 
 } 
 
 public int getId() { 
  return id; 
 } 
 
 public void setId(int id) { 
  this.id = id; 
 } 
 
 public String getNome() { 
  return nome; 
 } 
 
 public void setNome(String nome) { 
  this.nome = nome; 
 } 
 
 public String getPassword() { 
  return password; 
 } 
 
 public void setPassword(String password) { 
  this.password = password; 
 } 
 
 public int getPermesso() { 
  return permesso; 
 } 
 
 public void setPermesso(int permesso) { 
  this.permesso = permesso; 
 } 
 
}