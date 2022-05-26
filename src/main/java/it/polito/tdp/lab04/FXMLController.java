/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.ComparatoreAlfabetico;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class FXMLController {
	
	private Model model; 
	List<Corso> corsi; 
	List<Studente> studenti;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscritti"
    private Button btnCercaIscritti; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaNome"
    private Button btnCercaNome; // Value injected by FXMLLoader

    @FXML // fx:id="cmbCorsi"
    private ComboBox<String> cmbCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	cmbCorsi.setValue(null);
    	txtResult.clear();
    	txtNome.clear(); 
    	txtCognome.clear();
    	btnCercaNome.setText(""); 
    	btnCercaNome.setStyle("-fx-background-color: ");
    	if (txtMatricola.getText().compareTo("")==0) {
    		txtResult.setText("Per favore inserisci un numero di matricola.");
    		return; 
    	}
    	String matr= txtMatricola.getText(); 
    	int matricola=Integer.parseInt(matr); 
    	if (model.getCorsiByMatricola(matricola)==null) {
    		txtResult.setText("Studente non trovato!");
    		return; 
    		}
    	corsi=model.getCorsiByMatricola(matricola);
    	txtResult.appendText(corsi.toString());

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	txtResult.clear();
    	txtMatricola.clear();
    	txtNome.clear(); 
    	txtCognome.clear();
    	btnCercaNome.setText(""); 
    	btnCercaNome.setStyle("-fx-background-color: ");
    	String supporto= cmbCorsi.getValue(); 
    	if (supporto==null) {
    	txtResult.setText("Per favore inserisci un corso.");
    	return; 
    	}
    	studenti= this.model.getStudentiByCorso(supporto); 
    	txtResult.appendText(studenti.toString());

    }

    @FXML
    void doCercaNome(ActionEvent event) {
    	cmbCorsi.setValue(null);
    	txtNome.clear(); 
    	txtCognome.clear();
    	if (txtMatricola.getText().compareTo("")==0) {
    		txtResult.setText("Per favore inserisci un numero di matricola.");
    		return; 
    	}
    	String matr=txtMatricola.getText();  
    	int matricola=Integer. parseInt(matr); 
    	if (this.model.getStudenteConMatricola(matricola)==null) {
    		txtResult.setText("Studente non trovato!");
    		btnCercaNome.setText("X"); 
    		btnCercaNome.setTextFill(Color.WHITE);
    		btnCercaNome.setStyle("-fx-background-color: #FF0000");
    		return; 
    	}
    	Studente s= this.model.getStudenteConMatricola(matricola);
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	btnCercaNome.setText("V"); 
		btnCercaNome.setTextFill(Color.WHITE);
    	btnCercaNome.setStyle("-fx-background-color: green");

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    String matr=txtMatricola.getText(); 
    int matricola=Integer.parseInt(matr); 
    String nomeCorso=cmbCorsi.getValue(); 
    boolean is= model.studenteIsIscritto(matricola, nomeCorso); 
    if (is==true)
    	txtResult.setText("Studente già iscritto a questo corso!");
    else 
    	txtResult.setText("Studente non iscritto a questo corso");
    }

    @FXML
    void doReset(ActionEvent event) {

    }

    public void setModel(Model model) {
    	this.model=model;
    	corsi = new LinkedList<Corso>(this.model.getTuttiICorsi());
    	Collections.sort(corsi, new ComparatoreAlfabetico()); 
    	cmbCorsi.getItems().clear(); 
    	for (int i=0; i<corsi.size(); i++) {
    		cmbCorsi.getItems().add(corsi.get(i).getNomeCorso());
    	}
    	cmbCorsi.getItems().add(null); 
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

        //for (int i=0; i<this.model.getTuttiICorsi(); i++) {
        	//cmbCorsi.getItems().add(this.model.getTuttiICorsi().get(i).getNomeCorso()); 
        //}
    }

}

