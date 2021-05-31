package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Jogo;
import entidades.Tabuleiro;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Tabuleiro tabuleiro = new Tabuleiro();
		Jogo jogo = new Jogo();

		tabuleiro.sortearMinas();
		tabuleiro.checarMinas();
		boolean vencedor = false;
		System.out.println("         CAMPO MINADO");
		
		do {
			jogo.mostrar();
			System.out.print("Linha: ");
			int linha = sc.nextInt();
			System.out.print("Coluna: ");
			int coluna = sc.nextInt();
			
			while (jogo.checarposicao(linha, coluna)) {
				System.out.println("Posicao informada ja existe tente novamente:");
				System.out.print("Linha: ");
				linha = sc.nextInt();
				System.out.print("Coluna: ");
				coluna = sc.nextInt();
			}
			jogo.mostrarProximas(linha, coluna);
			vencedor = jogo.mudarPosicao(linha, coluna);
			if (!vencedor) {
				vencedor = jogo.checarVencedor();
			}
			System.out.println();
			
		} while (!vencedor);
		
		System.out.println();
		if (jogo.checarVencedor()) {
			System.out.println("Você achou todas as minas PARABENS !!!");
		} else {
			jogo.mostrarMinas();
			System.out.println();
			System.out.println("Você explodiu uma mina !!!");
		}
	
	sc.close();
	}

}
