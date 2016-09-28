package org.mp.sesion03;
 
public class StackLinkedList<T> implements Stack<T> {
 
    private ListNode<T> topOfStack;
    private int size;
     
    public StackLinkedList () {
        //creo un nodo cabecera como un nodo con el element a null
        //y el next a null
        topOfStack = new ListNode (null, null);
        size = 0;
    }
     
    @Override
    public void push(T x) {
        //creo un nuevo nodo con la informacion que me dan
        ListNode nuevo = new ListNode (x);
        //el siguiente del nuevo apunte al primero de la pila
        //y el primero de la pila es el siguiente de la cabecera
        nuevo.next = topOfStack.next;
        //el primero de la pila es el nuevo
        topOfStack.next = nuevo;
        size++;
    }
 
    @Override
    public void pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException ("Pila Vacia");
        //hago que el siguiente de la cabecera sea el segundo,
        //que es el siguiente del primero
        ListNode<T> primero = topOfStack.next;
        topOfStack.next = primero.next;
        //topOfStack.next = topOfStack.next.next;
        size--;
    }
 
    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Pila Vacia");
        //devuelvo la informacion del primer elemento que es el 
        //siguiente de la cabecera
        return topOfStack.next.element;
    }
 
    @Override
    public T peekAndPop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Pila Vacia");
        T x = peek ();
        pop ();
        return x;
    }
 
    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }
 
    @Override
    public void clear() {
        //pone a null el siguiente de la cabecera y a 0 el tamaño
        topOfStack.next = null;
        size = 0;
    }
 
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }
 
}