package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import entities.ContatoSistema;

public class AgendaSistema {
	private Scanner sc = new Scanner(System.in);

	private Connection conn;
	private ContatoSistema contato;

	public AgendaSistema(Connection conn) {
		this.conn = conn;
	}

	public void listar() throws SQLException {
		try (Statement stm = conn.createStatement()) {
			stm.execute("SELECT * FROM contatos");

			ResultSet rst = stm.getResultSet();

			while (rst.next()) {
				System.out.println(
						rst.getString("NOME") + "\n" + rst.getString("TIPO") + "\n55+ " + rst.getString("NUMERO") + "\n"
								+ rst.getString("EMAIL") + "\n" + isFav(rst.getByte("FAVORITO")) + "\n===============");
			}

		}
	}

	public void listarFav() throws SQLException {
		try (Statement stm = conn.createStatement()) {
			stm.execute("SELECT * FROM contatos WHERE favorito = 1");

			ResultSet rst = stm.getResultSet();

			while (rst.next()) {
				System.out.println(
						rst.getString("NOME") + "\n" + rst.getString("TIPO") + "\n55+ " + rst.getString("NUMERO") + "\n"
								+ rst.getString("EMAIL") + "\n" + isFav(rst.getByte("FAVORITO")) + "\n===============");
			}

		}

	}

	public void salvarContato(ContatoSistema contt) throws SQLException {
		try (PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO contatos (NOME, TIPO, NUMERO, EMAIL, FAVORITO) VALUES (?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, contt.getNome());
			ps.setString(2, contt.getTipo());
			ps.setString(3, contt.getNumero());
			ps.setString(4, contt.getEmail());
			ps.setByte(5, contt.getFavorito());

			ps.execute();

			contato = contt;
		}
	}

	public String isFav(Byte favorito) {
		if (favorito == (byte) 1)
			return "FAVORITO";
		else
			return "";
	}

	public void alterarContato(String nome, int numero) throws SQLException {

		switch (numero) {
		case 1:
			System.out.print("Nome: ");
			try (PreparedStatement ps = conn.prepareStatement("UPDATE contatos SET NOME = ? WHERE NOME = ?",
					Statement.RETURN_GENERATED_KEYS)) {

				ps.setString(1, sc.nextLine());
				ps.setString(2, nome);

				ps.execute();
			}
			System.out.println("Alterado com sucesso");
			break;
		case 2:
			System.out.print("Tipo: ");
			try (PreparedStatement ps = conn.prepareStatement("UPDATE contatos SET TIPO = ? WHERE NOME = ?",
					Statement.RETURN_GENERATED_KEYS)) {

				ps.setString(1, sc.nextLine());
				ps.setString(2, nome);

				ps.execute();
			}
			System.out.println("Alterado com sucesso");
			break;
		case 3:
			System.out.print("Número: ");
			try (PreparedStatement ps = conn.prepareStatement("UPDATE contatos SET NUMERO = ? WHERE NOME = ?",
					Statement.RETURN_GENERATED_KEYS)) {

				ps.setString(1, sc.nextLine());
				ps.setString(2, nome);

				ps.execute();
			}
			System.out.println("Alterado com sucesso");
			break;
		case 4:
			System.out.print("E-mail: ");
			try (PreparedStatement ps = conn.prepareStatement("UPDATE contatos SET EMAIL = ? WHERE NOME = ?",
					Statement.RETURN_GENERATED_KEYS)) {

				ps.setString(1, sc.nextLine());
				ps.setString(2, nome);

				ps.execute();
			}
			System.out.println("Alterado com sucesso");
			break;
		case 5:
			try (PreparedStatement ps = conn.prepareStatement("UPDATE contatos (FAVORITO) VALUES (?) WHERE NOME = ?",
					Statement.RETURN_GENERATED_KEYS)) {

				if (contato.getFavorito() == 0) {
					ps.setByte(1, (byte) 1);

				} else {
					ps.setByte(1, (byte) 0);
				}
				ps.setString(2, nome);

				ps.execute();
			}
			System.out.println("Alterado com sucesso");
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	public void deletarContato(String nome) throws SQLException {
		try (PreparedStatement ps = conn.prepareStatement("DELETE FROM contatos WHERE nome = ?")) {
			ps.setString(1, nome);
		}

		System.out.println("Contato " + nome + " removido com sucesso!");
	}

}
