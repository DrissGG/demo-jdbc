/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.jdbc.entites.Departement;
import fr.diginamic.jdbc.entites.Region;

/**
 * @author driss
 *
 */
public interface DepartementDao {
	List<Departement> extraire();
	Departement getDepartementById(int id);
	Departement getDepartementByCode(String code);
	void insert(Departement r);
	int update(String ancienDepartement, String nouveauDepartement);
	boolean delete(Departement r);
}
