/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author driss
 *
 */
public class TestInsertion {
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3307/demojdbc","root","root");
			System.out.println(db);
			
			Statement monStatement = db.createStatement();
			int fournisseur1 = monStatement.executeUpdate(("INSERT INTO fournisseur (NOM) VALUES ('La Maison de la Peinture')"));
			
			db.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
