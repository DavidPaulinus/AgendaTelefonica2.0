package entities;

public class ContatoSistema {
	private String nome;
	private int digito;
	private String numero;
	private String tipo;
	private boolean favorito;
	private String listaFav;
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDigito() {
		return "(" + digito + ")";
	}

	public void setDigito(int digito) {
		this.digito = digito;
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

	public String getFavorito() {
		if (this.favorito == true) {
			return "Favorito";
		} else {
			return "";
		}
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public String getListaFav() {
		return listaFav;
	}

	public void setListaFav(String listaFav) {
		this.listaFav = listaFav;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return nome + "\n" + tipo + "\n" + getDigito() + " " + numero + "\n" + email + "\n" + getFavorito();
	}

}
