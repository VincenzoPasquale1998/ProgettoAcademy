package bean; 

public class Automobile { 
	int id; 
	String nome,marca,modello; 
	double prezzo; 
	String foto,descrizione; 
	public Automobile() { 
		super(); 
		// TODO Auto-generated constructor stub 
	} 
	public Automobile(int id, String nome, String marca, String modello, double prezzo, String foto,String descrizione) { 
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
	public String getFoto() { 
		return foto; 
	} 
	public void setFoto(String foto) { 
		this.foto = foto; 
	} 
	public String getDescrizione() { 
		return descrizione; 
	} 
	public void setDescrizione(String descrizione) { 
		this.descrizione = descrizione; 
	} 




}
