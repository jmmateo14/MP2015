package org.mp.sesion03;
//
//Universidad de Almería
//Ingeniería Informatoica
public class QueueLinkedList<T> implements Queue<T> {
 
    protected ListNode<T> firstQueue;
    protected ListNode<T> lastQueue;
    protected int size;
     
    public QueueLinkedList () {
        firstQueue = new ListNode (null, null);
        lastQueue = firstQueue;
        size = 0;
    }
     
    @Override
    public void addLast(T x) {
        ListNode<T> nuevo = new ListNode (x, null);
        lastQueue.next = nuevo;
        lastQueue = nuevo;
        size ++;
 
    }
 
    @Override
    public T getFirst() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("Cola Vacia");
        //el primer elemento es el siguiente de la cabecera, 
        //es decir, el siguiente de firstQueue
        return firstQueue.next.element;
    }
 
    @Override
    public T removeFirst() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("Cola Vacia");
        ListNode<T> aux = firstQueue.next;
        firstQueue.next = aux.next;
        if (lastQueue == aux)
            lastQueue = firstQueue;
        size--;
        return aux.element;
    }
 
    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }
 
    @Override
    public void clear() {
        lastQueue = firstQueue;
        firstQueue.next = null;
        size = 0;
    }
 
    @Override
    public int size() {
        return size;
    }
 
}