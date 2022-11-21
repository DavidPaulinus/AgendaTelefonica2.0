package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.ContatoSistema;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<ContatoSistema> agenda = new ArrayList<>();

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
			String favorito = sc.next();
			if (favorito.equalsIgnoreCase("s"))
				agenda.add(new ContatoSistema(nome, numero, tipo, true, email));

			else
				agenda.add(new ContatoSistema(nome, numero, tipo, false, email));

			System.out.print("Deseja acrecentar mais um contato? [s]/[n] ");
			resp = sc.next();
			if (resp.equalsIgnoreCase("n"))
				break;

			System.out.println("");
			sc.nextLine();
		}

		System.out.print("Deseja ver sua lista de contatos? [s]/[n] ");
		resp = sc.next();
		if (resp.equalsIgnoreCase("s"))
			for (ContatoSistema list : agenda) {
				System.out.println(list);
				System.out.println("=======");

			}

		else
			System.out.println("Ok, então.\n");

		System.out.print("Deseja ver os favoritos? [s]/[n] ");
		resp = sc.next();
		if (resp.equalsIgnoreCase("s")) {
			List<ContatoSistema> list = agenda.stream().filter(x -> x.isFavorito() == true).collect(Collectors.toList());
			for (ContatoSistema lis : list) {
				System.out.println(lis);
				System.out.println("=======");

			}
		} else {
			System.out.println("Ok, então.\n");
		}

		sc.close();
	}

}
