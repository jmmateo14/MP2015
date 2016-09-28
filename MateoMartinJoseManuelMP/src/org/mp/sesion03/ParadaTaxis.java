package org.mp.sesion03;
 
/**
 * clase que simula el comportamiento de una parada de taxis
 * utilizando una cola de objetos tipo taxi
 * hay que tener en cuenta que una parada de taxis es una estructura
 * fifo (first in, first out), primero en entrar, primero en salir
 * 
 * @author 
 *
 */
public class ParadaTaxis {
 
    private Queue<Taxi> taxis;
    private String nombre;
    private String direccion;
     
    public ParadaTaxis(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        taxis = new QueueArray<Taxi> ();
    }
 
    public int numeroTaxis() {
        return taxis.size();
    }
 
    public void entradaTaxi(Taxi taxi) {
        // TODO Auto-generated method stub
        taxis.addLast(taxi);
    }
 
    public Taxi salidaTaxi() throws EmptyQueueException {
        return taxis.removeFirst();
    }
 
    public Taxi primerTaxi() throws EmptyQueueException{
        return taxis.getFirst();
    }
 
    /**
     * metodo que devuelve el primer taxi de la parada adaptado para
     * minusvalidos
     * si no hay taxis adaptados en la parada, devuelve null
     * @return un taxi adapatado para minusvalidos
     * @throws EmptyQueueException como este metodo llama al metodo 
     * removeFirst de la cola, y este metodo puede provocar una 
     * excepcion de tipo EmptyQueueException, hay que poner throws
     */
    public Taxi minusvalidoTaxi() throws EmptyQueueException {
        Queue<Taxi> taxisAux = new QueueArray<Taxi> ();
        boolean encon = false;
        Taxi quedo = null;
         
        while ( ! taxis.isEmpty()) {
            Taxi aux = taxis.removeFirst();
            if ( ! encon && aux.isAdaptado()) {
                encon = true;
                quedo = aux;
            }
            else
                taxisAux.addLast(aux);
        }
        taxis = taxisAux;
        return quedo;
    }
 
    public String listado() throws EmptyQueueException {
        Queue<Taxi> taxisAux = new QueueArray<Taxi> ();
        String cad = "";
        while ( ! taxis.isEmpty()) {
            Taxi aux = taxis.removeFirst();
            cad = cad + aux;
            taxisAux.addLast(aux);
        }
        taxis = taxisAux;
        return cad;
    }
     
     
 
}