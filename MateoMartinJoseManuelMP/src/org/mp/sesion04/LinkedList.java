package org.mp.sesion04;

public class LinkedList<T> implements List<T> {

	protected ListNode<T> headNode;
	
	public LinkedList () {
		headNode = new ListNode<T> (null, null);
	}
	
	@Override
	public boolean isEmpty() {
		//esta vacia cuando el siguiente de la cabecera sea null
		if (headNode.next == null)
			return true;
		return false;
	}

	@Override
	public void clear() {
		//pongo el siguiente de la cabecera a null
		headNode.next = null;
	}

}
