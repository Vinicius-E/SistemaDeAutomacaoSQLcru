package solucoes;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private final String SERVIDOR = "localhost";
	private final String PORTA = "3306";
	private final String NOME_DB = "exe_07";
	private final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + NOME_DB;
	
	private final String USUARIO = "root";
	private final String SENHA = "Vini13lagoa$";
	
	private Connection c;
	
	//CONSTRUTOR
	public Conexao() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		c = DriverManager.getConnection(URL, USUARIO, SENHA);
		c.setAutoCommit(true);
	}
	
	public Connection getConexao() {
		return c;
	}
}
