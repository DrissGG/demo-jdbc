/**
 * 
 */
package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Ville;

/**
 * @author driss
 *
 */
public interface VilleDao {
	void insert(Ville ville);
	int update(String ancienVille, String nouvelleVille);
	boolean delete(Ville ville);
	Ville getVilleById(int id);
	Ville getVilleByNomAndDept(String nom, int idDepartement);
}
