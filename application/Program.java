package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.ContatoSistema;
import service.AgendaSistema;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> array = new ArrayList();
		ArrayList<String> AgendaFav = new ArrayList();
		ArrayList<String> historico = new ArrayList();
		historico.add(null);

		AgendaSistema agenda = new AgendaSistema();
		ContatoSistema contt = new ContatoSistema();
		ContatoSistema favorito = new ContatoSistema();

		String resp;
		String dados,RespFav;
		boolean laco=true;
		int ddd;


		while (laco==true) {

			System.out.print("Nome: ");
			dados = sc.nextLine();
			contt.setNome(dados);

			System.out.print("DDD: ");
			ddd = sc.nextInt();
			contt.setDigito(ddd);

			System.out.print("Número: ");
			dados = sc.next();
			contt.setNumero(dados);

			System.out.print("Tipo(Celular, Residencial, etc): ");
			dados = sc.next();
			contt.setTipo(dados);

			System.out.print("E-mail: ");
			dados = sc.next();
			contt.setEmail(dados);

			System.out.print("Adicionar aos favoritos? [s]/[n] ");
			RespFav = sc.next();
			if (RespFav.equalsIgnoreCase("s")) {
				contt.setFavorito(true);

				favorito.setListaFav(contt.getNome());
				AgendaFav.add(favorito.getListaFav());

			} else {
				contt.setFavorito(false);
				AgendaFav.add(null);
			}

			agenda.setContatos(contt);

			array.add(agenda.getContatos());

			
			System.out.print("Deseja acrecentar mais um contato? [s]/[n] ");
			resp = sc.next();
			if(resp.equalsIgnoreCase("n")) {
				laco=false;
			}
			
			System.out.println("");
			sc.nextLine();
		}

		// System.out.println(agenda.getContatos());

		/*
		  for(int i=0;i<array.size();i++) { 
		  		System.out.println(array.get(i)); 
		  }*/

		System.out.print("Deseja ver sua lista de contatos? [s]/[n] ");
		resp = sc.next();
		if (resp.equalsIgnoreCase("s")) {
			for (String arrays : array) {
				System.out.println(arrays);
				System.out.println("=======\n");
			}
			
		} else {
			System.out.println("Ok, então.\n");
		}

		System.out.print("Deseja ver os favoritos? [s]/[n ");
		resp = sc.next();
		if (resp.equalsIgnoreCase("s")) {
			if(AgendaFav.contains(null)) {
				System.out.println("Não há favoritos.\n");
			}else {
				for(String agendas: AgendaFav) {
					System.out.println(agendas);
				}					
			}
			
		}else {
			System.out.println("Ok, então.\n");
		}
		
		System.out.print("Deseja ver seu histórico de chamadas? [s]/[n] ");
		resp=sc.next();
		if(resp.equalsIgnoreCase("s")) {
			if(historico.contains(null)) {
				System.out.println("Nenhuma chamada.");
			}else {
				for(String historicos: historico) {
					System.out.println(historicos);
				}
			}
			
		}

		sc.close();
	}

}
