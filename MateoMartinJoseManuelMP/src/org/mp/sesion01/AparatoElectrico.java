package org.mp.sesion01;

public class AparatoElectrico {
	private int potencia;
	private boolean estado;
	private static int potenciaTotal = 0;
	
	public AparatoElectrico (int potencia){
		this.potencia = potencia;
		this.estado = false; //por defecto el aparato esta apagado
		
	}

	public static int getConsumoTotal() {
		return potenciaTotal;
	}
	
	public int getConsumoAparato() {
		return (this.estado)?this.potencia:0;
	}
	/**
	 * Para decir si esta en On u Off, y se vaya sumando la potencia de los que esten encendidos.
	 */
	public void clic(){
		this.estado = !this.estado;
		potenciaTotal += (this.estado)?this.potencia:-this.potencia;
	}

	@Override
	public String toString() {
		return this.potencia + ((this.estado)?"(On)":"(Off)");
	}
	
}
