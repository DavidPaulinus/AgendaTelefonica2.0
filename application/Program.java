package application;

import java.util.Scanner;

import service.AgendaSistema;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		AgendaSistema agenda = new AgendaSistema();

		String resp;

		while (true) {

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
			if (resp.equalsIgnoreCase("n"))
				break;

			System.out.println("");
		}

		System.out.print("\nDeseja ver sua lista de contatos? [s]/[n] ");
		resp = sc.nextLine();
		agenda.listar(resp);

		System.out.print("\nDeseja ver os favoritos? [s]/[n] ");
		resp = sc.nextLine();
		agenda.listarFav(resp);
		
		System.out.print("\nDeseja alterar algum contato? [s]/[n]");

		System.out.print("\nDeseja deletar algum contato? [s]/[n] ");
		resp = sc.nextLine();
		while (true) {
			agenda.deletarContato(resp, sc);
			
			System.out.print("\nDeseja deletar mais algum contato? [s]/[n] ");
			resp = sc.nextLine();
			if (resp.equalsIgnoreCase("n"))
				break;

		}
		
		sc.close();
	}

}
