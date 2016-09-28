package org.mp.sesion02;

import java.io.*;

/**
 * clase publica que comprueba el funcionamiento de la clase figura
 * y de todas las clases que heredan de ella
 *
 */
class PruebaFigura
{
	/**
	 * propiedad de clase para la lectura de datos de teclado
	 */
    private static BufferedReader in;

    /**
     * metodo que ordena un vector de figuras por area de menor
     * a mayor
     * @param vector con todas las figuras a ordenar
     */
    public static void ordenacionPorInsercion( Figura [ ] a )
    {
        for( int p = 1; p < a.length; p++ )
        {
            int j = p;
            Figura tmp = a[ p ];

            for( ; j > 0 && tmp.menorQue( a[ j - 1 ] ); j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

    /**
     * metodo que lee los datos de una figura, y en caso de que se 
     * haya producido un error en la lectura, se crea una figura
     * que es un circulo de radio 0
     * @return la figura leida 
     */
    private static Figura leerFigura( )
    {
        double rad;
        double largo;
        double ancho;
        String unaLinea;

        try
        {
            System.out.println( "Introduzca el tipo de figura:" );
            do
            {
                unaLinea = in.readLine( );
            } while( unaLinea.length( ) == 0 );
            
            switch( unaLinea.charAt( 0 ) )
            {
              case 'c':
                System.out.println( "Introduzca el radio: " );
                rad = Double.valueOf( in.readLine( ) ).doubleValue( );
                return new Circulo( rad );
              case 's':
                System.out.println( "Introduzca el lado: " );
                largo = Double.valueOf( in.readLine( ) ).doubleValue( );
                return new Cuadrado( largo );
              case 'r':
                System.out.println( "Introduzca el largo y el ancho "
                                  + "en líneas separadas: " );
                largo = Double.valueOf( in.readLine( ) ).doubleValue( );
                ancho = Double.valueOf( in.readLine( ) ).doubleValue( );
                return new Rectangulo( largo, ancho );
              default:
                System.err.println( "Escriba c, r, or s" );
                return new Circulo( 0 );
            }
        }
        catch( IOException e )
        {
            System.err.println( e );
            return new Circulo( 0 );
        }
    }

    /**
     * programa principal de la clase prueba figura
     * @param args
     */
    public static void main( String [ ] args )
    {
        try
        {
                //  Lectura del número de figuras
            System.out.println( "Introduzca # de figuras: " );
            in = new BufferedReader( new InputStreamReader( System.in ) );
            int numFiguras = Integer.parseInt( in.readLine() );

                // Lectura de las figuras
            Figura [ ] array = new Figura[ numFiguras ];
            for( int i = 0; i < numFiguras; i++ )
                array[ i ] = leerFigura( );

                // Ordeanción y salida
            ordenacionPorInsercion( array );
            System.out.println( "Ordenados por area:" );
            for( int i = 0; i < numFiguras; i++ )
                System.out.println( array[ i ] );
        }
        catch( Exception e )
          { System.out.println( e ); }
    }
}
