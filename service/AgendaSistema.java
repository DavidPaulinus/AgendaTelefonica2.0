package service;

import entities.ContatoSistema;

public class AgendaSistema {
	private ContatoSistema contatos;
	private ContatoSistema favoritos;
	
	
	public String getContatos() {
		return contatos.toString();
	}
	public void setContatos(ContatoSistema contatos) {
		this.contatos = contatos;
	}
	
	public ContatoSistema getFavoritos() {
		return favoritos;
	}
	public void setFavoritos(ContatoSistema favoritos) {
		this.favoritos = favoritos;
	}
}
