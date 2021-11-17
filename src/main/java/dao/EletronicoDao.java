package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Eletronico;
import solucoes.Conexao;

public class EletronicoDao {

	// OPTION 1
	public void inserir(Eletronico e) {
		try {
			Conexao conn = new Conexao();

			String sql = "INSERT INTO eletronico(cor, funciona, modelo, valor, tipo) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);

			ps.setString(1, e.getCor());
			ps.setBoolean(2, e.getFunciona());
			ps.setString(3, e.getModelo());
			ps.setDouble(4, e.getValor());
			ps.setString(5, e.getTipo());
			ps.execute();

			System.out.println("Eletrônico Inserido");
		} catch (Exception ex) {
			System.out.println("Erro em Inserir Eletrônico: " + ex.getMessage());
		}
	}

	// OPTION 2
	public List<Eletronico> buscarTodos() {
		List<Eletronico> elets = new ArrayList<>();

		try {
			Conexao conn = new Conexao();

			String sql = "SELECT * FROM eletronico";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); // LINHA DO DB;

			while (rs.next()) {
				Eletronico e = new Eletronico();
				e.setId_elet(rs.getInt("id_elet"));
				e.setCor(rs.getString("cor"));
				e.setFunciona(rs.getBoolean("funciona"));
				e.setModelo(rs.getString("modelo"));
				e.setValor(rs.getDouble("valor"));
				e.setTipo(rs.getString("tipo"));
		
				elets.add(e);
			}
		} catch (Exception e) {
			System.out.println("Erro em listar Eletrônicos: " + e.getMessage());
		}
		return elets;
	}

	// OPTION 5.1
	public void editarTudo(Eletronico e, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE eletronico SET funciona=?, valor=? WHERE id_elet =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setBoolean(1, e.getFunciona());
			ps.setDouble(2, e.getValor());
			ps.setInt(3, id);
			ps.executeUpdate();

			System.out.println("Tudo Eletrônico Editado");
		} catch (Exception ex) {
			System.out.println("Erro em editar Tudo do eletrônico: " + ex.getMessage());
		}
	}

	// OPTION 5.2
	public void editarFunciona(Eletronico e, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE eletronico SET funciona=? WHERE id_elet =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setBoolean(1, e.getFunciona());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Eletrônico Funciona Editado");
		} catch (Exception ex) {
			System.out.println("Erro em editar Funciona do eletrônico: " + ex.getMessage());
		}
	}

	// OPTION 5.3
	public void editarValor(Eletronico e, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE eletronico SET valor=? WHERE id_elet=?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setDouble(1, e.getValor());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Valor do Eletrônico Editado");
		} catch (Exception ex) {
			System.out.println("Erro em editar Valor do eletrônico: " + ex.getMessage());
		}
	}

	// OPTION 6
	public void excluirEletronico(int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "DELETE FROM eletronico WHERE id_elet=?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("Eletrônico Exluído!");

		} catch (Exception e) {
			System.out.println("Erro em Excluir Eletrônico: " + e.getMessage());
		}
	}
}
