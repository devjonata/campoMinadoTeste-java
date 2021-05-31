package entidades;

import java.util.Random;

public class Tabuleiro {
	
	private String[][] tab = new String[][]{{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"}};
									
	private String[][] jogo = new String[][]{{"-","-","-","-","-","-","-","-"},
											 {"-","-","-","-","-","-","-","-"},
											 {"-","-","-","-","-","-","-","-"},
											 {"-","-","-","-","-","-","-","-"},
											 {"-","-","-","-","-","-","-","-"},
											 {"-","-","-","-","-","-","-","-"},
											 {"-","-","-","-","-","-","-","-"},
											 {"-","-","-","-","-","-","-","-"}};
											
	public String[][] getTab() {
		return tab;
	}

	public void sortearMinas() {
		Random r = new Random();
		int linha, coluna;
		int cont = 0;
		do {
			linha = r.nextInt(8);
			coluna = r.nextInt(8);
			if (tab[linha][coluna] != "*") {
				tab[linha][coluna] = "*";
				cont++;
			}
		} while(cont < 8);
	}
	
	public void checarMinas() {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				int cont = 0;
				if (tab[i][j].equals("-")) {
					if (i-1 >= 0) {
						if (tab[i-1][j].equals("*")) {
							cont++;
						} if (j-1 >= 0 && tab[i-1][j-1].equals("*")) {
							cont++;
						} if (j+1 <8 && tab[i-1][j+1].equals("*")) { 
							cont++;
						}
					} if (j-1 >= 0 && tab[i][j-1].equals("*")) {
						cont++;
					} if (j+1 < 8 && tab[i][j+1].equals("*")) {
						cont++;
					} if (i+1 < 8) {
						if (tab[i+1][j].equals("*")) {
							cont++;
						} if (j-1 >= 0 && tab[i+1][j-1].equals("*")) {
							cont++;
						} if (j+1 < 8 && tab[i+1][j+1].equals("*")) { 
							cont++;
						}
					}
					tab[i][j] = String.valueOf(cont);
				}
			}
		}
	}
	
	public void mostrarProximas(int linhas, int colunas) {
		int linha = 8-linhas;
		int coluna = colunas-1;
		if (tab[linha][coluna].equals("0")) {
			if (linha-1 >= 0) {
				if (!tab[linha-1][coluna].equals("*")) {
					jogo[linha-1][coluna] = tab[linha-1][coluna];
				} if (coluna-1 >= 0 && !tab[linha-1][coluna-1].equals("*")) {
					jogo[linha-1][coluna-1] = tab[linha-1][coluna-1];
				} if (coluna+1 < 8 && !tab[linha-1][coluna+1].equals("*")) { 
					jogo[linha-1][coluna+1] = tab[linha-1][coluna+1];
				}
			} if (coluna-1 >= 0 && !tab[linha][coluna-1].equals("*")) {
				jogo[linha][coluna-1] = tab[linha][coluna-1];
			} if (coluna+1 < 8 && !tab[linha][coluna+1].equals("*")) {
				jogo[linha][coluna+1] = tab[linha][coluna+1];
			} if (linha+1 < 8) {
				if (!tab[linha+1][coluna].equals("*")) {
					jogo[linha+1][coluna] = tab[linha+1][coluna];
				} if (coluna-1 >= 0 && !tab[linha+1][coluna-1].equals("*")) {
					jogo[linha+1][coluna-1] = tab[linha+1][coluna-1];
				} if (coluna+1 < 8 && !tab[linha+1][coluna+1].equals("*")) { 
					jogo[linha+1][coluna+1] = tab[linha+1][coluna+1];
				}
			}
	  }
	}
	
	public void mostrar() {
		System.out.println("linha");
		for (int i=0; i<8; i++) {
			System.out.print("  " + (8-i) + "   ");
			for (int j=0; j<8; j++) {
				System.out.print(" " + jogo[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("       1 2 3 4 5 6 7 8\n           coluna");
	}
	
	public void mostrarMinas() {
		System.out.println("linha");
		for (int i=0; i<8; i++) {
			System.out.print("  " + (8-i) + "   ");
			for (int j=0; j<8; j++) {
				if (tab[i][j].equals("*")) {
					jogo[i][j] = tab[i][j];
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
		
		if (!tab[8-linha][coluna-1].equals("*")) {
			jogo[8-linha][coluna-1] = tab[8-linha][coluna-1];
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
