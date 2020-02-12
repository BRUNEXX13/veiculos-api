package br.com.ss;

import java.util.stream.IntStream;

public class MultiplosTresouCinco {
	/*
	 * Fazer uma implementação que faça a soma de todos os numeros que sejam
	 * multiplos de 3 ou 5.
	 */
	public static void main(String[] args) {

		IntStream stream = IntStream.range(1, 10);
		long result = stream.reduce(0, (sum, value) -> (value % 3 == 0 || value % 5 == 0) ? sum + value : sum);

		System.out.println(result);
	}

}