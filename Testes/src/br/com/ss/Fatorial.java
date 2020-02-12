package br.com.ss;

import java.util.Scanner;

public class Fatorial {
	
	/*
	 * Faça um programa que calcule o fatorial de um número qualquer.
	 */

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int num, fat = 1;
		int cont = 1;

		do {
			System.out.println("Digite um nº");
			num = scn.nextInt();

			for (int i = 1; i <= num; i++) {
				fat = fat * i;
			}

			System.out.println("!" + num + " = " + fat);
			cont++;

		} while (cont < 2);
		
		scn.close();
	}
}