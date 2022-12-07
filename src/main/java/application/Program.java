package application;

import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.EntityManager;

import entities.ContatoSistema;
import service.AgendaSistema;
import service.ConnectionFactory;

public class Program {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		EntityManager em = ConnectionFactory.getEntityManager();
		
		AgendaSistema agenda = new AgendaSistema(em);
		
		ContatoSistema contt = null;
		
		em.getTransaction().begin();
		
		while (true) {

			System.out.print("O que deseja fazer? " 
					+ "\n[1] - Salvar contato" 
					+ "\n[2] - Listar contatos"
					+ "\n[3] - Listar favoritos" 
					+ "\n[4] - Alterar contato" 
					+ "\n[5] - Deletar contato" 
					+ "\nR: ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch (num) {
			case 1:
				System.out.print("\nNome: ");
				String nome = sc.nextLine();
				System.out.print("Número: ");
				String numero = sc.nextLine();
				System.out.print("Tipo(Celular, Residencial, etc): ");
				String tipo = sc.nextLine();
				System.out.print("E-mail: ");
				String email = sc.nextLine();
				System.out.print("Adicionar aos favoritos? [s]/[n] ");
				String favorito = sc.nextLine();
				if (favorito.equalsIgnoreCase("s")) {
					agenda.salvarContato(contt = new ContatoSistema(nome, numero, tipo, email, true));
				} else {
					agenda.salvarContato(contt = new ContatoSistema(nome, numero, tipo, email, false));
				}
				
				agenda.listar();
				
				break;
			case 2:
				agenda.listar();
				break;
			case 3:
				agenda.listarFav();
				break;
			case 4:
				agenda.listar();

				System.out.println("\nQual deseja alterar? ");
				System.out.print("ID: ");
				Integer id = sc.nextInt();

				System.out.println("\nO que deseja alterar? " 
						+ "\n1 - Nome" 
						+ "\n2 - Tipo" 
						+ "\n3 - Número"
						+ "\n4 - E-mail" 
						+ "\n5 - Favorito");
				int opacao = sc.nextInt();
				sc.nextLine();
				agenda.alterarContatoPorId(id, opacao, contt);
				
				agenda.listar();
				break;
			case 5:
				agenda.listar();

				System.out.println("Qual deseja deletar? ");
				System.out.print("ID: ");
				id = sc.nextInt();
				sc.nextLine();
				agenda.deletarContatoPorId(id, contt);
				
				agenda.listar();
				break;
			default:
				System.out.println("Opção inválida");
				break;

			}

			System.out.println("\nMais alguma coisa? [s]/[n]");
			String resp = sc.nextLine();
			if (resp.equalsIgnoreCase("n"))
				break;

		}

		em.getTransaction().commit();
		em.close();

		sc.close();
	}

}
