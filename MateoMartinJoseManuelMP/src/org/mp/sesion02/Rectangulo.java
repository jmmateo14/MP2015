package org.mp.sesion02;

public class Rectangulo extends Figura
{
    public Rectangulo( double largo, double  ancho )
    {
        super( "Rectangulo" );
        base = largo;
        alt = ancho;
    }

    public double area( )
    {
        return base * alt;
    }

    private double base;
    private double alt;
}