package it.polito.tdp.lab04.model;


import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private CorsoDAO corsoDao;
	private StudenteDAO studenteDAO; 
	 

	public Model() {
		this.corsoDao = new CorsoDAO();
		this.studenteDAO=new StudenteDAO(); 
	} 
	
	public List<Corso> getTuttiICorsi(){
		return this.corsoDao.getTuttiICorsi();
	}
	
	public List<Studente> getTuttiGliStudenti(){
		return this.studenteDAO.getTuttiGliStudenti(); 
	}
	
	public Studente getStudenteConMatricola(Integer matricola) {
		List <Studente> studenti= getTuttiGliStudenti(); 
		for (Studente s: studenti) {
			if ((s.matricola).equals(matricola)) 
				return s; 
		}
		return null; 
	}
	
	public List<Studente> getStudentiByCorso(String nomeCorso){
		String codiceCorso=""; 
		List <Corso> corsi= getTuttiICorsi(); 
		for (Corso c: corsi) {
			if (c.getNomeCorso().compareTo(nomeCorso)==0) 
				codiceCorso=c.getCodiceCorso(); 
		}
		List <Studente> studenti= studenteDAO.getStudentiByCorso(codiceCorso); 
		return studenti; 
	}
	
	public List<Corso> getCorsiByMatricola(int matricola){
		Studente studTemp= new Studente (0, null, null, null); 
		List <Studente> studenti= this.studenteDAO.getTuttiGliStudenti();
		
		for (Studente s: studenti) {
			if (s.getMatricola()==matricola) 
				studTemp=s;  
		}
		
		if (studTemp.getMatricola()==0)
			return null; 
		
		List <Corso> corsi= corsoDao.getCorsiByMatricola(studTemp);
		return corsi; 

	}
	
	public boolean studenteIsIscritto(int matricola, String nomeCorso) {
		List <Studente> studenti= getStudentiByCorso(nomeCorso); 
		for (Studente s: studenti) {
			if ((s.matricola).equals(matricola)) 
				return true; 
		}
		return false; 
	}
	
	
	
	
	
}
