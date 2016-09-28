package org.mp.sesion04;

public class QueueLinkedListApi<T> implements Queue<T> {

	private java.util.LinkedList<T> queueLinkedListApi;
	
	public QueueLinkedListApi () {
		queueLinkedListApi = new java.util.LinkedList<T> ();
	}
	
	/**
	 * Add an element to the list
	 */
	@Override
	public void addLast(T x) {
		queueLinkedListApi.addLast(x);
	}
	
	/**
	 * Method returns the first element of the list
	 * throws an exception in the case of the list is empty
	 */
	@Override
	public T getFirst() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException("Cola Vacia");
		return queueLinkedListApi.getFirst();
	}
	
	/**
	 * Method removes and returns the first element of a list
	 * @throws an exception in the case of the list is empty
	 */
	@Override
	public T removeFirst() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException("Cola Vacia");
		return queueLinkedListApi.removeFirst();
	}

	/**
	 * This verifies that the list is empty
	 * @return true if is empty, false if not what this.
	 */
	@Override
	public boolean isEmpty() {
		return queueLinkedListApi.isEmpty();
	}

	/**
	 * Empty list
	 */
	@Override
	public void clear() {
		queueLinkedListApi.clear();
	}

	/**
	 * Returns the size of the list
	 */
	@Override
	public int size() {
		return queueLinkedListApi.size();
	}

}
