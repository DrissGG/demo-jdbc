/**
 * 
 */
package fr.diginamic.jdbc.dao.model.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.RegionDao;
import fr.diginamic.jdbc.entites.Region;

/**
 * @author driss
 *
 */
public class RegionDaoJdbc implements RegionDao{
	private Connection connection;
	
	/** Constructor
	 * @param connexion
	 */
	public RegionDaoJdbc(Connection connexion) {
		this.connection = connexion;
	}

	@Override
	public List<Region> extraire() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
    public Region getRegionById(int id) {
		Region region = null;

	    try {
	        String query = "SELECT * FROM REGIONS WHERE id = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, id);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            String nom = resultSet.getString("nom");
	            region = new Region(id, nom);
	        }

	        resultSet.close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return region;
    }

    @Override
    public Region getRegionByNom(String nom) {
        Region region = null;

        try {
            String query = "SELECT * FROM REGIONS WHERE nom = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nom);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                region = new Region(id, nom);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return region;
    }

	@Override
	public void insert(Region region) {
		try {
			PreparedStatement monStatement = connection.prepareStatement("INSERT INTO REGIONS (nom) VALUES (?)");
			monStatement.setString(1, region.getNom());
			monStatement.executeUpdate();
			monStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public int update(String ancienRegion, String nouveauRegion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Region r) {
		// TODO Auto-generated method stub
		return false;
	}
}
