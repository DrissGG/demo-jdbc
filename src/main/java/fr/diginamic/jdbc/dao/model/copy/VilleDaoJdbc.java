/**
 * 
 */
package fr.diginamic.jdbc.dao.model.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import fr.diginamic.jdbc.dao.VilleDao;
import fr.diginamic.jdbc.entites.Ville;

/**
 * @author driss
 *
 */
public class VilleDaoJdbc implements VilleDao{
	private Connection  connection;
	
	/** Constructor
	 * @param connect
	 */
	public VilleDaoJdbc(Connection connect) {
		this.connection = connect;
	}

	@Override
	public void insert(Ville ville) {
		try {			
			PreparedStatement monStatement = connection.prepareStatement("INSERT INTO villes (nom, population, idDepartement, idRegion) VALUES (?, ?, ?, ?)");
			//System.out.println(ville);
			monStatement.setString(1, ville.getNom());
			monStatement.setInt(2, ville.getPopulation());
			monStatement.setInt(3, ville.getIdDepartement());
			monStatement.setInt(4, ville.getIdRegion());
			monStatement.executeUpdate();
			
			
			monStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int update(String ancienVille, String nouvelleVille) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Ville ville) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ville getVilleById(int id) {
	    Ville ville = null;

	    try {
	        String query = "SELECT * FROM VILLES WHERE id = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, id);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            String nom = resultSet.getString("nom");
	            int population = resultSet.getInt("population");
	            int idDept = resultSet.getInt("idDepartement");
	            int idRegion = resultSet.getInt("idRegion");

	            ville = new Ville(id, nom, population, idDept, idRegion);
	        }

	        resultSet.close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ville;
	}


	@Override
	public Ville getVilleByNomAndDept(String nom, int idDepartement) {
	    Ville ville = null;

	    try {
	        String query = "SELECT * FROM VILLES WHERE nom = ? AND idDepartement = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, nom);
	        preparedStatement.setInt(2, idDepartement);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            int population = resultSet.getInt("population");
	            int idRegion = resultSet.getInt("idRegion");

	            ville = new Ville(id, nom, population, idDepartement, idRegion);
	        }

	        resultSet.close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ville;
	}

	
}
