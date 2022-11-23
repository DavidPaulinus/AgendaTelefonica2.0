package application;

import java.util.Scanner;

import service.AgendaSistema;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		AgendaSistema agenda = new AgendaSistema();

		String resp = "s";

		while (resp.equalsIgnoreCase("s")) {

			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Número: ");
			String numero = sc.nextLine();
			System.out.print("Tipo(Celular, Residencial, etc): ");
			String tipo = sc.nextLine();
			System.out.print("E-mail: ");
			String email = sc.nextLine();
			System.out.print("Adicionar aos favoritos? [s]/[n] ");
			String favorito = sc.nextLine();

			agenda.salvarContato(nome, numero, tipo, favorito, email);

			System.out.print("\nDeseja acrecentar mais um contato? [s]/[n] ");
			resp = sc.nextLine();

			System.out.println("");
		}

		System.out.print("\nDeseja ver sua lista de contatos? [s]/[n] ");
		resp = sc.nextLine();
		agenda.listar();

		System.out.print("\nDeseja ver os favoritos? [s]/[n] ");
		resp = sc.nextLine();
		agenda.listarFav();
		
		System.out.print("\nDeseja alterar algum contato? [s]/[n]");
		resp = sc.nextLine();
		if (resp.equalsIgnoreCase("s")) {
			agenda.listar();

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

			agenda.alterarContato(nome, numero);
			sc.nextLine();

		} else {
			System.out.println("\nOk então");
		}


		System.out.print("\nDeseja deletar algum contato? [s]/[n] ");
		resp = sc.nextLine();
		if (resp.equalsIgnoreCase("s")) {

			agenda.listar();

			System.out.println("Qual deseja deletar? ");
			System.out.print("Nome: ");
			String nome = sc.nextLine();

			agenda.deletarContato(nome);
			System.out.print("\nDeseja deletar mais algum contato? [s]/[n] ");
			resp = sc.nextLine();

		} else {
			System.out.println("\nOk então");
		}
		
		agenda.listar();

		sc.close();
	}

}
