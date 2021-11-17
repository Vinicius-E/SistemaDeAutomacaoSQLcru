package aplicacao;

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
import solucoes.TestarConexao;

public class Principal {
	public static void main(String[] args) {
		TestarConexao.testar();

		Scanner sc = new Scanner(System.in);

		Boolean continuar = true;
		Boolean c1Tabela = true;
		Boolean c2Tabela = true;
		Boolean c3Tabela = true;
		Boolean c4Tabela = true;
		Boolean c5Tabela = true;

		System.out.println("<<< SISTEMA DE AUTOMAÇÃO >>>");

		while (continuar) {

			// INTRODUÇÃO GERAL
			introduzirGeral();

			Character c = sc.nextLine().charAt(0);

			switch (c) {
			case '1':
				while (c1Tabela) {
					List<Animal> animais = new ArrayList<>();

					AnimalDao dao = new AnimalDao();
					animais = dao.buscarTodos();

					// INTRODUÇÃO ANIMAL
					introduzirAnimal();
					Character c1 = sc.nextLine().charAt(0);
					switch (c1) {
					case '1':
						TestarConexao.inserirAnimal();
						break;
					case '2':
						TestarConexao.buscarTodosAnimais(animais);
						break;
					case '3':
						int id3 = TestarConexao.infoId();
						TestarConexao.filtrarAnimalPorId(animais, id3);
						break;
					case '4':
						TestarConexao.filtrarAnimalPorCaracteres(animais);
						break;
					case '5':
						//ERRO NO BOOLEANO
						TestarConexao.editarAnimal(animais);
						break;
					case '6':
						int id6 = TestarConexao.infoId();
						TestarConexao.excluirAnimal(animais, id6);
						break;
					default:
						System.out.println("Opção escolhida inválida!");
						System.out.print("Digite uma nova opção: (1/2/3/4/5/6) "); /// WOULD LIKE TO PUT O "GOTO"
						c = sc.nextLine().charAt(0);
						break;
					}

					if (continuarTabela(c1Tabela, sc) == false) {
						break;
					}
				}
				break;
			case '2':
				while (c2Tabela) {
					List<Carro> carros = new ArrayList<>();

					CarroDao dao = new CarroDao();
					carros = dao.buscarTodos();

					// INTRODUÇÃO CARRO
					introduzirCarro();
					Character c2 = sc.nextLine().charAt(0);
					switch (c2) {
					case '1':
						TestarConexao.inserirCarro();
						break;
					case '2':
						TestarConexao.buscarTodosCarros(carros);
						break;
					case '3':
						int id3 = TestarConexao.infoId();
						TestarConexao.filtrarCarroPorId(carros, id3);
						break;
					case '4':
						TestarConexao.filtrarCarroPorCaracteres(carros);
						break;
					case '5':
						TestarConexao.editarCarro(carros);
						break;
					case '6':
						int id6 = TestarConexao.infoId();
						TestarConexao.excluirCarro(carros, id6);
						break;
					default:
						System.out.println("Opção escolhida inválida!");
						System.out.print("Digite uma nova opção: (1/2/3/4/5/6) "); /// WOULD LIKE TO PUT O "GOTO"
						c = sc.nextLine().charAt(0);
						break;
					}

					if (continuarTabela(c2Tabela, sc) == false) {
						break;
					}
				}
				break;
			case '3':
				while (c3Tabela) {
					List<Comida> comidas = new ArrayList<>();

					ComidaDao dao = new ComidaDao();
					comidas = dao.buscarTodos();

					// INTRODUÇÃO COMIDA
					introduzirComida();
					Character c3 = sc.nextLine().charAt(0);
					switch (c3) {
					case '1':
						TestarConexao.inserirComida();
						break;
					case '2':
						TestarConexao.buscarTodosComidas(comidas);
						break;
					case '3':
						int id3 = TestarConexao.infoId();
						TestarConexao.filtrarComidaPorId(comidas, id3);
						break;
					case '4':
						TestarConexao.filtrarComidaPorCaracteres(comidas);
						break;
					case '5':
						TestarConexao.editarComida(comidas);
						break;
					case '6':
						int id6 = TestarConexao.infoId();
						TestarConexao.excluirComida(comidas, id6);
						break;
					default:
						System.out.println("Opção escolhida inválida!");
						System.out.print("Digite uma nova opção: (1/2/3/4/5/6) "); /// WOULD LIKE TO PUT O "GOTO"
						c = sc.nextLine().charAt(0);
						break;
					}

					if (continuarTabela(c3Tabela, sc) == false) {
						break;
					}
				}				
				break;
			case '4':
				while (c4Tabela) {
					List<Eletronico> eletronicos = new ArrayList<>();

					EletronicoDao dao = new EletronicoDao();
					eletronicos = dao.buscarTodos();

					// INTRODUÇÃO ELETRÔNICO
					introduzirEletronico();
					Character c3 = sc.nextLine().charAt(0);
					switch (c3) {
					case '1':
						TestarConexao.inserirEletronico();
						break;
					case '2':
						TestarConexao.buscarTodosEletronicos(eletronicos);
						break;
					case '3':
						int id3 = TestarConexao.infoId();
						TestarConexao.filtrarEletronicoPorId(eletronicos, id3);
						break;
					case '4':
						TestarConexao.filtrarEletronicoPorCaracteres(eletronicos);
						break;
					case '5':
						TestarConexao.editarEletronico(eletronicos);
						break;
					case '6':
						int id6 = TestarConexao.infoId();
						TestarConexao.excluirEletronico(eletronicos, id6);
						break;
					default:
						System.out.println("Opção escolhida inválida!");
						System.out.print("Digite uma nova opção: (1/2/3/4/5/6) "); /// WOULD LIKE TO PUT O "GOTO"
						c = sc.nextLine().charAt(0);
						break;
					}

					if (continuarTabela(c4Tabela, sc) == false) {
						break;
					}
				}	
				break;
			case '5':
				while (c5Tabela) {
					List<Reserva> reservas = new ArrayList<>();

					ReservaDao dao = new ReservaDao();
					reservas = dao.buscarTodos();

					// INTRODUÇÃO RESERVA
					introduzirReserva();
					Character c3 = sc.nextLine().charAt(0);
					switch (c3) {
					case '1':
						TestarConexao.inserirReserva();
						break;
					case '2':
						TestarConexao.buscarTodosReservas(reservas);
						break;
					case '3':
						int id3 = TestarConexao.infoId();
						TestarConexao.filtrarReservaPorId(reservas, id3);
						break;
					case '4':
						TestarConexao.filtrarReservaPorCaracteres(reservas);
						break;
					case '5':
						TestarConexao.editarReserva(reservas);
						break;
					case '6':
						int id6 = TestarConexao.infoId();
						TestarConexao.excluirReserva(reservas, id6);
						break;
					default:
						System.out.println("Opção escolhida inválida!");
						System.out.print("Digite uma nova opção: (1/2/3/4/5/6) "); /// WOULD LIKE TO PUT O "GOTO"
						c = sc.nextLine().charAt(0);
						break;
					}

					if (continuarTabela(c5Tabela, sc) == false) {
						break;
					}
				}
				break;
			default:
				System.out.println("Opção escolhida inválida!");
				System.out.print("Digite uma nova opção: (1/2/3/4/5) "); /// WOULD LIKE TO PUT O "GOTO"
				c = sc.nextLine().charAt(0);
				break;
			}
			
			if (continuar(continuar, sc) == false) {
				break;
			}
		}
		System.out.println("<<< SISTEMA DE AUTOMAÇÃO AGRADECE SUA INTERAÇÃO >>>");
		sc.close();
	}

	private static Boolean continuar(Boolean continuar, Scanner sc) {
		System.out.print("Você deseja fazer mais alguma operação no sistema? (S-sim/N-não) ");
		String s1 = sc.nextLine();
		String s1Upper = s1.toUpperCase();
		Character resposta = s1Upper.charAt(0);
		if (resposta == 'N') {
			continuar = false;
		}

		return continuar;
	}

	private static Boolean continuarTabela(Boolean cTabela, Scanner sc) {
		System.out.print("Você deseja continuar editando essa tabela? (S-sim/N-não) ");
		String s1 = sc.nextLine();
		String s1Upper = s1.toUpperCase();
		Character resposta = s1Upper.charAt(0);
		if (resposta == 'N') {
			cTabela = false;
		}

		return cTabela;
	}

	// <<< 1º >>>
	private static void introduzirGeral() {
		System.out.println("<<<<  TABELAS  >>>>");
		System.out.println("(1) - Animal");
		System.out.println("(2) - Carro");
		System.out.println("(3) - Comida");
		System.out.println("(4) - Eletronico");
		System.out.println("(5) - Reserva");
		System.out.println("<<<<  TABELAS  >>>>");
		System.out.print("Digite a tabela que deseja utilizar: (1/2/3/4/5) ");
	}

	// <<< 1.1 >>>
	private static void introduzirAnimal() {
		System.out.println("<<<<  FUNCIONALIDADE TABELA ANIMAL  >>>>");
		System.out.println("(1) - Inserir Animal");
		System.out.println("(2) - Buscar todos os Animais");
		System.out.println("(3) - Filtrar por ID");
		System.out.println("(4) - Filtrar por Caracteres");
		System.out.println("(5) - Editar Animal");
		System.out.println("(6) - Excluir Animal");
		System.out.println("<<<<  FUNCIONALIDADE TABELA ANIMAL  >>>>");
		System.out.print("Digite a funcionalidade desejada: (1/2/3/4/5/6) ");
	}

	// <<< 1.2 >>>
	private static void introduzirCarro() {
		System.out.println("<<<<  FUNCIONALIDADE TABELA CARRO  >>>>");
		System.out.println("(1) - Inserir Carro");
		System.out.println("(2) - Buscar todos os Carros");
		System.out.println("(3) - Filtrar por ID");
		System.out.println("(4) - Filtrar por Caracteres");
		System.out.println("(5) - Editar Carro");
		System.out.println("(6) - Excluir Carro");
		System.out.println("<<<<  FUNCIONALIDADE TABELA CARRO  >>>>");
		System.out.print("Digite a funcionalidade desejada: (1/2/3/4/5/6) ");
	}

	// <<< 1.3 >>>
	private static void introduzirComida() {
		System.out.println("<<<<  FUNCIONALIDADE TABELA COMIDA  >>>>");
		System.out.println("(1) - Inserir Comida");
		System.out.println("(2) - Buscar todas as Comidas");
		System.out.println("(3) - Filtrar por ID");
		System.out.println("(4) - Filtrar por Caracteres");
		System.out.println("(5) - Editar Comida");
		System.out.println("(6) - Excluir Comida");
		System.out.println("<<<<  FUNCIONALIDADE TABELA COMIDA  >>>>");
		System.out.print("Digite a funcionalidade desejada: (1/2/3/4/5/6) ");
	}

	// <<< 1.4 >>>
	private static void introduzirEletronico() {
		System.out.println("<<<<  FUNCIONALIDADE TABELA ELETRONICO  >>>>");
		System.out.println("(1) - Inserir Eletrônico");
		System.out.println("(2) - Buscar todos Eletrônicos");
		System.out.println("(3) - Filtrar por ID");
		System.out.println("(4) - Filtrar por Caracteres");
		System.out.println("(5) - Editar Eletrônico");
		System.out.println("(6) - Excluir Eletrônico");
		System.out.println("<<<<  FUNCIONALIDADE TABELA ELETRONICO  >>>>");
		System.out.print("Digite a funcionalidade desejada: (1/2/3/4/5/6) ");
	}

	// <<< 1.5 >>>
	private static void introduzirReserva() {
		System.out.println("<<<<  FUNCIONALIDADE TABELA RESERVA  >>>>");
		System.out.println("(1) - Inserir Reserva");
		System.out.println("(2) - Buscar todas as Reservas");
		System.out.println("(3) - Filtrar por ID");
		System.out.println("(4) - Filtrar por Caracteres");
		System.out.println("(5) - Editar Reserva");
		System.out.println("(6) - Excluir Reserva");
		System.out.println("<<<<  FUNCIONALIDADE TABELA RESERVA  >>>>");
		System.out.print("Digite a funcionalidade desejada: (1/2/3/4/5/6) ");
	}
}