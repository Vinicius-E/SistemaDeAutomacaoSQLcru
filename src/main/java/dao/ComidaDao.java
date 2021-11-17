package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Comida;
import solucoes.Conexao;

public class ComidaDao {
	// OPTION 1
	public void inserir(Comida c) {
		try {
			Conexao conn = new Conexao();

			String sql = "INSERT INTO comida (classe, descricao, fitness, tipo, vlr_kg) VALUES (?,?,?,?,?)";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);

			ps.setString(1, c.getClasse());
			ps.setString(2, c.getDescricao());
			ps.setBoolean(3, c.getFitness());
			ps.setString(4, c.getTipo());
			ps.setDouble(5, c.getVlr_kg());
			ps.execute();

			System.out.println("Comida Inserida");
		} catch (Exception e) {
			System.out.println("Erro em Inserir Comida: " + e.getMessage());
		}
	}

	// OPTION 2
	public List<Comida> buscarTodos() {
		List<Comida> comidas = new ArrayList<>();

		try {
			Conexao conn = new Conexao();

			String sql = "SELECT * FROM comida";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); // LINHA DO DB;

			while (rs.next()) {
				Comida c = new Comida();
				c.setId_comida(rs.getInt("id_comida"));
				c.setClasse(rs.getString("classe"));
				c.setDescricao(rs.getString("descricao"));
				c.setFitness(rs.getBoolean("fitness"));
				c.setTipo(rs.getString("tipo"));
				c.setVlr_kg(rs.getDouble("vlr_kg"));

				comidas.add(c);
			}
		} catch (Exception e) {
			System.out.println("Erro em listar Todas as Comidas : " + e.getMessage());
		}
		return comidas;
	}

	// OPTION 5.1
	public void editarTudo(Comida c, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE comida SET descricao=?, fitness=?, vlr_kg=? WHERE id_comida=?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setString(1, c.getDescricao());
			ps.setBoolean(2, c.getFitness());
			ps.setDouble(3, c.getVlr_kg());
			ps.setInt(4, id);
			ps.executeUpdate();

			System.out.println("Comida Editada tudo");
		} catch (Exception e) {
			System.out.println("Erro em editar Tudo Comida: " + e.getMessage());
		}
	}

	// OPTION 5.2
	public void editarDescricao(Comida c, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE comida SET descricao=? WHERE id_comida =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setString(1, c.getDescricao());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Descrição da Comida Editada");
		} catch (Exception e) {
			System.out.println("Erro em editar Descrição da comida: " + e.getMessage());
		}
	}

	// OPTION 5.3
	public void editarFitness(Comida c, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE comida SET fitness=? WHERE id_comida =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setBoolean(1, c.getFitness());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Fitness da Comida Editada");

		} catch (Exception e) {
			System.out.println("Error em editar Fitness da Comida: " + e.getMessage());
		}
	}

	// OPTION 5.4
	public void editarVlr_kg(Comida c, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE comida SET vlr_kg=? WHERE id_comida =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setDouble(1, c.getVlr_kg());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Valor por KG da Comida Editada");

		} catch (Exception e) {
			System.out.println("Erro em editar Valor por KG da Comida: " + e.getMessage());
		}
	}

	// OPTION 6
	public void excluirComida(int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "DELETE FROM comida WHERE id_comida =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("Comida Exluída!");

		} catch (Exception e) {
			System.out.println("Erro em Excluir Comida: " + e.getMessage());
		}
	}
}
