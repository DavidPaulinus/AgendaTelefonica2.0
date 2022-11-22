package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.ContatoSistema;

public class AgendaSistema {

	private List<ContatoSistema> agenda = new ArrayList<>();

	public void salvarContato(String nome, String numero, String tipo, String favorito, String email) {
		if (favorito.equalsIgnoreCase("s"))
			agenda.add(0, new ContatoSistema(nome, numero, tipo, email, true));

		else
			agenda.add(new ContatoSistema(nome, numero, tipo, email, false));
	}

	public void listar(String resp) {
		if (resp.equalsIgnoreCase("s"))
			for (ContatoSistema list : agenda) {
				System.out.println(list);
				System.out.println("=======");

			}
		else
			System.out.println("\nOk, então.\n");

	}

	public void listarFav(String resp) {
		if (resp.equalsIgnoreCase("s")) {
			for (ContatoSistema lis : agenda.stream().filter(x -> x.getFavorito() == true)
					.collect(Collectors.toList())) {
				System.out.println(lis);
				System.out.println("=======");

			}
		} else {
			System.out.println("\nOk, então.\n");
		}

	}

	public String isFav(Boolean favorito) {
		if (favorito == true)
			return "FAVORITO";
		else
			return "";
	}

	public void alterarContato(String resp, Scanner sc) {
		for (ContatoSistema lis : agenda) {
			System.out.println(lis);
			System.out.println("=======");

		}
		System.out.println("\nQual deseja alterar? ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();

		System.out.println("\nO que deseja alterar? " 
				+ "\n1 - Nome" 
				+ "\n2 - Tipo" 
				+ "\n3 - Número" 
				+ "\n4 - E-mail"
				+ "\n5 - Favorito");

		int numero = sc.nextInt();

		switch (numero) {
		case 1:
			System.out.println("Alterado com sucesso");
			break;
		case 2:
			System.out.println("Alterado com sucesso");
			break;
		case 3:
			System.out.println("Alterado com sucesso");
			break;
		case 4:
			System.out.println("Alterado com sucesso");
			break;
		case 5:
			System.out.println("Alterado com sucesso");
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	public void deletarContato(String resp, Scanner sc) {
		for (ContatoSistema lis : agenda) {
			System.out.println(lis);
			System.out.println("=======");

		}
		System.out.println("Qual deseja deletar? ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();

		agenda.removeIf(x -> x.getNome().equals(nome));
		System.out.println("Contato " + nome + " removido com sucesso!");
	}

}
