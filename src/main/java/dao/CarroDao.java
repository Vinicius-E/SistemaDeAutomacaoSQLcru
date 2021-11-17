package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Carro;
import solucoes.Conexao;

public class CarroDao {
	// OPTION 1
	public void inserir(Carro c) {
		try {
			Conexao conn = new Conexao();

			String sql = "INSERT INTO carro (ano, cor, modelo, placa, vlr_fipe) VALUES (?,?,?,?,?)";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);

			ps.setInt(1, c.getAno());
			ps.setString(2, c.getCor());
			ps.setString(3, c.getModelo());
			ps.setString(4, c.getPlaca());
			ps.setDouble(5, c.getVlr_fipe());
			ps.execute();

			System.out.println("Carro Inserido");
		} catch (Exception e) {
			System.out.println("Erro em Inserir Carro: " + e.getMessage());
		}
	}

	// OPTION 2
	public List<Carro> buscarTodos() {
		List<Carro> carros = new ArrayList<>();

		try {
			Conexao conn = new Conexao();

			String sql = "SELECT * FROM carro";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); // LINHA DO DB;

			while (rs.next()) {
				Carro c = new Carro();
				c.setId_carro(rs.getInt("id_carro"));
				c.setAno(rs.getInt("ano"));
				c.setCor(rs.getString("cor"));
				c.setModelo(rs.getString("modelo"));
				c.setPlaca(rs.getString("placa"));
				c.setVlr_fipe(rs.getDouble("vlr_fipe"));
				
				carros.add(c);
			}
		} catch (Exception e) {
			System.out.println("Erro em listar todos os Carros : " + e.getMessage());
		}
		return carros;
	}

	// OPTION 5.1
	public void editarTudo(Carro c, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE carro SET cor=?, placa=?, vlr_fipe=? WHERE id_carro=?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setString(1, c.getCor());
			ps.setString(2, c.getPlaca());
			ps.setDouble(3, c.getVlr_fipe());
			ps.setInt(4, id);
			ps.executeUpdate();

			System.out.println("Carro Editado tudo");
		} catch (Exception e) {
			System.out.println("Erro em editar Tudo do Carro: " + e.getMessage());
		}
	}

	// OPTION 5.2
	public void editarCor(Carro c, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE carro SET cor=? WHERE id_carro =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setString(1, c.getCor());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Cor do Carro Editado");
		} catch (Exception e) {
			System.out.println("Erro em editar Cor do carro: " + e.getMessage());
		}
	}

	// OPTION 5.3
	public void editarPlaca(Carro c, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE carro SET placa=? WHERE id_carro =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setString(1, c.getPlaca());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Placa do Carro Editada");

		} catch (Exception e) {
			System.out.println("Error em editar a Placa do Carro: " + e.getMessage());
		}
	}

	// OPTION 5.4
	public void editarVlr_fip(Carro c, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE carro SET vlr_fipe=? WHERE id_carro =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setDouble(1, c.getVlr_fipe());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Preço Tabela-Fipe do Carro Editado");

		} catch (Exception e) {
			System.out.println("Erro em editar o Preço Tabela-Fipe do Carro: " + e.getMessage());
		}
	}

	// OPTION 6
	public void excluirCarro(int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "DELETE FROM carro WHERE id_carro =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("Carro Exluído!");

		} catch (Exception e) {
			System.out.println("Erro em Excluir Carro: " + e.getMessage());
		}
	}
}
