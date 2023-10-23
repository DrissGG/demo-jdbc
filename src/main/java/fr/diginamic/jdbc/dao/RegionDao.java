/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.entites.Region;

/**
 * @author driss
 *
 */
public interface RegionDao {
	List<Region> extraire();
	Region getRegionById(int id);
	Region getRegionByNom(String nom);
	void insert(Region r);
	int update(String ancienRegion, String nouveauRegion);
	boolean delete(Region r);
}
