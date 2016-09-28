package org.mp.sesion03;
//
//Universidad de Almería
//Ingeniería Informatoica

 
public class EmptyQueueException extends Exception
{
    /**
     * Constructor para la excepcion.
     * @param inicializa con un mensaje de la expecption
     */
    public EmptyQueueException(String error)
    {
        super( error );
    }
}