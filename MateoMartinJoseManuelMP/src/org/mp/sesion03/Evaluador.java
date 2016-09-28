package org.mp.sesion03;
 
import java.util.Scanner;
 
public class Evaluador {
 
    public String[] parser(String expresion) {
        //tengo que separar la cadena por trozos o palabras
        //me defino un Scanner que tenga como origen la cadena
        //la clase Scanner por defecto tiene como separador el espacio
        Scanner entrada = new Scanner (expresion);
        //como no se cuantos elementos voy a tener en la cadena,
        //creo una cola, voy metiendo las palabras en la cola
        //y al final me creare un array con los elementos de la
        //cola y eso es lo que devuelvo
        Queue<String> cola = new QueueArray<String> ();
         
        //mientras queden palabras en la cadena
        while (entrada.hasNext()) {
            //cojo una palabra
            String palabra = entrada.next();
            //la meto en la cola
            cola.addLast(palabra);
        }
        //creo el array con el tamaño de la cola
        String []array = new String [cola.size()];
        //y para meter los elementos necesito utilizar el metodo
        //removeFirst que lanza la excepcion EmptyQueueException
        //por lo que tengo que capturar las excepciones posibles
        //(que no van a existir) con un try catch
        try {
            for (int i=0; i<array.length; i++)
                array[i] = cola.removeFirst();
        }
        catch (EmptyQueueException e) {
        }
        //y al final devuelvo el array
        return array;
    }
 
    public int postfija(String[] expresion) {
        //creo una pila para guardar los operandos
        Stack<Integer> pila = new StackArray<Integer> ();
         
        //recorro todos los elementos de la expresion
        for (int i=0; i<expresion.length; i++) {
            if (expresion[i].equals("+") || expresion[i].equals("-") ||
                    expresion[i].equals("*") || expresion[i].equals("/")) {
                //es un operador, saco de la pila dos operandos, realizo 
                //la operacion y guardo el resultado
                //para sacar de la pila tengo que hacerlo capturando
                //la excepcion de emptyStackException
                try {
                    //hay que tener en cuenta que el primer operando
                    //que saco de la pila es el ultimo operando de
                    //la operacion
                    int der = pila.peekAndPop();
                    int izq = pila.peekAndPop();
                    int resul = 0;
                    //segun sea el operador, realizo una u otra expresion
                    switch (expresion[i]) {
                    case "+": resul = izq + der; break;
                    case "-": resul = izq - der; break;
                    case "*": resul = izq * der; break;
                    case "/": resul = izq / der; break;
                    }
                    //meto en la pila el resultado
                    pila.push(resul);
                }
                catch (EmptyStackException e) {
                }
            }
            else {
                Integer numero = Integer.parseInt(expresion[i]);
                                 //new Integer(expresion[i]);
                pila.push(numero);
            }
        }
        try {
            //al final solo tengo un elemento en la pila que es
            //el que tengo que devolver
            return pila.peekAndPop();
        }
        catch (EmptyStackException e) {
            return 0;
        }
    }
 
}