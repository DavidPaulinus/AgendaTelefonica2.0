package service;

import java.util.Scanner;

import javax.persistence.EntityManager;

import entities.ContatoSistema;

public class AgendaSistema {
	Scanner sc = new Scanner(System.in);

	private EntityManager em;

	public AgendaSistema(EntityManager em) {
		this.em = em;
	}

	public AgendaSistema() {

	}

	public void listar() {
		System.out.println("\nLista de contatos: ");
		em.createQuery("SELECT c FROM ContatoSistema c", ContatoSistema.class).getResultList()
				.forEach(x -> System.out.println("\n" + x + "\n=============="));
	}

	public void listarFav() {
		System.out.println("\nLista de contatos: ");
		em.createQuery("SELECT c FROM ContatoSistema c", ContatoSistema.class).getResultList().stream()
				.filter(x -> x.getFavorito() == true).forEach(x -> System.out.println("\n" + x + "\n=============="));

	}

	public void salvarContato(ContatoSistema contt) {
		em.persist(contt);
		System.out.println("\nContato \"" + contt.getNome() + "\" salvo com sucesso");
	}

	public static String isFav(Boolean favorito) {
		if (favorito == true)
			return "FAVORITO";
		else
			return "";
	}

	public void alterarContatoPorNome(String nome, int numero, ContatoSistema contt) {
		contt = em.createQuery("SELECT c FROM ContatoSistema c WHERE nome = ?1", ContatoSistema.class)
				.setParameter(1, nome).getSingleResult();
		switch (numero) {
		case 1:
			System.out.print("Novo nome: ");
			contt.setNome(sc.nextLine());
			this.em.merge(contt);
			break;
		case 2:
			System.out.print("Novo tipo: ");
			contt.setTipo(sc.nextLine());
			this.em.merge(contt);
			break;
		case 3:
			System.out.print("Novo numero: ");
			contt.setNumero(sc.nextLine());
			this.em.merge(contt);
			break;
		case 4:
			System.out.print("Novo email: ");
			contt.setEmail(sc.nextLine());
			this.em.merge(contt);
			break;
		case 5:
			if (contt.getFavorito() == true) {
				contt.setFavorito(false);
				System.out.println("Favorito removido");
			} else {
				contt.setFavorito(true);
				System.out.println("Favorito adicionado");
			}
			this.em.merge(contt);
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
		System.out.println("\nContato \"" + nome + "\" alterado com sucesso!");
	}

	public void alterarContatoPorId(Integer id, int numero, ContatoSistema contt) {
		contt = em.find(ContatoSistema.class, id);
		switch (numero) {
		case 1:
			System.out.print("Novo nome: ");
			contt.setNome(sc.nextLine());
			this.em.merge(contt);
			break;
		case 2:
			System.out.print("Novo tipo: ");
			contt.setTipo(sc.nextLine());
			this.em.merge(contt);
			break;
		case 3:
			System.out.print("Novo numero: ");
			contt.setNumero(sc.nextLine());
			this.em.merge(contt);
			break;
		case 4:
			System.out.print("Novo email: ");
			contt.setEmail(sc.nextLine());
			this.em.merge(contt);
			break;
		case 5:
			if (contt.getFavorito() == true) {
				contt.setFavorito(false);
				System.out.println("Favorito removido");
			} else {
				contt.setFavorito(true);
				System.out.println("Favorito adicionado");
			}
			this.em.merge(contt);
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
		System.out.println("\nContato \"" + contt.getNome() + "\" alterado com sucesso!");
	}

	public void deletarContatoPorNome(String nome, ContatoSistema contt) {
		contt = em.merge(em.createQuery("SELECT c FROM ContatoSistema c WHERE nome = ?1", ContatoSistema.class)
				.setParameter(1, nome).getSingleResult());
		System.out.println("\nContato \""+contt.getNome()+"\" removido com sucesso");
		this.em.remove(contt);
	}
	
	public void deletarContatoPorId(Integer id, ContatoSistema contt) {
		contt = em.find(ContatoSistema.class, id);
		System.out.println("\nContato \""+contt.getNome()+"\" removido com sucesso");
		this.em.remove(contt);
	}

}
