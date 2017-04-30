package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.*;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AnagrammiController {

		Model model;
		
	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="txtWord"
	    private TextField txtWord; // Value injected by FXMLLoader

	    @FXML // fx:id="btnCerca"
	    private Button btnCerca; // Value injected by FXMLLoader

	    @FXML // fx:id="txtCorretto"
	    private TextArea txtCorretto; // Value injected by FXMLLoader

	    @FXML // fx:id="txtSbagliato"
	    private TextArea txtSbagliato; // Value injected by FXMLLoader

	    @FXML // fx:id="btnReset"
	    private Button btnReset; // Value injected by FXMLLoader

	    @FXML
	    void doReset(ActionEvent event) {

	    	txtWord.clear();
	    	txtCorretto.clear();
	    	txtSbagliato.clear();
	    }

	    @FXML
	    void doRisolvi(ActionEvent event) {
	    	txtCorretto.clear();
	    	txtSbagliato.clear();
	    	
	    	String parolaInput = txtWord.getText();
	    	int corretti=0;
	    	int sbagliati=0;
	    	
	    	if(!parolaInput.isEmpty() && parolaInput.matches("[a-zA-Z]+")){
	    		Set<String> anagrammi = this.model.risolvi(parolaInput);
	    		
	    		for(String stemp: anagrammi){
	    			//System.out.println(stemp.toString());
	    			//System.out.println(this.model.isCorrect(stemp));
	    			if(this.model.isCorrect(stemp)){
	    				corretti++;
	    				txtCorretto.appendText(stemp.toString()+"\n");
	    			} else {
	    				sbagliati++;
	    				txtSbagliato.appendText(stemp.toString()+"\n");
	    			}
	    		}
	    		txtCorretto.appendText("Numero di anagrammi corretti: "+corretti);
	    		txtSbagliato.appendText("Numero di anagrammi sbagliati: "+sbagliati);
	    	} else {
	    		txtSbagliato.setText("Inserire UNA parola di cui cercare gli anagrammi!");
	    	}
	    	

	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert txtSbagliato != null : "fx:id=\"txtSbagliato\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	    }

		public void setModel(Model model) {
		this.model= model;
			
		}
	}
