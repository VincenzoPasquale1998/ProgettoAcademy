package bean;

import com.mysql.cj.jdbc.Blob;

public class Automobile { 
	private int id; 
	private String nome,marca,modello; 
	private double prezzo; 
	private Blob foto;
	private String descrizione; 
	public Automobile() { 
		super(); 
		// TODO Auto-generated constructor stub 
	} 
	public Automobile(int id, String nome, String marca, String modello, double prezzo, Blob foto,String descrizione) { 
		super(); 
		this.id = id; 
		this.nome = nome; 
		this.marca = marca; 
		this.modello = modello; 
		this.prezzo = prezzo; 
		this.foto = foto; 
		this.descrizione=descrizione; 
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
	public String getMarca() { 
		return marca; 
	} 
	public void setMarca(String marca) { 
		this.marca = marca; 
	} 
	public String getModello() { 
		return modello; 
	} 
	public void setModello(String modello) { 
		this.modello = modello; 
	} 
	public double getPrezzo() { 
		return prezzo; 
	} 
	public void setPrezzo(double prezzo) { 
		this.prezzo = prezzo; 
	} 
	public Blob getFoto() { 
		return foto; 
	} 

	public String getDescrizione() { 
		return descrizione; 
	} 
	public void setDescrizione(String descrizione) { 
		this.descrizione = descrizione; 
	}
	public void setFoto(java.sql.Blob foto) {
		// TODO Auto-generated method stub
		this.foto = (Blob) foto; 
	} 




}
