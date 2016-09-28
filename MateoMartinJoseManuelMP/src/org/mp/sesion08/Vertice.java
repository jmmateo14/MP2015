package org.mp.sesion08;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Vertice {

	private int numVertice;
	private int posX;
	private int posY;
	private ArrayList<Vertice> adyacentes;
	
	public Vertice (String cadena) {
		StringTokenizer cad = new StringTokenizer (cadena, " ");
		numVertice = Integer.parseInt(cad.nextToken());
		posX = Integer.parseInt(cad.nextToken());
		posY = Integer.parseInt(cad.nextToken());
		adyacentes = new ArrayList<Vertice> ();
	}

	public int getNumVertice() {
		return numVertice;
	}

	public void setNumVertice(int numVertice) {
		this.numVertice = numVertice;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void addAyacentes(Vertice vertice) {
		// TODO Auto-generated method stub
		adyacentes.add(vertice);
	}

	public ArrayList<Vertice> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(ArrayList<Vertice> adyacentes) {
		this.adyacentes = adyacentes;
	}
	
	
}
