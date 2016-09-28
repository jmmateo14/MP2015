package org.mp.sesion04;

public class LinkedListIteratorSorted<T> extends LinkedListIterator<T> {
	
	/**
	 * Is a builder of the class LinkedListIteratorSorted
	 * theList parent class
	 */
	public LinkedListIteratorSorted (LinkedList<T> theList) {
		super (theList);
	}
	/**
	 * Add a new node 
	 */
	public void add (T x) throws NoSuchElementException {
		addSorted((Comparable<T>)x);
	}
	
	/**
	 * Adds a new node to the correct locale so that the list is kept in an ordely
	 * @param x
	 * @throws NoSuchElementException
	 */
	public void addSorted (Comparable<T> x) throws NoSuchElementException {
		ListNode<T> anterior;
		boolean encontrado;
		
		if (theList.isEmpty()) { 
			//super.add( (T) x);
			ListNode<T> nuevo = new ListNode (x);
			theList.headNode.next = nuevo;
			return;
		}
		first();
		anterior = theList.headNode;
		encontrado = false;
		while (hasNext() && !encontrado) {
			if (x.compareTo(current.element) < 0) 
				encontrado = true;
			else {
				anterior = current;
				next();
			}
		}
		ListNode<T> nuevo = new ListNode(x);
		nuevo.next = current;
		anterior.next = nuevo;
	}
}
