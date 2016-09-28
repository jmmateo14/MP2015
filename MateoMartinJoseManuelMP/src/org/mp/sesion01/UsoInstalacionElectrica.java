package org.mp.sesion01;
/**
 * Clase que en la quetenemos un main para verificar que funciona la clase InstalacionElectrica
 */
public class UsoInstalacionElectrica {
	public static void main (String[] args){
		InstalacionElectrica b = new InstalacionElectrica(5, 7);
		b.generaEscenario();
		System.out.println(b.toString());
	}

}
