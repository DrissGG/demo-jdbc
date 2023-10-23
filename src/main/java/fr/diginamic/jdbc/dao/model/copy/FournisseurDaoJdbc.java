/**
 * 
 */
package fr.diginamic.jdbc.dao.model.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * @author driss
 *
 */
public class FournisseurDaoJdbc implements FournisseurDao {
	private Connection connection;

    public FournisseurDaoJdbc(Connection connection) {
        this.connection = connection;
    }
    
	@Override
	public List<Fournisseur> extraire() {
		List<Fournisseur> listFournisseur = new ArrayList<>();
		// Créer une instruction SQL
		Statement monStatement;
		try {
			monStatement = connection.createStatement();
			ResultSet curseur = monStatement.executeQuery("SELECT ID, NOM FROM fournisseur");
			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				
				Fournisseur fournisseur = new Fournisseur(id, nom);
				listFournisseur.add(fournisseur);			
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listFournisseur;
		
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		try {			
			PreparedStatement monStatement = connection.prepareStatement("INSERT INTO fournisseur (NOM) VALUES (?)");
			
			monStatement.setString(1, fournisseur.getNom());
			monStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		try {
			PreparedStatement monStatement = connection.prepareStatement("UPDATE fournisseur SET NOM = ? WHERE NOM = ? ");
			monStatement.setString(1, nouveauNom);
			monStatement.setString(2, ancienNom);
			int fournisseur1 = monStatement.executeUpdate();
			
			return fournisseur1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1; //cas d'erreur 
		}
		
		
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		try {
			PreparedStatement monStatement = connection.prepareStatement("DELETE FROM fournisseur WHERE ID = ? ");
			monStatement.setInt(1, fournisseur.getId());
			int f = monStatement.executeUpdate();
			
			if(f>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
		
	}
	
}
