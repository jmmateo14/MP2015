package org.mp.sesion01;

public class InstalacionElectrica {
	
	private AparatoElectrico[][] instalacion;
	private int dim1;
	private int dim2;
	/**
	 * Aqui se realiza como un cuadro de electricidad, es decir, una matriz bidimensional
	 */
	public InstalacionElectrica(int dim1, int dim2){
		this.dim1 = dim1;
		this.dim2 = dim2;
		this.instalacion = new AparatoElectrico [dim1][dim2];
		for(int i = 0; i < dim1; i++){
			for(int j = 0; j < dim2; j++){
				int potencia = (int) (Math.random() * 9001 + 1000);
				instalacion [i][j] = new AparatoElectrico(potencia);
			}
		}
	}
	/**
	 * Creamos un escenario en el que podemos decir que un 70% esta encendido
	 */
	public void generaEscenario(){
	
		for (int i = 0; i < this.dim1; i++) {  
            for (int j = 0; j < this.dim2; j++){
            	if (Math.random() < 0.7){
            		this.instalacion[i][j].clic();
            	}
            		
            	}
            }
		
	}
	/**
	 * Comprobamos el consumo de la instacion electrica.
	 */
	public boolean compruebaConsumo(){
		int suma = 0;
	
		for (int i = 0; i < this.dim1; i++) {  
            for (int j = 0; j < this.dim2; j++){
            	suma += instalacion[i][j].getConsumoAparato();
            }
            
		}
		return (suma == AparatoElectrico.getConsumoTotal()) ? true : false;
	}
	
	@Override
	public String toString(){
		String potencia = "";
		for (int i = 0; i < dim1; i++){
			for (int j = 0; j < dim2; j++){
				potencia += instalacion [i][j];
			}
			potencia += "\n";
		}
		return potencia;
		
	}
	
}
