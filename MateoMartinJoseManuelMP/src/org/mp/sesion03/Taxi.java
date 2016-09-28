package org.mp.sesion03;
 
public class Taxi {
 
    private int numLicencia;
    private boolean adaptado;
     
    public Taxi(int numLicencia, boolean adaptado) {
        this.numLicencia = numLicencia;
        this.adaptado = adaptado;
    }
 
    public int getNumLicencia() {
        return numLicencia;
    }
 
    public void setNumLicencia(int numLicencia) {
        this.numLicencia = numLicencia;
    }
 
    public boolean isAdaptado() {
        return adaptado;
    }
 
    public void setAdaptado(boolean adaptado) {
        this.adaptado = adaptado;
    }
 
    public String toString () {
        if (adaptado)
            return numLicencia + " (adaptado)";
        return numLicencia + " (no adaptado)";
    }
}