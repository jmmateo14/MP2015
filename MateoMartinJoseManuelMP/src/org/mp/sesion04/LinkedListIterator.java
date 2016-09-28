package org.mp.sesion04;

public class LinkedListIterator<T> implements ListIterator<T> {

	protected LinkedList<T> theList;
	protected ListNode<T> current;
	
	/**
	 * Is a builder of the class LinkedListIterator
	 * @param list
	 */
	public LinkedListIterator (LinkedList<T> list) {
		theList = list;
		current = theList.headNode;
	}
	
	/**
	 * Method that adds an element
	 * @throws an exception  when no elements to insert
	 */
	@Override
	public void add(T x) throws NoSuchElementException {
		if (current == null)
			throw new NoSuchElementException("No puedo");
		ListNode<T> nuevo = new ListNode (x);
		nuevo.next = current.next;
		current.next = nuevo;
		current = nuevo;
	}

	/**
	 * Method that removes an element
	 * @throws an exception in the case of that there aren't more element to take out
	 */
	@Override
	public void remove(T x) throws NoSuchElementException {
		ListNode<T> anterior;
		first();
		anterior = theList.headNode;
		while (hasNext()) {
			if (current.element.equals(x)) {
				anterior.next = current.next;
			}
			anterior = current;
			next();
		}
	}

	/**
	 * Method to search elements, sensitive to capital letters
	 * @throws true if finds the same elements y false si no los hay
	 */
	@Override
	public boolean contains(T x) throws NoSuchElementException {
		first();
		while (hasNext()) {
			if (current.element.equals(x)) {
				return true;
			}
			next();
		}
		return false;
	}

	@Override
	public void zero() {
		current = theList.headNode;
	}

	/**
	 * Provides the first element
	 * si la lista esta vacia lanza una excepcion
	 */
	@Override
	public void first() throws NoSuchElementException {
		if (theList.isEmpty())
			throw new NoSuchElementException ("Error en first");
		current = theList.headNode.next;
	}

	/**
	 * Passes to the next element 	 
	 */
	@Override
	public void next() {
		current = current.next;
	}

	/**
	 * Passes to the next node
	 */
	@Override
	public boolean hasNext() {
		if (current != null && current!=theList.headNode)
			return true;
		return false;
	}

	@Override
	public T get() throws NoSuchElementException {
		if (current==theList.headNode || current==null)
			throw new NoSuchElementException("Error en get");
		return current.element;
	}

}
