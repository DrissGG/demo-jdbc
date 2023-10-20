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
public class TestUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3307/demojdbc","root","root");
			System.out.println(db);
			
			Statement monStatement = db.createStatement();
			int fournisseur1 = monStatement.executeUpdate("UPDATE fournisseur SET NOM = 'La Maison des Peintures' WHERE ID = 4 ");
			
			db.close();

	} catch (Exception e) {
		// TODO: handle exception
	}

}
}
