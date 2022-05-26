package it.polito.tdp.lab04.DAO;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		List<Corso> corsi = new LinkedList<Corso>();
		CorsoDAO cdao = new CorsoDAO();
		corsi= cdao.getTuttiICorsi();
		
		List<Studente> studenti = new LinkedList<Studente>();
		StudenteDAO sdao = new StudenteDAO();
		studenti= sdao.getTuttiGliStudenti();
		
		int p=6; 
		
		
		
		
		
		
		
	}

}