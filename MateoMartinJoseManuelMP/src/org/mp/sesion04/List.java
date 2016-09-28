package org.mp.sesion04;

// Interfaz List
// 
// Acceso mediante la interfaz ListIterator
//
// *********************** OPERACIONES PUBLICAS **********************
// boolean isEmpty()      	-> Devuelve true si vacia, sino false
// void clear()	            -> Elimina todos los nodos
// ******************ERRORES******************************************
// No se tratan errores

/**
 * Protocolo para listas. Acceso a la lista mediante objeto ListIterator
 * Operaciones de Interfaz List:  Estado de la lista
 * Resto de operaciones en la interfaz ListIterator 
 * @see ListIterator
 */

public interface List<T> {
	
	/**
	 *This verifies that the list is empty
	 * @return true if is empty, false if not what this.
	 */
	boolean isEmpty();

	/**
	 * Clear the list
	 */
	void clear();
}
