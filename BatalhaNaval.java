import java.util.Scanner;

public class BatalhaNaval {
	static Scanner s = new Scanner(System.in);
	static int rodadaAtual = 0;
	static int contador1 = 0, contador2 = 0;
	static int escolha1 = 0, escolha2 = 0;
	static String[][] tabuleiroJ1 = new String[10][10];
	static String[][] tabuleiroJ2 = new String[10][10];
	static String[][] tabuleiroX1 = new String[10][10];
	static String[][] tabuleiroX2 = new String[10][10];
	static boolean game = true;
	static boolean navios = false;

	public static void main(String[] args) {

		criarTabuleiro();

		System.out.println("O tabuleiro de ambos os jogadores é um 10x10 e todas as escolhas de ataque e posicionamento do jogo serão necessarias escolhendk posições de 0 a 9.");

		System.out.println();

		System.out.println("O Jogo sera jogado entre dois jogadores, preste a atenção ao inicio e fim da rodada, o jogo ira começar.");

		System.out.println();

		while (game == true) {

			if (navios == false) {
				posicionarNavios();
				navios = true;
			}

			Batalha();

			if (contador1 == 5) {
				System.out.println("Parabens jogador 1, você venceu a partida, o jogo será encerrado.");
				game = false;
			}
			if (contador2 == 5) {
				System.out.println("Parabens jogador 2, você venceu a partida, o jogo será encerrado.");
				game = false;
			}

			if (game == true) {

				if (rodadaAtual == 1) {
					rodadaAtual = 0;
					System.out.println("Sua rodada jogador 1. ");
				} else {
					rodadaAtual = 1;
					System.out.println("Sua rodada jogador 2. ");
				}

			}

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 130; j++) {
					System.out.print("_");
				}
			}
		}
	}

	public static void Batalha() {



		switch (rodadaAtual) {
		case 0:

			for (int i = 0; i < 1; i++) {
				System.out.println();
				mostrarTabuleiro();
				System.out.println();
				System.out.println("Qual linha ou coluna deseja atacar?");
				System.out.println();
				System.out.print("Linha: ");
				int escolha1 = s.nextInt();
				System.out.print("Coluna: ");
				int escolha2 = s.nextInt();
				if (rodadaAtual == 0) {

					if (tabuleiroJ2[escolha1][escolha2] == "O") {
						System.out.println("Parabens, você acertou um dos navios dele.");
						contador1 ++;
						tabuleiroJ2[escolha1][escolha2] = "X";
						tabuleiroX2[escolha1][escolha2] = "X";
					} else {
						if (tabuleiroJ2[escolha1][escolha2] == "X") {
							System.out.println("Esta posição ja foi alvejada, tente acertar outra posição.");
							i--;
						} else {
							if (tabuleiroJ2[escolha1][escolha2] == "~") {
								System.out.println("Você errou.");
								tabuleiroJ2[escolha1][escolha2] = "X";
								tabuleiroX2[escolha1][escolha2] = "X";
							} else {
								if (((escolha1 < 0) || (escolha1 > 10)) || ((escolha2 < 0) || (escolha2 > 10))) {
									System.out.println("Linha ou coluna fora da proporção do tabuleiro. tente novamente.");
									i--;
								}
							}
						}
					}
				}
				mostrarTabuleiro();
			}
			break;
		case 1:
			for (int i = 0; i < 1; i++) {
				System.out.println();
				mostrarTabuleiro();
				System.out.println();
				System.out.println("Qual linha ou coluna deseja atacar?");
				System.out.println();
				System.out.print("Linha: ");
				escolha1 = s.nextInt();
				System.out.print("Coluna: ");
				escolha2 = s.nextInt();
				if (tabuleiroJ1[escolha1][escolha2] == "O") {
					System.out.println("Parabens, você acertou um dos navios dele.");
					contador2 ++;
					tabuleiroJ1[escolha1][escolha2] = "X";
					tabuleiroX1[escolha1][escolha2] = "X";
				} else {
					if (tabuleiroJ1[escolha1][escolha2] == "X") {
						System.out.println("Esta posição ja foi alvejada, tente acertar outra posição.");
						i--;
					} else {
						if (tabuleiroJ1[escolha1][escolha2] == "~") {
							System.out.println("Você errou.");
							tabuleiroJ1[escolha1][escolha2] = "X";
							tabuleiroX1[escolha1][escolha2] = "X";
						} else {
							if (((escolha1 < 0) || (escolha1 > 10)) || ((escolha2 < 0) || (escolha2 > 10))) {
								System.out.println("Linha ou coluna fora da proporção do tabuleiro. tente novamente.");
								i--;
							}
						}
						break;
					}
				}
			}
			mostrarTabuleiro();
		}
	}

	public static void criarTabuleiro() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				tabuleiroJ1[i][j] = "~";
				tabuleiroJ2[i][j] = "~";
				tabuleiroX1[i][j] = "~";
				tabuleiroX2[i][j] = "~";

			}
		}
	}

	public static void posicionarNavios() {

		System.out.println("Indique respectivamente linha e coluna para seus 5 navios Jogador 1");

		for (int i = 0; i < 5; i++) {

			System.out.println();
			System.out.print("Linha: ");
			escolha1 = s.nextInt();
			System.out.print("Coluna: ");
			escolha2 = s.nextInt();

			if (((escolha1 >= 0) && (escolha1 < 10)) && ((escolha2 >= 0) && (escolha2 < 10)) && (tabuleiroJ1[escolha1][escolha2] == "~")) {
				tabuleiroJ1[escolha1][escolha2] = "O";
			} else {

				System.out.println();

				System.out.println("Uma das escolhas não se adequa ao tamanho do tabuleiro ou a posição ja está ocupada. escolha uma posição diferente.");
			}

			System.out.println();
		}

		System.out.println("Seu tabuleiro ficou exatamente assim:");

		verTabuleiro();
		rodadaAtual++;

		System.out.println("Sua vez Jogador 2");
		System.out.println();

		for (int i = 0; i < 5; i++) {

			System.out.println();
			System.out.print("Linha: ");
			escolha1 = s.nextInt();
			System.out.print("Coluna: ");
			escolha2 = s.nextInt();

			if (((escolha1 >= 0) && (escolha1 < 10)) && ((escolha2 >= 0) && (escolha2 < 10)) && (tabuleiroJ2[escolha1][escolha2] == "~")) {
				tabuleiroJ2[escolha1][escolha2] = "O";
			} else {

				System.out.println();

				System.out.println("Uma das escolhas não se adequa ao tamanho do tabuleiro ou a posição ja está ocupada. escolha uma posição diferente.");
			}

			System.out.println();
		}

		System.out.println("Seu tabuleiro ficou exatamente assim:");

		verTabuleiro();
		rodadaAtual--;
	}

	public static void verTabuleiro() {

		switch (rodadaAtual) {

		case 0:
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {

					System.out.print("  " + tabuleiroJ1[i][j]);

				}
				System.out.println("\n");
			}
			break;
		case 1:
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {

					System.out.print("  " + tabuleiroJ2[i][j]);

				}
				System.out.println("\n");
			}
			break;
		}
	}

	public static void mostrarTabuleiro() {

		switch (rodadaAtual) {

		case 0:
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {

					System.out.print("  " + tabuleiroX1[i][j]);

				}
				System.out.println("\n");
			}
			break;
		case 1:
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {

					System.out.print("  " + tabuleiroX2[i][j]);

				}
				System.out.println("\n");
			}
			break;
		}
	}
}