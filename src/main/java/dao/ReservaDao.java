package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Reserva;
import solucoes.Conexao;

public class ReservaDao {
	// OPTION 1
	public void inserir(Reserva r) {
		try {
			Conexao conn = new Conexao();

			String sql = "INSERT INTO reserva (cidade, vlr_diaria, nmr, ocupado, rua) VALUES (?,?,?,?,?)";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);

			ps.setString(1, r.getCidade());
			ps.setDouble(2, r.getVlr_diaria());
			ps.setInt(3, r.getNmr());
			ps.setBoolean(4, r.getOcupado());
			ps.setString(5, r.getRua());
			ps.execute();

			System.out.println("Reserva Inserida");
		} catch (Exception e) {
			System.out.println("Erro em Inserir Reserva: " + e.getMessage());
		}
	}

	// OPTION 2
	public List<Reserva> buscarTodos() {
		List<Reserva> reservas = new ArrayList<>();

		try {
			Conexao conn = new Conexao();

			String sql = "SELECT * FROM reserva";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); // LINHA DO DB;

			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId_reserva(rs.getInt("id_reserva"));
				r.setCidade(rs.getString("cidade"));
				r.setVlr_diaria(rs.getDouble("vlr_diaria"));
				r.setNmr(rs.getInt("nmr"));
				r.setOcupado(rs.getBoolean("ocupado"));
				r.setRua(rs.getString("rua"));

				reservas.add(r);
			}
		} catch (Exception e) {
			System.out.println("Erro em listar Todas as Reservas : " + e.getMessage());
		}
		return reservas;
	}

	// OPTION 5.1
	public void editarTudo(Reserva r, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE reserva SET vlr_diaria=?, ocupado=? WHERE id_reserva=?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setDouble(1, r.getVlr_diaria());
			ps.setBoolean(2, r.getOcupado());
			ps.setInt(3, id);
			ps.executeUpdate();

			System.out.println("Reserva Editada - Tudo");
		} catch (Exception e) {
			System.out.println("Erro em editar Tudo Reserva: " + e.getMessage());
		}
	}

	// OPTION 5.2
	public void editarValor(Reserva r, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE reserva SET vlr_diaria=? WHERE id_reserva =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setDouble(1, r.getVlr_diaria());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Valor Diária Reserva Editada");
		} catch (Exception e) {
			System.out.println("Erro em editar Valor Diária reserva: " + e.getMessage());
		}
	}

	// OPTION 5.3
	public void editarOcupado(Reserva r, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE reserva SET ocupado=? WHERE id_reserva =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setBoolean(1, r.getOcupado());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Reserva Editada - Ocupado");

		} catch (Exception e) {
			System.out.println("Error em editar Ocupado da Reserva: " + e.getMessage());
		}
	}

	// OPTION 6
	public void excluirReserva(int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "DELETE FROM reserva WHERE id_reserva=?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("Reserva Exluída!");

		} catch (Exception e) {
			System.out.println("Erro em Excluir Reserva: " + e.getMessage());
		}
	}
}
