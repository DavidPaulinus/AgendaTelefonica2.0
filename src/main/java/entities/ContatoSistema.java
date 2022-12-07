package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import service.AgendaSistema;

@Entity
@Table(name = "contatos")
public class ContatoSistema {
	private String nome;
	private String numero;
	private String tipo;
	private String email;
	private Boolean favorito;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public ContatoSistema() {
	}

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\n" + nome + "\n" + numero + "\n" + tipo + "\n" + email + "\n"
				+ AgendaSistema.isFav(favorito);
	}

}
