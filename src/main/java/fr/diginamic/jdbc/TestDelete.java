/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author driss
 *
 */
public class TestDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3307/demojdbc","root","root");
			System.out.println(db);
			
			Statement monStatement = db.createStatement();
			int fournisseur1 = monStatement.executeUpdate("DELETE FROM fournisseur WHERE ID = 4 ");
			
			db.close();

	} catch (Exception e) {
		// TODO: handle exception
	}

	}

}
