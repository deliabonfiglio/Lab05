package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.dao.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anaDAO= new AnagrammaDAO();
	
	public boolean isCorrect(String anagramma){
		return anaDAO.isCorretto(anagramma);

	}
	
	public Set<String> risolvi(String parola){		
		Set<String> anagrammi= new HashSet<String>();
		String parziale="";
		
		recursive(parziale, parola, 0, anagrammi);
		
		return anagrammi;
	}
	
	
	private void recursive(String parziale, String parola, int step, Set<String> anagrammi){
		
		if(step==parola.length()){
			anagrammi.add(parziale);
			return;
		}
		
		for(int i =0; i<parola.length(); i++){
			if(charCounter(parziale, parola.charAt(i))< charCounter(parola, parola.charAt(i))){
				parziale += parola.charAt(i);
				
				recursive(parziale,parola, step+1, anagrammi);
				
				parziale = parziale.substring(0, parziale.length()-1); //rimuove il carattere aggiunto
			}
		}
	
	}
	
	private static int charCounter(String parziale2, char charAt) {
		int count =0;
		
		for(int i=0; i<parziale2.length(); i++){
			if(parziale2.charAt(i)==charAt)
				count++;
		}
		return count;
	}
}