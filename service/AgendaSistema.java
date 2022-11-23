package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.ContatoSistema;

public class AgendaSistema {

	private List<ContatoSistema> agenda = new ArrayList<>();
	
	private Scanner sc = new Scanner(System.in);

	public void listar() {
		agenda.forEach(System.out::println);
	}

	public void listarFav() {
		if (agenda.stream().filter(x -> x.getFavorito() == true) == null) {
			System.out.println("Não há favoritos.");

		} else {
			agenda.stream().filter(x -> x.getFavorito() == true).collect(Collectors.toList())
					.forEach(System.out::println);
		}

	}

	public void salvarContato(String nome, String numero, String tipo, String favorito, String email) {
		if (favorito.equalsIgnoreCase("s"))
			agenda.add(0, new ContatoSistema(nome, numero, tipo, email, true));

		else
			agenda.add(new ContatoSistema(nome, numero, tipo, email, false));
	}

	public String isFav(Boolean favorito) {
		if (favorito == true)
			return "FAVORITO";
		else
			return "";
	}

	public void alterarContato(String nome, int numero) {

		Integer index = null;
		for (int i = 0; i < agenda.size(); ++i) {
			if (agenda.get(i).getNome().equals(nome)) {
				index = i;

			} 
		}

		switch (numero) {
		case 1:
			System.out.print("Nome: ");
			agenda.get(index).setNome(sc.nextLine());
			System.out.println("Alterado com sucesso");
			break;
		case 2:
			System.out.print("Tipo: ");
			agenda.get(index).setTipo(sc.nextLine());
			System.out.println("Alterado com sucesso");
			break;
		case 3:
			System.out.print("Número: ");
			agenda.get(index).setNumero(sc.nextLine());
			System.out.println("Alterado com sucesso");
			break;
		case 4:
			System.out.print("E-mail: ");
			agenda.get(index).setEmail(sc.nextLine());
			System.out.println("Alterado com sucesso");
			break;
		case 5:
			if (agenda.get(index).getFavorito() == true) {
				agenda.get(index).setFavorito(false);

			} else {
				agenda.get(index).setFavorito(true);

			}
			System.out.println("Alterado com sucesso");
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	public void deletarContato(String nome) {
		agenda.removeIf(x -> x.getNome().equals(nome));
		System.out.println("Contato " + nome + " removido com sucesso!");
	}

}
