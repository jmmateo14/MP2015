package org.mp.sesion03;
 
// Interfaz Cola (Queue)
//
// CONSTRUCCION: sin ninguna inicializacion
//
// ******************OPERACIONES PUBLICAS**************************************
// void addLast( x )        -> Inserta x
// T getFirst( )            -> Devuelve el primer elemento insertado
// T removeFirst( )         -> Devuelve y elimina el primer elemento insertado
// boolean isEmpty( )       -> Devuelve true if empty; sino false
// void clear( )            -> Elimina todos los elementos
// int size()               -> Devuelve el tamano de la cola
// ******************ERRORES***************************************************
// getFirst o removeFirst en una cola vacia
 
public interface Queue<T> {
     
    /**
     * Inserta un elemento nuevo en la cola.
     * 
     * @param x el elemento a insertar.
     */
    void addLast(T x);
     
    /**
     * Devuelve el elemento insertado primero en la cola. No altera la cola.
     * 
     * @return Devuelve el primer elemento insertado en la cola.
     * @exception EmptyQueueException
     *            si la cola es vacia.
     */
    T getFirst() throws EmptyQueueException;
     
    /**
     * Devuelve y elimina el primer elemento insertado en la cola. 
     * No hace que se altera la cola.
     * 
     * @return Devuelve el primer elemento insertado en la cola.
     * @exception EmptyQueueException
     *            si la cola es vacia.
     */
    T removeFirst() throws EmptyQueueException;
     
    /**
     * Comprueba si la cola esta logicamente vacia.
     * 
     * @return true si esta vacia, false sino lo esta.
     */
    boolean isEmpty();
 
    /**
     * Vacia la cola logicamente.
     */
    void clear();
 
    /**
     * Devuelve el tamaño dado a la cola
     */
    int size();
}