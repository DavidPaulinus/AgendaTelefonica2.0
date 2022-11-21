package entities;

public class ContatoSistema {
	private String nome;
	private String numero;
	private String tipo;
	private boolean favorito;
	private String email;

	public ContatoSistema(String nome, String numero, String tipo, boolean favorito, String email) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.tipo = tipo;
		this.favorito = favorito;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return nome + "\n" + tipo + "\n+55 " + numero + "\n" + email + "\n" + isFav();
	}
	
	private String isFav() {
		if(isFavorito()==true) 
			return "FAVORITO";
		else
			return "";
	}

}
