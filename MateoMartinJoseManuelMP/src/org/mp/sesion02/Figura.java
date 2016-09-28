package org.mp.sesion02;

/**
* Clase abstracta que representa una figura la cual tiene varias
* propiedades y un método no implementado que calcula el area
* de la figura
*/
@SuppressWarnings("rawtypes")
public abstract class Figura implements Comparable
{
	/**
	 * Método abstracto que implementarán las clases que heredan
	 * de ésta
	 * calcula el área de una figura
	 * @return un valor real que contiene el area de la figura 
	 * en cuestión
	 */
    abstract public double area( );

    /**
     * Constructor de la clase figura que inicializa la propiedad
     * nombre
     * @param nombreFigura es el nombre que se le quiere dar 
     * a la figura
     */
    public Figura( String nombreFigura )
    {
        nombre = nombreFigura;
    }

    /**
     * Método que comprueba si una figura es menor que la pasada
     * como parámetro comprobando las áreas de cada una de ellas
     * @param lder: figura con la que se quiere comparar
     * @return un valor lógico que será verdadero si el this 
     * tiene un area menor que lder o falso en caso contrario
     */
    final public boolean menorQue( Figura lder )
    {
        return area( ) < lder.area( );
    }

    /**
     * método que devuelve una cadena con la información de la figura
     * @return devuelve la cadena con los datos de la figura
     */
    final public String toString( )
    {
        return nombre + " con area " + area( );
    }
    
    public String getNombre () {
    	return nombre;
    }
    
    public int compareTo (Object o) {
    	Figura f = (Figura) o;
    	if (area() < f.area())
    		return -1;
    	if (area() > f.area())
    		return +1;
    	return 0;
    }
    
    public void setNombre (String nombre) {
    	this.nombre = nombre;
    }

    /**
    * Cadena de caracteres que representa el nombre de la figura
    */
    private String nombre;
}