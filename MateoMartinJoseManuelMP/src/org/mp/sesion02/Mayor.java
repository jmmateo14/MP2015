package org.mp.sesion02;

public class Mayor {

	/**
	 * elEnteroMayor
	 *
	 * @param vector
	 *            Un array de enteros no vacio
	 * @return El entero mayor en el array
	 */
	public static int elEnteroMayor(int[] vector) {

		int indice;
		int max = Integer.MIN_VALUE;

		for (indice = 0; indice < vector.length; indice++) {
			if (vector[indice] > max) {
				max = vector[indice];
			}
		}
		return max;
	}

}