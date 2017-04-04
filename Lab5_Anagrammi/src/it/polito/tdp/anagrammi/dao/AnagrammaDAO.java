package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	public boolean isCorretto(String anagramma){
		final String sql = "SELECT nome FROM parola "+ "WHERE nome=? ";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			String stemp = null;
			
			while (rs.next()) {				
				stemp= rs.getString("nome");
			}

			if(stemp!=null)
				return true;
			
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
}