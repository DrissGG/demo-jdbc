/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * @author driss
 *
 */
public class TestSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Fournisseur> listFournisseur = new ArrayList<>();
		try {
			// // Établir la connexion à la base de données
			Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3307/demojdbc","root","root");
			
			// Créer une instruction SQL
			Statement monStatement = db.createStatement();
			// Exécuter la requête pour extraire la liste des fournisseurs
			ResultSet curseur = monStatement.executeQuery("SELECT ID, NOM FROM fournisseur");
			
			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				
				Fournisseur fournisseur = new Fournisseur(id, nom);
				listFournisseur.add(fournisseur);
				
				
			}
			for(Fournisseur f : listFournisseur) {
				System.out.println("ID = " + f.getId() + " NOM = " + f.getNom());
			}
			curseur.close();
			monStatement.close();
			db.close();			
			
			} 
		catch (Exception e) {
			}

	}

}
