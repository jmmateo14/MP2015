package org.mp.sesion03;
//
//Universidad de Almería
//Ingeniería Informatoica
public class QueueArray<T> implements Queue<T> {
 
    private T[] arrayQueue;
    private int sizeQueue;
    private int firstQueue;
    private int lastQueue;
    static final int SIZE = 5;
     
    public QueueArray () {
        arrayQueue = (T[]) new Object [SIZE];
        sizeQueue = 0;
        firstQueue = 0;
        lastQueue = arrayQueue.length - 1;
    }
     
    @Override
    public void addLast(T x) {
        // TODO Auto-generated method stub
        if (sizeQueue == arrayQueue.length) {
            ensureCapacity();
        }
        lastQueue = increment(lastQueue);
        arrayQueue[lastQueue] = x;
        sizeQueue++;
    }
 
    private void ensureCapacity () {
        T []nuevo = (T[]) new Object [arrayQueue.length + SIZE];
        for (int i=0; i<sizeQueue; i++) {
            nuevo[i] = arrayQueue[firstQueue];
            firstQueue = increment(firstQueue);
        }
        arrayQueue = nuevo;
        firstQueue = 0;
        lastQueue = sizeQueue - 1;
    }
     
    /**
     * metodo para pasar al siguiente indice del array teniendo en
     * cuenta que el siguiente del ultimo es el primero
     * @param x
     * @return
     */
    private int increment (int x) {
        if (x < arrayQueue.length-1)
            return x+1;
        else
            return 0;
        //return (x+1) % arrayQueue.length;
    }
     
    @Override
    public T getFirst() throws EmptyQueueException {
        // TODO Auto-generated method stub
        if (isEmpty())
            throw new EmptyQueueException ("Cola Vacia");
        return arrayQueue [firstQueue];
    }
 
    @Override
    public T removeFirst() throws EmptyQueueException {
        // TODO Auto-generated method stub
        if (isEmpty())
            throw new EmptyQueueException ("Cola Vacia");
        T x = arrayQueue [firstQueue];
        firstQueue = increment(firstQueue);
        sizeQueue--;
        return x;
    }
 
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if (sizeQueue == 0)
            return true;
        return false;
    }
 
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        sizeQueue = 0;
        firstQueue = 0;
        lastQueue = arrayQueue.length - 1;
    }
 
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return sizeQueue;
    }
 
    public int getLastQueue () {
        return lastQueue;
    }
     
    public int getFirstQueue () {
        return firstQueue;
    }
}