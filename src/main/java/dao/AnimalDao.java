package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Animal;
import solucoes.Conexao;

public class AnimalDao {

	// OPTION 1
	public void inserir(Animal a) {
		try {
			Conexao conn = new Conexao();

			String sql = "INSERT INTO animal(classe, especie, extincao, natureza, peso, raca) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);

			ps.setString(1, a.getClasse());
			ps.setString(2, a.getEspecie());
			ps.setBoolean(3, a.getExtincao());
			ps.setBoolean(4, a.getNatureza());
			ps.setDouble(5, a.getPeso());
			ps.setString(6, a.getRaca());
			ps.execute();

			System.out.println("Animal Inserido");
		} catch (Exception e) {
			System.out.println("Erro em Inserir Animal: " + e.getMessage());
		}
	}

	// OPTION 2
	public List<Animal> buscarTodos() {
		List<Animal> animais = new ArrayList<>();

		try {
			Conexao conn = new Conexao();

			String sql = "SELECT * FROM animal";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); // LINHA DO DB;

			while (rs.next()) {
				Animal a = new Animal();
				a.setId_animal(rs.getInt("id_animal"));
				a.setClasse(rs.getString("classe"));
				a.setEspecie(rs.getString("especie"));
				a.setExtincao(rs.getBoolean("extincao"));
				a.setNatureza(rs.getBoolean("natureza"));
				a.setPeso(rs.getDouble("peso"));
				a.setRaca(rs.getString("raca"));

				animais.add(a);
			}
		} catch (Exception e) {
			System.out.println("Error to list products: " + e.getMessage());
		}
		return animais;
	}

	// OPTION 5.1
	public void editarTudo(Animal a, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE animal SET extincao=?, natureza=?, peso=? WHERE id_animal =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setBoolean(1, a.getExtincao());
			ps.setBoolean(2, a.getNatureza());
			ps.setDouble(3, a.getPeso());
			ps.setInt(4, id);
			ps.executeUpdate();

			System.out.println("Tudo Animal Editado");
		} catch (Exception e) {
			System.out.println("Erro em editar Tudo do animal: " + e.getMessage());
		}
	}

	// OPTION 5.2
	public void editarExtincao(Animal a, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE animal SET extincao=? WHERE id_animal =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setBoolean(1, a.getExtincao());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Extinção Animal Editado");
		} catch (Exception e) {
			System.out.println("Erro em editar Extinção do animal: " + e.getMessage());
		}
	}

	// OPTION 5.3
	public void editarNatureza(Animal a, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE animal SET natureza=? WHERE id_animal =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setBoolean(1, a.getNatureza());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Natureza do Animal Editada");

		} catch (Exception e) {
			System.out.println("Error in edit price of product: " + e.getMessage());
		}
	}

	// OPTION 5.4
	public void editarPeso(Animal a, int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "UPDATE animal SET peso=? WHERE id_animal =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setDouble(1, a.getPeso());
			ps.setInt(2, id);
			ps.executeUpdate();

			System.out.println("Peso do Animal Editado");

		} catch (Exception e) {
			System.out.println("Erro em editar o Peso do Animal: " + e.getMessage());
		}
	}

	// OPTION 6
	public void excluirAnimal(int id) {
		try {
			Conexao conn = new Conexao();

			String sql = "DELETE FROM animal WHERE id_animal =?";

			PreparedStatement ps = conn.getConexao().prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("Animal Exluído!");

		} catch (Exception e) {
			System.out.println("Erro em Excluir Animal: " + e.getMessage());
		}
	}
}
