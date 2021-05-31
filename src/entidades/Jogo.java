package entidades;

public class Jogo extends Tabuleiro{
	
	private String[][] jogo = new String[][] { { "-", "-", "-", "-", "-", "-", "-", "-" },
											   { "-", "-", "-", "-", "-", "-", "-", "-" }, 
											   { "-", "-", "-", "-", "-", "-", "-", "-" },
											   { "-", "-", "-", "-", "-", "-", "-", "-" }, 
											   { "-", "-", "-", "-", "-", "-", "-", "-" },
											   { "-", "-", "-", "-", "-", "-", "-", "-" }, 
											   { "-", "-", "-", "-", "-", "-", "-", "-" },
											   { "-", "-", "-", "-", "-", "-", "-", "-" } };

	public void mostrarProximas(int linhas, int colunas) {
		int linha = 8 - linhas;
		int coluna = colunas - 1;
		if (super.tabuleiro[linha][coluna].equals("0")) {
			if (linha - 1 >= 0) {
				if (!super.tabuleiro[linha][coluna].equals("*")) {
					jogo[linha - 1][coluna] = super.tabuleiro[linha][coluna];
				}
				if (coluna - 1 >= 0 && !super.tabuleiro[linha][coluna].equals("*")) {
					jogo[linha - 1][coluna - 1] = super.tabuleiro[linha][coluna];
				}
				if (coluna + 1 < 8 && !super.tabuleiro[linha][coluna].equals("*")) {
					jogo[linha - 1][coluna + 1] = super.tabuleiro[linha][coluna];
				}
			}
			if (coluna - 1 >= 0 && !super.tabuleiro[linha][coluna].equals("*")) {
				jogo[linha][coluna - 1] = super.tabuleiro[linha][coluna];
			}
			if (coluna + 1 < 8 && !super.tabuleiro[linha][coluna].equals("*")) {
				jogo[linha][coluna + 1] = super.tabuleiro[linha][coluna];
			}
			if (linha + 1 < 8) {
				if (!super.tabuleiro[linha][coluna].equals("*")) {
					jogo[linha + 1][coluna] = super.tabuleiro[linha][coluna];
				}
				if (coluna - 1 >= 0 && !super.tabuleiro[linha][coluna].equals("*")) {
					jogo[linha + 1][coluna - 1] = super.tabuleiro[linha][coluna];
				}
				if (coluna + 1 < 8 && !super.tabuleiro[linha][coluna].equals("*")) {
					jogo[linha + 1][coluna + 1] = super.tabuleiro[linha][coluna];
				}
			}
		}
	}

	public void mostrar() {

		System.out.println("linha");
		for (int i = 0; i < 8; i++) {
			System.out.print("  " + (8 - i) + "   ");
			for (int j = 0; j < 8; j++) {
				System.out.print(" " + jogo[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("       1 2 3 4 5 6 7 8\n           coluna");
	}

	public void mostrarMinas() {
		System.out.println("linha");
		for (int i = 0; i < 8; i++) {
			System.out.print("  " + (8 - i) + "   ");
			for (int j = 0; j < 8; j++) {
				if (super.tabuleiro[i][j].equals("*")) {
					jogo[i][j] = super.tabuleiro[i][j];
					System.out.print(" " + jogo[i][j]);
				} else {
					System.out.print(" " + jogo[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("       1 2 3 4 5 6 7 8\n           coluna");
	}
	
	public boolean checarposicao(int linha, int coluna) {
		if (jogo[8-linha][coluna-1].equals("-")) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean mudarPosicao(int linha, int coluna) {
		if (!super.tabuleiro[8-linha][coluna-1].equals("*")) {
			jogo[8-linha][coluna-1] = super.tabuleiro[8-linha][coluna-1];
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checarVencedor() {
		int cont = 0;
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (jogo[i][j].equals("-")) {
					cont++;
				}
			}
		}
		if (cont == 8) {
			return true;
		} else {
			return false;
		}
	}
	
}
