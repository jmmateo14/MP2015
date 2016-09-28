package org.mp.sesion03;
 
/**
 * clase publica que implementa la interfaz Stack utilizando
 * una estructura de datos array
 * 
 * @author 
 *
 * @param <T> esta clase utiliza los tipos parametrizados T para poder
 * definir pilas con arrays de cualquier tipo que se necesite
 */
public class StackArray<T> implements Stack<T> {
 
    private T[]arrayStack;
    private int topOfStack;
    private static final int SIZE = 10;
     
    public StackArray () {
        arrayStack = (T[])new Object [SIZE];
        topOfStack = -1;
    }
     
    /**
     * metodo para insertar un elemento en la pila
     * lo primero que hago es comprobar si queda espacio 
     * en la pila, y si no queda espacio llamo a ensureCapacity
     * y despues meto el elemento por el final
     */
    @Override
    public void push(T x) {
        // TODO Auto-generated method stub
        if (topOfStack == arrayStack.length - 1) {
            ensureCapacity ();
        }
        topOfStack++;
        arrayStack [topOfStack] = x;
        //arrayStack[++topOfStack] = x;
    }
     
    /**
     * si la pila esta llena, antes de meter mas elementos 
     * creo una pila mas grande, meto todos los elementos que
     * tuviera la anterior pila y la pila nueva pasa a ser
     * la actual y la antigua se pierde
     */
    private void ensureCapacity () {
        T []nuevo = (T[]) new Object [arrayStack.length + SIZE];
        for (int i=0; i<=topOfStack; i++)
            nuevo[i] = arrayStack[i];
        arrayStack = nuevo;
    }
 
    /**
     * metodo para borrar un elemento de la pila
     * no lo devuelve, solo lo borra
     * si la pila esta vacia lanza una excepcion
     * y si la pila no esta vacia, como no puedo borrar fisicamente
     * un elemento de un vector, lo que hago es restarle uno a
     * la cima de la pila (topOfStack--)
     */
    @Override
    public void pop() throws EmptyStackException {
        // TODO Auto-generated method stub
        if (isEmpty ())
            throw new EmptyStackException("Pila Vacia");
        topOfStack--;
    }
 
    /**
     * no lo borra, solo lo devuelve
     */
    @Override
    public T peek() throws EmptyStackException {
        // TODO Auto-generated method stub
        if (isEmpty ())
            throw new EmptyStackException("Pila Vacia");
        return arrayStack[topOfStack];
    }
 
    /**
     * lo borra y lo devuelve
     */
    @Override
    public T peekAndPop() throws EmptyStackException {
        // TODO Auto-generated method stub
        if (isEmpty ())
            throw new EmptyStackException("Pila Vacia");
        //T x = arrayStack[topOfStack];
        //topOfStack--;
        T x = peek();
        pop();
        return x;
    }
 
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        /*if (topOfStack == -1)
            return true;
        else
            return false;
        /////////////////
        if (topOfStack == -1)
            return true;
        return false;*/
        ///////////////
        return (topOfStack == -1);
    }
 
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        topOfStack = -1;
        /*while ( ! isEmpty())
            pop();*/
    }
 
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return topOfStack+1;
    }
 
}