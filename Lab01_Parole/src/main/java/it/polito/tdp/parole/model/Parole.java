package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {

	LinkedList<String> parole;

	public Parole() {
		parole = new LinkedList<String>();
	}

	public void addParola(String p) {
		parole.add(p);
	}

	public List<String> getElenco() {
		LinkedList<String> temp = new LinkedList<String>();
		temp.addAll(parole);
		Collections.sort(temp);
		return temp;
	}

	public void reset() {
		parole.removeAll(parole);
	}
	
	public void deleteParole(String p) {
		parole.remove(p);
	}

	public LinkedList<String> getParole() {
		return parole;
	}

	public void setParole(LinkedList<String> parole) {
		this.parole = parole;
	}
	
	

}
