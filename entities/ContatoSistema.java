package entities;

import service.AgendaSistema;

public class ContatoSistema {

	AgendaSistema agenda = new AgendaSistema();

	private String nome;
	private String numero;
	private String tipo;
	private String email;
	private Boolean favorito;

	public ContatoSistema(String nome, String numero, String tipo, String email, Boolean favorito) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.tipo = tipo;
		this.email = email;
		this.favorito = favorito;
	}

	public Boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return nome + "\n" + tipo + "\n+55 " + numero + "\n" + email + "\n" + agenda.isFav(favorito);
	}

}
