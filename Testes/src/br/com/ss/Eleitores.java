package br.com.ss;

import java.util.Scanner;

public class Eleitores {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int eleitores, brancos, nulos, validos;
		double percBrancos, percNulos, percValidos;

		System.out.printf("Informe o nro de eleitores:\n");
		eleitores = scn.nextInt();
		System.out.printf("\nInforme o nro de votos validos:\n");
		validos = scn.nextInt();
		System.out.printf("\nInforme o nro de votos em branco:\n");
		brancos = scn.nextInt();
		System.out.printf("\nInforme o nro de votos nulos:\n");
		nulos = scn.nextInt();

		percValidos = ((double) validos / eleitores) * 100;
		percBrancos = ((double) brancos / eleitores) * 100;
		percNulos = ((double) nulos / eleitores) * 100;

		System.out.printf("\n\n%6.2f%% de votos validos.", percValidos);
		System.out.printf("\n%6.2f%% de votos em branco.", percBrancos);
		System.out.printf("\n%6.2f%% de votos nulos.\n", percNulos);

		scn.close();
	}

}
