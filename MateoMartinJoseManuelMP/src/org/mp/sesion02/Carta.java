package org.mp.sesion02;

public class Carta implements Comparable<Object> {

	private String palo;
	
	private int numero;
	
	private int valor;
	/**
	 * metodo constructor de la clase carta, que da valor a las 
	 * propiedades del objeto
	 * la propiedad valor almacena un numero de carta teniendo 
	 * en cuenta la ordenacion natural, (oros, copas, espadas y 
	 * bastos) para que sean numeros ascendentes en ese 
	 * orden
	 * @param palo cadena a guardar en la propiedad palo
	 * @param numero entero a guardar en la propiedad numero
	 */

	public Carta(String palo,int numero){
		this.palo = palo;
		this.numero = numero;
		if(palo.equals("O")){
			valor = numero;	
		}else if(palo.equals("C")){
			valor = numero * 100;
		}else if(palo.equals("E")){
			valor = numero * 10000;
		}else if(palo.equals("B")){
			valor = numero * 1000000;
		}
	}
	
	public String getPalo(){
		return palo;
	}
	
	public int getNumero(){
		return numero;
	}
	public double getValor(){
		return valor;
	}

	public Carta clone() {
		return new Carta(palo,numero);
	}

	public boolean equals(Carta c) {
		return (this.palo.equals(c.palo) && this.numero == c.numero)? true : false;
	}

	@Override
	public String toString(){
		return "Inf carta:\n"+numero+"de "+palo+"\nValor: "+valor;
	}

	@Override
	public int compareTo(Object o) {
		Carta carta = (Carta) o;
		if(this.valor == carta.valor){
			return 0;
		}else if(this.valor > carta.valor){
			return 1;
		}else{
			return -1;	
		}
	}
}

