/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.model.copy.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * @author driss
 *
 */
public class TestDaoJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// // Établir la connexion à la base de données
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/demojdbc","root","root");
			
			FournisseurDaoJdbc fournisseurDao = new FournisseurDaoJdbc(connect);
//			Fournisseur f1 = new Fournisseur(4, "France de matériaux");
//			// insérer un fournisseur appelé « France de matériaux
//			fournisseurDao.insert(f1);
//			
//			List<Fournisseur> listFournisseurs = fournisseurDao.extraire();
//			for(Fournisseur f : listFournisseurs) {
//				System.out.println("ID : "+ f.getId()+" Nom: " + f.getNom());
//			}
//			
//
//            // Modifier le fournisseur "France de matériaux" en "France matériaux"
//            int rowsUpdated = fournisseurDao.update("France de matériaux", "France matériaux");
//            System.out.println(rowsUpdated + " ligne(s) mise(s) à jour.");

            // Extraire et afficher la liste des fournisseurs
            List<Fournisseur> listFournisseurs2 = fournisseurDao.extraire();
            System.out.println("la nvl listes de fournissueurs : ");
            for (Fournisseur f : listFournisseurs2) {
                System.out.println("ID : " + f.getId() + " Nom: " + f.getNom());
            }

            // Supprimer le fournisseur "France matériaux"
            Fournisseur fournisseurASupprimer = new Fournisseur(11, "France matériaux");
            boolean isDeleted = fournisseurDao.delete(fournisseurASupprimer);
            if (isDeleted) {
                System.out.println("Fournisseur supprimé avec succès.");
            } else {
                System.out.println("La suppression du fournisseur a échoué.");
            }

            // Extraire et afficher à nouveau la liste des fournisseurs
            listFournisseurs2 = fournisseurDao.extraire();
            for (Fournisseur f : listFournisseurs2) {
                System.out.println("ID : " + f.getId() + " Nom: " + f.getNom());
            }
			
            Fournisseur f2 = new Fournisseur(4, " « L’Espace Création »");
			// insérer un fournisseur appelé  L’Espace Création 
			fournisseurDao.insert(f2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
