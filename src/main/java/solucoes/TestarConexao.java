package solucoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.AnimalDao;
import dao.CarroDao;
import dao.ComidaDao;
import dao.EletronicoDao;
import dao.ReservaDao;
import modelo.Animal;
import modelo.Carro;
import modelo.Comida;
import modelo.Eletronico;
import modelo.Reserva;

public class TestarConexao {

	public static Scanner sc = new Scanner(System.in);

	// <<< TESTAR CONEXÃO >>>
	public static void testar() {
		try {
			Conexao c = new Conexao();
			c.getConexao();
			System.out.println("Login Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// <<< INFORME ID METÓDO AUXILIAR >>>
	public static int infoId() {
		System.out.print("Informe o ID desejado: ");
		int id = sc.nextInt();
		sc.nextLine();
		return id;
	}

	/// <<< TESTAR CONEXÃO ANIMAL COMEÇO >>>

	// <<< OPTION 1 >>>
	public static void inserirAnimal() {
		System.out.print("Quantos animais deseja inserir? ");
		int a_qtd = sc.nextInt();
		sc.nextLine();
		Boolean extincao = false;
		Boolean natureza = false;
		int cont = 0;

		for (int i = 1; i <= a_qtd; i++) {
			System.out.print("Classe Animal " + i + ": ");
			String classe = sc.nextLine();
			System.out.print("Espécie Animal " + i + ": ");
			String especie = sc.nextLine();
			System.out.print("Animal " + i + " está em Extinção? (S-sim/N-não) ");
			String r1 = sc.nextLine();
			Character c1 = r1.toUpperCase().charAt(0);
			System.out.print("Animal " + i + " está na Natureza? (S-sim/N-não) ");
			String r2 = sc.nextLine();
			Character c2 = r2.toUpperCase().charAt(0);
			System.out.print("Raça Animal " + i + ": ");
			String raca = sc.nextLine();
			System.out.print("Peso Animal " + i + ": ");
			Double peso = sc.nextDouble();
			sc.nextLine();

			if (c1 == 'S')
				extincao = true;

			if (c2 == 'S')
				natureza = true;

			Animal a = new Animal(classe, especie, extincao, natureza, peso, raca);

			AnimalDao a_dao = new AnimalDao();
			a_dao.inserir(a);
			System.out.println();
			cont++;
		}
		System.out.println("Funcionou! " + cont + " Animais Cadastrado(s)");
	}

	// <<< OPTION 2 >>>
	public static void buscarTodosAnimais(List<Animal> animais) {
		List<Animal> a_list = new ArrayList<>();

		AnimalDao dao = new AnimalDao();

		a_list = dao.buscarTodos();

		for (int i = 0; i < a_list.size(); i++) {
			System.out.println(animais.get(i).toString());
		}
	}

	// <<< OPTION 3 >>>
	public static void filtrarAnimalPorId(List<Animal> animais, int id) {
		for (int i = 0; i < animais.size(); i++) {
			if (animais.get(i).getId_animal() == id) {
				System.out.println(animais.get(i).toString());
			}
		}
	}

	// <<< OPTION 4 >>>
	public static void filtrarAnimalPorCaracteres(List<Animal> animais) {
		System.out.println("Opção escolhida - Filtrar por Caracteres.");
		System.out.println("(1) - Classe do Animal");
		System.out.println("(2) - Espécie do Animal");
		System.out.println("(3) - Raça do Animal");
		System.out.print("Você deseja fitrar por: (1/2/3) ");
		char c = sc.nextLine().charAt(0);
		System.out.print("Digite o(s) caracter(es) desejado(s) para o filtro: ");
		String s = sc.nextLine();

		switch (c) {
		case '1':
			// <<< CLASSE >>>
			for (int i = 0; i < animais.size(); i++) {
				if (animais.get(i).getClasse().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(animais.get(i).toString());
					System.out.println();
				}
			}
			break;
		case '2':
			// <<< ESPECIE >>>
			for (int i = 0; i < animais.size(); i++) {
				if (animais.get(i).getEspecie().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(animais.get(i).toString());
					System.out.println();
				}
			}
			break;
		case '3':
			// <<< RAÇA >>>
			for (int i = 0; i < animais.size(); i++) {
				if (animais.get(i).getRaca().toUpperCase().contains(s.toUpperCase())) {
					// if(animais.get(i).getNome().equalsIgnoreCase(s)) {
					System.out.println(animais.get(i).toString());
					System.out.println();
				}
			}
			break;
		default:
			System.out.println("ERRO EM ESCOLHER FILTRO! APENAS (1/2/3)");
			break;
		}
	}

	// <<< OPTION 5 >>>
	public static void editarAnimal(List<Animal> animais) {
		Animal a = new Animal();

		AnimalDao dao = new AnimalDao();

		System.out.println("<<< ANIMAIS CADASTRADOS NO SISTEMA >>>");
		int id = infoId();
		filtrarAnimalPorId(animais, id);

		Boolean continuar = true;
		while (continuar) {
			System.out.println("<<< OPÇÕES >>>");
			System.out.println("(1) - Editar Tudo");
			System.out.println("(2) - Editar Extinção");
			System.out.println("(3) - Editar Natureza");
			System.out.println("(4) - Editar Raça");
			System.out.print("Selecione uma opção para alterar o Animal: (1/2/3/4) ");

			Boolean extincao = false;
			Boolean natureza = false;
			Character opcao = sc.nextLine().charAt(0);
			switch (opcao) {
			case '1':
				System.out.print("O animal está em Extinção? (S-sim/N-não) ");
				String resposta = sc.nextLine();
				char c = resposta.toUpperCase().charAt(0);
				System.out.print("O animal está na Natureza? (S-sim/N-não) ");
				String resposta1 = sc.nextLine();
				char c1 = resposta1.toUpperCase().charAt(0);
				System.out.print("Novo peso do animal: ");
				Double peso = sc.nextDouble();
				sc.nextLine();

				if (c == 'S')
					extincao = true;
				if (c1 == 'S')
					natureza = true;

				a.setExtincao(extincao);
				a.setNatureza(natureza);
				a.setPeso(peso);

				dao.editarTudo(a, id);
				break;
			case '2':
				System.out.print("O animal está em Extinção? (S-sim/N-não) ");
				String resposta2 = sc.nextLine();
				char c2 = resposta2.toUpperCase().charAt(0);

				if (c2 == 'S')
					extincao = true;

				a.setExtincao(extincao);

				dao.editarExtincao(a, id);
				break;
			case '3':
				System.out.print("O animal está na Natureza? (S-sim/N-não) ");
				String resposta3 = sc.nextLine();
				char c3 = resposta3.toUpperCase().charAt(0);

				if (c3 == 'S')
					natureza = true;

				a.setNatureza(natureza);
				dao.editarNatureza(a, id);
				break;
			case '4':
				System.out.print("Novo peso do animal: ");
				Double peso1 = sc.nextDouble();
				sc.nextLine();
				a.setPeso(peso1);

				dao.editarPeso(a, id);
				break;
			default:
				System.out.println("Opção escolhida inválida!");
				// GOTO ...
				break;
			}

			System.out.print("Quer editar outro dado do Animal? (S-sim/N-não) ");
			String s1 = sc.nextLine();
			String s1Upper = s1.toUpperCase();
			Character resposta = s1Upper.charAt(0);
			if (resposta == 'N') {
				continuar = false;
			}
		}
	}

	// <<< OPTION 6 >>>
	public static void excluirAnimal(List<Animal> animais, int id) {
		filtrarAnimalPorId(animais, id);
		System.out.print("Quer mesmo excluir esse Animal: (S-sim/N-não) ");
		String s1 = sc.nextLine();
		String s1Upper = s1.toUpperCase();
		Character resposta = s1Upper.charAt(0);
		if (resposta == 'S') {
			AnimalDao dao = new AnimalDao();
			dao.excluirAnimal(id);
		}
	}

	/// <<< TESTAR CONEXÃO ANIMAL FINAL >>>
	
	/// <<< TESTAR CONEXÃO CARRO COMEÇO >>>
	
	public static void inserirCarro() {
		System.out.print("Quantos carros deseja inserir? ");
		int c_qtd = sc.nextInt();
		sc.nextLine();
		int cont = 0;

		for (int i = 1; i <= c_qtd; i++) {
			System.out.print("Ano Carro " + i + ": ");
			Integer ano = sc.nextInt();
			sc.nextLine();
			System.out.print("Cor Carro " + i + ": ");
			String cor = sc.nextLine();
			System.out.print("Carro " + i + " modelo: ");
			String modelo = sc.nextLine();
			System.out.print("Placa Carro " + i + ": ");
			String placa = sc.nextLine();
			System.out.print("Preço Carro " + i + " na tabela fipe: R$ ");
			Double vlr_fipe = sc.nextDouble();
			sc.nextLine();

			Carro c = new Carro(ano, cor, modelo, placa, vlr_fipe);

			CarroDao c_dao = new CarroDao();
			c_dao.inserir(c);
			System.out.println();
			cont++;
		}
		System.out.println("Funcionou! " + cont + " Carro(s) Cadastrado(s)");
	}

// <<< OPTION 2 >>>
	public static void buscarTodosCarros(List<Carro> carros) {
		List<Carro> c_list = new ArrayList<>();

		CarroDao dao = new CarroDao();

		c_list = dao.buscarTodos();

		for (int i = 0; i < c_list.size(); i++) {
			System.out.println(carros.get(i).toString());
		}
	}

	// <<< OPTION 3 >>>
	// <<< OPTION 3 >>>

	public static void filtrarCarroPorId(List<Carro> carros, int id) {
		for (int i = 0; i < carros.size(); i++) {
			if (carros.get(i).getId_carro() == id) {
				System.out.println(carros.get(i).toString());
			}
		}
	}

	// <<< OPTION 4 >>>
	// <<< OPTION 4 >>>

	public static void filtrarCarroPorCaracteres(List<Carro> carros) {
		System.out.println("Opção escolhida - Filtrar por Caracteres.");
		System.out.println("(1) - Cor do Carro");
		System.out.println("(2) - Modelo do Carro");
		System.out.println("(3) - Placa do Carro");
		System.out.print("Você deseja fitrar por: (1/2/3) ");
		char c = sc.nextLine().charAt(0);
		System.out.print("Digite o(s) caracter(es) desejado(s) para o filtro: ");
		String s = sc.nextLine();

		switch (c) {
		case '1':
			// <<< COR >>>
			for (int i = 0; i < carros.size(); i++) {
				if (carros.get(i).getCor().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(carros.get(i).toString());
					System.out.println();
				}
			}
			break;
		case '2':
			// <<< MODELO>>>
			for (int i = 0; i < carros.size(); i++) {
				if (carros.get(i).getModelo().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(carros.get(i).toString());
					System.out.println();
				}
			}
			break;
		case '3':
			// <<< PLACA >>>
			for (int i = 0; i < carros.size(); i++) {
				if (carros.get(i).getPlaca().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(carros.get(i).toString());
					System.out.println();
				}
			}
			break;
		default:
			System.out.println("ERRO EM ESCOLHER FILTRO! APENAS (1/2/3)");
			break;
		}
	}

	// <<< OPTION 5 >>>
	// <<< OPTION 5 >>>

	public static void editarCarro(List<Carro> carros) {
		Carro c = new Carro();

		CarroDao dao = new CarroDao();

		System.out.println("<<< CARROS CADASTRADOS NO SISTEMA >>>");
		int id = infoId();
		filtrarCarroPorId(carros, id);

		Boolean continuar = true;
		while (continuar) {
			System.out.println("<<< OPÇÕES >>>");
			System.out.println("(1) - Editar Tudo");
			System.out.println("(2) - Editar Cor");
			System.out.println("(3) - Editar Placa");
			System.out.println("(4) - Editar Valor Tabela Fipe");
			System.out.print("Selecione uma opção para alterar o Carro: (1/2/3/4) ");

			Character opcao = sc.nextLine().charAt(0);
			switch (opcao) {
			case '1':
				System.out.print("Nova cor do Carro: ");
				String n_cor = sc.nextLine();
				System.out.print("Nova placa do Carro: ");
				String n_placa = sc.nextLine();
				System.out.print("Novo valor do Carro na tabela fipe: R$ ");
				Double n_vlr = sc.nextDouble();
				sc.nextLine();

				c.setCor(n_cor);
				c.setPlaca(n_placa);
				c.setVlr_fipe(n_vlr);

				dao.editarTudo(c, id);
				break;
			case '2':
				System.out.print("Nova cor do Carro: ");
				String n1_cor = sc.nextLine();

				c.setCor(n1_cor);

				dao.editarCor(c, id);
				break;
			case '3':
				System.out.print("Nova placa do Carro: ");
				String n1_placa = sc.nextLine();

				c.setPlaca(n1_placa);

				dao.editarPlaca(c, id);
				break;
			case '4':
				System.out.print("Novo valor do Carro na tabela fipe: R$ ");
				Double n1_vlr = sc.nextDouble();
				sc.nextLine();

				c.setVlr_fipe(n1_vlr);

				dao.editarVlr_fip(c, id);
				break;
			default:
				System.out.println("Opção escolhida inválida!");
				// GOTO ...
				break;
			}

			System.out.print("Quer editar outro dado do Carro? (S-sim/N-não) ");
			String s1 = sc.nextLine();
			String s1Upper = s1.toUpperCase();
			Character resposta = s1Upper.charAt(0);
			if (resposta == 'N') {
				continuar = false;
			}
		}
	}

	// <<< OPTION 6 >>>
	// <<< OPTION 6 >>>

	public static void excluirCarro(List<Carro> carros, int id) {
		filtrarCarroPorId(carros, id);
		System.out.print("Quer mesmo excluir esse Carro: (S-sim/N-não) ");
		String s1 = sc.nextLine();
		String s1Upper = s1.toUpperCase();
		Character resposta = s1Upper.charAt(0);
		if (resposta == 'S') {
			CarroDao dao = new CarroDao();
			dao.excluirCarro(id);
		}
	}

	/// <<< TESTAR CONEXÃO CARRO FINAL >>>

	/// <<< TESTAR CONEXÃO COMIDA COMEÇO >>>

	// <<< OPTION 1 >>>

	/// <<< TESTAR CONEXÃO CARRO FINAL >>>

	/// <<< TESTAR CONEXÃO COMIDA COMEÇO >>>

	// <<< OPTION 1 >>>
	public static void inserirComida() {
		System.out.print("Quantos comidas deseja inserir? ");
		int c_qtd = sc.nextInt();
		sc.nextLine();
		int cont = 0;
		Boolean fitness = false;

		for (int i = 1; i <= c_qtd; i++) {
			System.out.print("Classe Comida " + i + ": ");
			String classe = sc.nextLine();
			System.out.print("Descrição Comida " + i + ": ");
			String descricao = sc.nextLine();
			System.out.print("A Comida " + i + " é fitness? (S-sim/N-não) ");
			String resposta1 = sc.nextLine();
			Character c1 = resposta1.toUpperCase().charAt(0);
			System.out.print("Informe o tipo da Comida " + i + ": ");
			String tipo = sc.nextLine();
			System.out.print("Preço Comida " + i + ": R$ ");
			Double preco = sc.nextDouble();
			sc.nextLine();

			if (c1 == 'S') {
				fitness = true;
			}

			Comida c = new Comida(classe, descricao, fitness, tipo, preco);

			ComidaDao c_dao = new ComidaDao();
			c_dao.inserir(c);
			System.out.println();
			cont++;
		}
		System.out.println("Funcionou! " + cont + " Comida(s) Cadastrado(s)");
	}

	// <<< OPTION 2 >>>
	// <<< OPTION 2 >>>

	/// <<< TESTAR CONEXÃO CARRO FINAL >>>
	
	/// <<< TESTAR CONEXÃO COMIDA COMEÇO >>>
	
	public static void buscarTodosComidas(List<Comida> comidas) {
		List<Comida> c_list = new ArrayList<>();

		ComidaDao dao = new ComidaDao();

		c_list = dao.buscarTodos();

		for (int i = 0; i < c_list.size(); i++) {
			System.out.println(comidas.get(i).toString());
		}
	}

	// <<< OPTION 3 >>>

	// <<< OPTION 3 >>>
	
	public static void filtrarComidaPorId(List<Comida> comidas, int id) {
		for (int i = 0; i < comidas.size(); i++) {
			if (comidas.get(i).getId_comida() == id) {
				System.out.println(comidas.get(i).toString());
			}
		}
	}

	// <<< OPTION 4 >>>
	// <<< OPTION 4 >>>

	public static void filtrarComidaPorCaracteres(List<Comida> comidas) {
		System.out.println("Opção escolhida - Filtrar por Caracteres.");
		System.out.println("(1) - Classe da Comida");
		System.out.println("(2) - Descrição da Comida");
		System.out.println("(3) - Tipo Comida");
		System.out.print("Você deseja fitrar por: (1/2/3) ");
		char c = sc.nextLine().charAt(0);
		System.out.print("Digite o(s) caracter(es) desejado(s) para o filtro: ");
		String s = sc.nextLine();

		switch (c) {
		case '1':
			// <<< CLASSE >>>
			for (int i = 0; i < comidas.size(); i++) {
				if (comidas.get(i).getClasse().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(comidas.get(i).toString());
					System.out.println();
				}
			}
			break;
		case '2':
			// <<< DESCRICAO >>>
			for (int i = 0; i < comidas.size(); i++) {
				if (comidas.get(i).getDescricao().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(comidas.get(i).toString());
					System.out.println();
				}
			}
			break;
		case '3':
			// <<< TIPO >>>
			for (int i = 0; i < comidas.size(); i++) {
				if (comidas.get(i).getTipo().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(comidas.get(i).toString());
					System.out.println();
				}
			}
			break;
		default:
			System.out.println("ERRO EM ESCOLHER FILTRO! APENAS (1/2/3)");
			break;
		}
	}

	// <<< OPTION 5 >>>
	// <<< OPTION 5 >>>

	public static void editarComida(List<Comida> comidas) {
		Comida c = new Comida();

		ComidaDao dao = new ComidaDao();

		System.out.println("<<< COMIDAS CADASTRADOS NO SISTEMA >>>");
		int id = infoId();
		filtrarComidaPorId(comidas, id);

		Boolean continuar = true;
		while (continuar) {
			System.out.println("<<< OPÇÕES >>>");
			System.out.println("(1) - Editar Descrição");
			System.out.println("(2) - Editar Fitness");
			System.out.println("(3) - Editar Valor por KG");
			System.out.println("(4) - Editar Tudo");
			System.out.print("Selecione uma opção para alterar a Comida: (1/2/3/4) ");

			Boolean fitness = false;
			Character opcao = sc.nextLine().charAt(0);
			switch (opcao) {
			case '1':
				System.out.print("Nova Descrição da Comida: ");
				String n_descri1 = sc.nextLine();

				c.setDescricao(n_descri1);

				dao.editarDescricao(c, id);
				break;
			case '2':
				System.out.print("A Comida é Fitness? (S-sim/N-não) ");
				String reposta2 = sc.nextLine();
				Character c2 = reposta2.toUpperCase().charAt(0);

				if (c2 == 'S') {
					fitness = true;
				}

				c.setFitness(fitness);

				dao.editarFitness(c, id);
				break;
			case '3':
				System.out.print("Novo Valor por KG: R$ ");
				Double n_vlr3 = sc.nextDouble();
				sc.nextLine();

				c.setVlr_kg(n_vlr3);

				dao.editarVlr_kg(c, id);
				break;
			case '4':
				System.out.print("Nova Descrição da Comida: ");
				String n_descri4 = sc.nextLine();
				System.out.print("A Comida é Fitness? (S-sim/N-não) ");
				String reposta4 = sc.nextLine();
				Character c4 = reposta4.toUpperCase().charAt(0);
				System.out.print("Novo Valor por KG: R$ ");
				Double n_vlr4 = sc.nextDouble();
				sc.nextLine();

				if (c4 == 'S') {
					fitness = true;
				}

				c.setDescricao(n_descri4);
				c.setFitness(fitness);
				c.setVlr_kg(n_vlr4);

				dao.editarTudo(c, id);
				break;
			default:
				System.out.println("Opção escolhida inválida!");
				// GOTO ...
				break;
			}

			System.out.print("Quer editar outro dado do Comida? (S-sim/N-não) ");
			String s1 = sc.nextLine();
			String s1Upper = s1.toUpperCase();
			Character resposta = s1Upper.charAt(0);
			if (resposta == 'N') {
				continuar = false;
			}
		}
	}

	// <<< OPTION 6 >>>

	// <<< OPTION 6 >>>

	public static void excluirComida(List<Comida> comidas, int id) {
		filtrarComidaPorId(comidas, id);
		System.out.print("Quer mesmo excluir essa Comida: (S-sim/N-não) ");
		String s1 = sc.nextLine();
		String s1Upper = s1.toUpperCase();
		Character resposta = s1Upper.charAt(0);
		if (resposta == 'S') {
			ComidaDao dao = new ComidaDao();
			dao.excluirComida(id);
		}
	}

	/// <<< TESTAR CONEXÃO COMDA FINAL >>>

	/// <<< TESTAR CONEXÃO ELETRÔNICO COMEÇO >>>

	// <<< OPTION 1 >>>

	/// <<< TESTAR CONEXÃO COMIDA FINAL >>>

	/// <<< TESTAR CONEXÃO ELETRÔNICO COMEÇO >>>

	// <<< OPTION 1 >>>
	public static void inserirEletronico() {
		System.out.print("Quantos eletrônicos deseja inserir? ");
		int e_qtd = sc.nextInt();
		sc.nextLine();
		int cont = 0;
		Boolean funciona = false;

		for (int i = 1; i <= e_qtd; i++) {
			System.out.print("Cor Eletrônico " + i + ": ");
			String cor = sc.nextLine();
			System.out.print("Eletrônico " + i + " está funcionando? (S-sim/N-não) ");
			String resposta1 = sc.nextLine();
			Character c = resposta1.toUpperCase().charAt(0);
			System.out.print("Modelo do Eletrônico " + i + ": ");
			String modelo = sc.nextLine();
			System.out.print("Tipo do Eletrônico " + i + ": ");
			String tipo = sc.nextLine();
			System.out.print("Preço Eletrônico " + i + ": R$ ");
			Double preco = sc.nextDouble();
			sc.nextLine();

			if (c == 'S') {
				funciona = true;
			}

			Eletronico e = new Eletronico(cor, funciona, modelo, preco, tipo);

			EletronicoDao e_dao = new EletronicoDao();
			e_dao.inserir(e);
			System.out.println();
			cont++;
		}
		System.out.println("Funcionou! " + cont + " Eletronico(s) Inserido(s)");
	}

	// <<< OPTION 2 >>>
	// <<< OPTION 2 >>>

	/// <<< TESTAR CONEXÃO COMIDA FINAL >>>
	
	/// <<< TESTAR CONEXÃO ELETRÔNICOS COMEÇO >>>
		
	public static void buscarTodosEletronicos(List<Eletronico> reservas) {
		List<Eletronico> e_list = new ArrayList<>();

		EletronicoDao dao = new EletronicoDao();

		e_list = dao.buscarTodos();

		for (int i = 0; i < e_list.size(); i++) {
			System.out.println(reservas.get(i).toString());
		}
	}

	// <<< OPTION 3 >>>

	// <<< OPTION 3 >>>

	public static void filtrarEletronicoPorId(List<Eletronico> reservas, int id) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getId_elet() == id) {
				System.out.println(reservas.get(i).toString());
			}
		}
	}

	// <<< OPTION 4 >>>
	// <<< OPTION 4 >>>

	public static void filtrarEletronicoPorCaracteres(List<Eletronico> reservas) {
		System.out.println("Opção escolhida - Filtrar por Caracteres.");
		System.out.println("(1) - Cor do Eletrônico");
		System.out.println("(2) - Modelo do Eletrônico");
		System.out.println("(3) - Tipo Eletrônico");
		System.out.print("Você deseja fitrar por: (1/2/3) ");
		char c = sc.nextLine().charAt(0);
		System.out.print("Digite o(s) caracter(es) desejado(s) para o filtro: ");
		String s = sc.nextLine();

		switch (c) {
		case '1':
			// <<< COR >>>
			for (int i = 0; i < reservas.size(); i++) {
				if (reservas.get(i).getCor().toUpperCase().contains(s.toUpperCase())) {
					// if(animais.get(i).getNome().equalsIgnoreCase(s)) {
					System.out.println(reservas.get(i).toString());
					System.out.println();
				}
			}
			break;
		case '2':
			// <<< MODELO >>>
			for (int i = 0; i < reservas.size(); i++) {
				if (reservas.get(i).getModelo().toUpperCase().contains(s.toUpperCase())) {
					// if(animais.get(i).getNome().equalsIgnoreCase(s)) {
					System.out.println(reservas.get(i).toString());
					System.out.println();
				}
			}
			break;
		case '3':
			// <<< TIPO >>>
			for (int i = 0; i < reservas.size(); i++) {
				if (reservas.get(i).getTipo().toUpperCase().contains(s.toUpperCase())) {
					// if(animais.get(i).getNome().equalsIgnoreCase(s)) {
					System.out.println(reservas.get(i).toString());
					System.out.println();
				}
			}
			break;
		default:
			System.out.println("ERRO EM ESCOLHER FILTRO! APENAS (1/2/3)");
			break;
		}
	}

	// <<< OPTION 5 >>>

	// <<< OPTION 5 >>>

	public static void editarEletronico(List<Eletronico> reservas) {
		Eletronico e = new Eletronico();

		EletronicoDao dao = new EletronicoDao();

		System.out.println("<<< ELETRÔNICOS CADASTRADOS NO SISTEMA >>>");
		int id = infoId();
		filtrarEletronicoPorId(reservas, id);

		Boolean continuar = true;
		while (continuar) {
			System.out.println("<<< OPÇÕES >>>");
			System.out.println("(1) - Editar Tudo");
			System.out.println("(2) - Editar Funciona");
			System.out.println("(3) - Editar Valor");
			System.out.print("Selecione uma opção para alterar o Eletrônico: (1/2/3) ");

			Boolean funciona = false;
			Character opcao = sc.nextLine().charAt(0);
			switch (opcao) {
			case '1':
				System.out.print("O Eletrônico está Funcionando? (S-sim/N-não) ");
				String reposta1 = sc.nextLine();
				Character c1 = reposta1.toUpperCase().charAt(0);
				System.out.print("Novo Preço do Eletrônico: R$ ");
				Double n_vlr1 = sc.nextDouble();
				sc.nextLine();

				if (c1 == 'S') {
					funciona = true;
				}

				e.setFunciona(funciona);
				e.setValor(n_vlr1);

				dao.editarTudo(e, id);
				break;
			/// PRECISO ARRUMAR NÃO ESTÁ ALTERANDO!
			case '2':
				System.out.print("O Eletrônico está Funcionando? (S-sim/N-não) ");
				String reposta2 = sc.nextLine();
				Character c2 = reposta2.toUpperCase().charAt(0);

				if (c2 == 'S') {
					funciona = true;
				}

				e.setFunciona(funciona);

				dao.editarFunciona(e, id);
				break;
			/// PRECISO ARRUMAR NÃO ESTÁ ALTERANDO!
			case '3':
				System.out.print("Novo Preço do Eletrônico: R$ ");
				Double n_vlr3 = sc.nextDouble();
				sc.nextLine();

				e.setValor(n_vlr3);

				dao.editarValor(e, id);
				break;
			default:
				System.out.println("Opção escolhida inválida!");
				// GOTO ...
				break;
			}

			System.out.print("Quer editar outro dado do Eletrônico? (S-sim/N-não) ");
			String s1 = sc.nextLine();
			String s1Upper = s1.toUpperCase();
			Character resposta = s1Upper.charAt(0);
			if (resposta == 'N') {
				continuar = false;
			}
		}
	}
	// <<< OPTION 6 >>>
	public static void excluirEletronico(List<Eletronico> reservas, int id) {
		filtrarEletronicoPorId(reservas, id);
		System.out.print("Quer mesmo excluir esse Eletrônico: (S-sim/N-não) ");
		String s1 = sc.nextLine();
		String s1Upper = s1.toUpperCase();
		Character resposta = s1Upper.charAt(0);
		if (resposta == 'S') {
			EletronicoDao dao = new EletronicoDao();
			dao.excluirEletronico(id);
		}
	}

	/// <<< TESTAR CONEXÃO ELETRÔNICO FINAL >>>

	/// <<< TESTAR CONEXÃO RESERVA COMEÇO >>>

	// <<< OPTION 1 >>>

	/// <<< TESTAR CONEXÃO ELETRÔNICO FINAL >>>

	/// <<< TESTAR CONEXÃO RESERVA COMEÇO >>>

	// <<< OPTION 1 >>>
	public static void inserirReserva() {
		System.out.print("Quantas reservas desejas inserir? ");
		int e_qtd = sc.nextInt();
		sc.nextLine();
		int cont = 0;
		Boolean ocupado = false;

		for (int i = 1; i <= e_qtd; i++) {
			System.out.print("Cidade Reserva " + i + ": ");
			String cidade = sc.nextLine();
			System.out.print("Reserva " + i + " Valor diária: R$ ");
			Double vlr_diaria = sc.nextDouble();
			System.out.print("Número Local Reserva " + i + ": ");
			Integer nmr = sc.nextInt();
			sc.nextLine();
			System.out.print("O local " + i + " está Ocupado? (S-sim/N-não) ");
			String resposta6 = sc.nextLine();
			Character c6 = resposta6.toUpperCase().charAt(0);
			System.out.print("Rua Reserva " + i + ": ");
			String rua = sc.nextLine();

			if (c6 == 'S')
				ocupado = true;
			else
				ocupado = false;

			Reserva r = new Reserva(cidade, vlr_diaria, nmr, ocupado, rua);

			ReservaDao r_dao = new ReservaDao();
			r_dao.inserir(r);
			System.out.println();
			cont++;
		}
		System.out.println("Funcionou! " + cont + " Reserva(s) Inserida(s)");
	}

	// <<< OPTION 2 >>>

	// <<< OPTION 2 >>>
	
	/// <<< TESTAR CONEXÃO ELETRÔNICO FINAL >>>
	
	/// <<< TESTAR CONEXÃO RESERVA COMEÇO >>>	

	public static void buscarTodosReservas(List<Reserva> reservas) {
		List<Reserva> r_list = new ArrayList<>();

		ReservaDao dao = new ReservaDao();

		r_list = dao.buscarTodos();

		for (int i = 0; i < r_list.size(); i++) {
			System.out.println(reservas.get(i).toString());
		}
	}

	// <<< OPTION 3 >>>

	// <<< OPTION 3 >>>

	public static void filtrarReservaPorId(List<Reserva> reservas, int id) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getId_reserva() == id) {
				System.out.println(reservas.get(i).toString());
			}
		}
	}

	// <<< OPTION 4 >>>

	// <<< OPTION 4 >>>
	
	public static void filtrarReservaPorCaracteres(List<Reserva> reservas) {
		System.out.println("Opção escolhida - Filtrar por Caracteres.");
		System.out.println("(1) - Cidade da Reserva");
		System.out.println("(2) - Rua da Reserva");
		System.out.print("Você deseja fitrar por: (1/2) ");
		char c = sc.nextLine().charAt(0);
		System.out.print("Digite o(s) caracter(es) desejado(s) para o filtro: ");
		String s = sc.nextLine();

		switch (c) {
		case '1':
			// <<< CIDADE >>>
			for (int i = 0; i < reservas.size(); i++) {
				if (reservas.get(i).getCidade().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(reservas.get(i).toString());
					System.out.println();
				}
			}
			break;
		case '2':
			// <<< RUA >>>
			for (int i = 0; i < reservas.size(); i++) {
				if (reservas.get(i).getRua().toUpperCase().contains(s.toUpperCase())) {
					System.out.println(reservas.get(i).toString());
					System.out.println();
				}
			}
			break;
		default:
			System.out.println("ERRO EM ESCOLHER FILTRO! APENAS (1/2)");
			break;
		}
	}

	// <<< OPTION 5 >>>

	// <<< OPTION 5 >>>

	public static void editarReserva(List<Reserva> reservas) {
		Reserva r = new Reserva();

		ReservaDao dao = new ReservaDao();

		System.out.println("<<< RESERVAS CADASTRADOS NO SISTEMA >>>");
		int id = infoId();
		filtrarReservaPorId(reservas, id);

		Boolean continuar = true;
		while (continuar) {
			System.out.println("<<< OPÇÕES >>>");
			System.out.println("(1) - Editar Tudo");
			System.out.println("(2) - Editar Ocupado");
			System.out.println("(3) - Editar Valor Diária");
			System.out.print("Selecione uma opção para alterar a Reserva: (1/2/3) ");

			Boolean ocupado = false;
			Character opcao = sc.nextLine().charAt(0);
			switch (opcao) {
			case '1':
				System.out.print("O local da Reserva está Ocupado? (S-sim/N-não) ");
				String reposta1 = sc.nextLine();
				Character c1 = reposta1.toUpperCase().charAt(0);
				System.out.print("Novo Valor Diária Reserva: R$ ");
				Double n_vlr1 = sc.nextDouble();
				sc.nextLine();

				if (c1 == 'S') {
					ocupado = true;
				}

				r.setOcupado(ocupado);
				r.setVlr_diaria(n_vlr1);

				dao.editarTudo(r, id);
				break;
			case '2':
				System.out.print("O local da Reserva está Ocupado? (S-sim/N-não) ");
				String reposta2 = sc.nextLine();
				Character c2 = reposta2.toUpperCase().charAt(0);

				if (c2 == 'S') {
					ocupado = true;
				}

				r.setOcupado(ocupado);

				dao.editarOcupado(r, id);
				break;
			case '3':
				System.out.print("Novo Valor Diária Reserva: R$ ");
				Double n_vlr3 = sc.nextDouble();
				sc.nextLine();

				r.setVlr_diaria(n_vlr3);

				dao.editarValor(r, id);
				break;
			default:
				System.out.println("Opção escolhida inválida!");
				// GOTO ...
				break;
			}

			System.out.print("Quer editar outro dado do Reserva? (S-sim/N-não) ");
			String s1 = sc.nextLine();
			String s1Upper = s1.toUpperCase();
			Character resposta = s1Upper.charAt(0);
			if (resposta == 'N') {
				continuar = false;
			}
		}
	}

	// <<< OPTION 6 >>>
	public static void excluirReserva(List<Reserva> reservas, int id) {
		filtrarReservaPorId(reservas, id);
		System.out.print("Quer mesmo excluir essa Reserva: (S-sim/N-não) ");
		String s1 = sc.nextLine();
		String s1Upper = s1.toUpperCase();
		Character resposta = s1Upper.charAt(0);
		if (resposta == 'S') {
			ReservaDao dao = new ReservaDao();
			dao.excluirReserva(id);
		}
	}

	/// <<< TESTAR CONEXÃO RESERVA FINAL >>>

	/// <<< TESTAR CONEXÃO RESERVA FINAL >>>	
}
