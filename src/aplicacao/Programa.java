package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Tabuleiro;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Tabuleiro tabuleiro = new Tabuleiro();

		tabuleiro.sortearMinas();
		tabuleiro.checarMinas();
		boolean vencedor = false;
		System.out.println("         CAMPO MINADO");
		
		do {
			tabuleiro.mostrar();
			System.out.print("Linha: ");
			int linha = sc.nextInt();
			System.out.print("Coluna: ");
			int coluna = sc.nextInt();
			
			while (tabuleiro.checarposicao(linha, coluna)) {
				System.out.println("Posicao informada ja existe tente novamente:");
				System.out.print("Linha: ");
				linha = sc.nextInt();
				System.out.print("Coluna: ");
				coluna = sc.nextInt();
			}
			tabuleiro.mostrarProximas(linha, coluna);
			vencedor = tabuleiro.mudarPosicao(linha, coluna);
			if (!vencedor) {
				vencedor = tabuleiro.checarVencedor();
			}
			System.out.println();
			
		} while (!vencedor);
		
		System.out.println();
		if (tabuleiro.checarVencedor()) {
			System.out.println("Você achou todas as minas PARABENS !!!");
		} else {
			tabuleiro.mostrarMinas();
			System.out.println();
			System.out.println("Você explodiu uma mina !!!");
		}
	
	sc.close();
	}

}
