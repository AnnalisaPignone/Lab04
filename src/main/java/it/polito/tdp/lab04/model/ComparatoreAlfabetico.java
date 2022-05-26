package it.polito.tdp.lab04.model;

import java.util.Comparator;

public class ComparatoreAlfabetico implements Comparator <Object> {

	@Override
	public int compare(Object o1, Object o2) {
		
		Corso c1 = (Corso)o1;
		Corso c2 = (Corso)o2;
		
		return c1.getNomeCorso().compareTo(c2.getNomeCorso());
	}
	
	

}
