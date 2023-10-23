/**
 * 
 */
package fr.diginamic.jdbc.dao.model.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.DepartementDao;
import fr.diginamic.jdbc.entites.Departement;
import fr.diginamic.jdbc.entites.Region;

/**
 * @author driss
 *
 */
public class DepartementDaoJdbc implements DepartementDao{
	private Connection connection;
	
	/** Constructor
	 * @param connexion
	 */
	public DepartementDaoJdbc(Connection connexion) {
		this.connection = connexion;
	}

	@Override
	public List<Departement> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Departement departement) {
		try {
			PreparedStatement monStatement = connection.prepareStatement("INSERT INTO DEPARTEMENTS (code) VALUES (?)");
			
			monStatement.setString(1, departement.getCode());
			monStatement.executeUpdate();
			monStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public int update(String ancienDepartement, String nouveauDepartement) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Departement r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Departement getDepartementById(int id) {
		Departement dept = null;

	    try {
	        String query = "SELECT * FROM DEPARTEMENTS WHERE id = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, id);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            String code = resultSet.getString("code");
	            dept = new Departement(id, code);
	        }

	        resultSet.close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return dept;
	}
	@Override
	public Departement getDepartementByCode(String code) {
	    Departement departement = null;

	    try {
	        String query = "SELECT * FROM DEPARTEMENTS WHERE code = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, code);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            departement = new Departement(id, code);
	        }

	        resultSet.close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return departement;
	}
	


	}

