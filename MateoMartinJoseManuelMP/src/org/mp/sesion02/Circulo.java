package org.mp.sesion02;
/**
 * clase que se utiliza para representar un circulo, hereda de la 
 * clase Figura, por lo que tiene que implementar el metodo 
 * abstracto area
 * 
 * @author 
 *
 */
public class Circulo extends Figura
{
	/**
	 * metodo constructor que crea un objeto de tipo circulo llamando
	 * al constructor de la superclase (Figura) dandole como nombre
	 * "Circulo" y luego le da valor a la propiedad radio
	 * 
	 * @param r valor que se guarda en la propiedad radio
	 */
    public Circulo( double r )
    {
        super( "Circulo" );
        radio = r;
    }

    public double area( )
    {
        return PI * radio * radio;
    }

    private static final double PI = 3.14159265358979323;
    private double radio;
}