package entidades;

import java.util.Random;

public class Tabuleiro {
	
	protected String[][] tabuleiro = new String[][]{{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"},
											{"-","-","-","-","-","-","-","-"}};
											
	public String getTabuleiro(int linha, int coluna) {
		return tabuleiro[linha][coluna];
	}

	public void sortearMinas() {
		Random r = new Random();
		int linha, coluna;
		int cont = 0;
		do {
			linha = r.nextInt(8);
			coluna = r.nextInt(8);
			if (tabuleiro[linha][coluna] != "*") {
				tabuleiro[linha][coluna] = "*";
				cont++;
			}
		} while(cont < 8);
	}
	
	public void checarMinas() {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				int cont = 0;
				if (tabuleiro[i][j].equals("-")) {
					if (i-1 >= 0) {
						if (tabuleiro[i-1][j].equals("*")) {
							cont++;
						} if (j-1 >= 0 && tabuleiro[i-1][j-1].equals("*")) {
							cont++;
						} if (j+1 <8 && tabuleiro[i-1][j+1].equals("*")) { 
							cont++;
						}
					} if (j-1 >= 0 && tabuleiro[i][j-1].equals("*")) {
						cont++;
					} if (j+1 < 8 && tabuleiro[i][j+1].equals("*")) {
						cont++;
					} if (i+1 < 8) {
						if (tabuleiro[i+1][j].equals("*")) {
							cont++;
						} if (j-1 >= 0 && tabuleiro[i+1][j-1].equals("*")) {
							cont++;
						} if (j+1 < 8 && tabuleiro[i+1][j+1].equals("*")) { 
							cont++;
						}
					}
					tabuleiro[i][j] = String.valueOf(cont);
				}
			}
		}
	}
}
