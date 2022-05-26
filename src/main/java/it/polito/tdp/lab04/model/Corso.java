package it.polito.tdp.lab04.model;

public class Corso {
	String codiceCorso; 
	int numeroCrediti; 
	String nomeCorso; 
	int periodoDidattico;
	
	public Corso(String codiceCorso, int numeroCrediti, String nomeCorso, int periodoDidattico) {
		super();
		this.codiceCorso = codiceCorso;
		this.numeroCrediti = numeroCrediti;
		this.nomeCorso = nomeCorso;
		this.periodoDidattico = periodoDidattico;
	}

	public String getCodiceCorso() {
		return codiceCorso;
	}

	public void setCodiceCorso(String codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	public int getNumeroCrediti() {
		return numeroCrediti;
	}

	public void setNumeroCrediti(int numeroCrediti) {
		this.numeroCrediti = numeroCrediti;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public int getPeriodoDidattico() {
		return periodoDidattico;
	}

	public void setPeriodoDidattico(int periodoDidattico) {
		this.periodoDidattico = periodoDidattico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceCorso == null) ? 0 : codiceCorso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codiceCorso == null) {
			if (other.codiceCorso != null)
				return false;
		} else if (!codiceCorso.equals(other.codiceCorso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\ncodiceCorso=" + codiceCorso + ", numeroCrediti=" + numeroCrediti + ", nomeCorso=" + nomeCorso
				+ ", periodoDidattico=" + periodoDidattico;
	} 
	
	
	

}
