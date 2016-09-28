package org.mp.sesion02;

public class Baraja {

	private String nombreBaraja;
	private Carta[] cartas;
	/**
	 * metodo constructor para los objetos de tipo Baraja
	 * @param nombreBaraja valor que se asigna a la propiedad nombreBaraja
	 * @param cartas vector de cartas que se asigna a la propiedad cartas
	 */

	public Baraja(String nombreBaraja, Carta[] carta){
		this.nombreBaraja = nombreBaraja;
		cartas = new Carta[carta.length];
		for(int i=0; i<cartas.length;i++){
			cartas[i] = carta[i].clone();
		}
		
	}
	
	public String getNombreBaraja(){
		return nombreBaraja;
	}
	
	public Carta[] getCartas(){
		return cartas;
	}
	
	@Override
	public String toString(){
		String aux = "";
		for(int i=0; i > cartas.length; i++){
			aux += cartas[i]+" \n";
		}
		return aux;
	}
}

