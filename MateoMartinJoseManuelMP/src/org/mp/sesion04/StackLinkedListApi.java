package org.mp.sesion04;

public class StackLinkedListApi<T> implements Stack<T> {

	private java.util.LinkedList<T> stackLinkedListApi;
	
	public StackLinkedListApi () {
		stackLinkedListApi = new java.util.LinkedList<T>();
	}
	/**
	 * Method to insert an element in the stack
	 */
	@Override
	public void push(T x) {
		stackLinkedListApi.addLast(x);
	}

	/**
	 * Method to delete an element from the stack, no returns only deletes
	 * if the stack is empty throws an exception 
	 */
	@Override
	public void pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Pila Vacia");
		stackLinkedListApi.removeLast();
	}

	/**
	 * Doesn't delete any element, only returns
	 */
	@Override
	public T peek() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Pila Vacia");
		return stackLinkedListApi.getLast();
	}

	/**
	 * Method that delete and return an element
	 * throws an exception in the case of the stack is empty
	 */
	@Override
	public T peekAndPop() throws EmptyStackException {
		T x = peek();
		pop();
		return x;
	}

	/**
	 * This verifies that the stack is empty
	 * @return true if is empty, false if not what this.
	 */
	@Override
	public boolean isEmpty() {
		return stackLinkedListApi.isEmpty();
	}

	/**
	 * Empty stack
	 */
	@Override
	public void clear() {
		stackLinkedListApi.clear();
	}

	/**
	 * Returns the size of  the stack
	 */
	@Override
	public int size() {
		return stackLinkedListApi.size();
	}

}
