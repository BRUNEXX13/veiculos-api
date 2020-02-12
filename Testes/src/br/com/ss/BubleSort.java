package br.com.ss;

import java.util.Arrays;

public class BubleSort {

	public static void main(String[] args) {

		int[] v = { 5, 3, 2, 4, 7, 1, 0, 6 };
		bubble(v);
		System.out.println(Arrays.toString(v));
	}

	private static void bubble(int[] v) {
		for (int last = v.length - 1; last > 0; last--) {
			for (int i = 0; i < last; i++)
				if (v[i] > v[i + 1])
					change(v, i, i + 1);
		}

	}
	private static void change(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}

}