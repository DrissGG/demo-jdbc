package fr.diginamic.jdbc.entites;

import java.util.ArrayList;
import java.util.List;

/** Représente une région
 * @author DIGINAMIC
 *
 */
public class Region {

	/** id : int*/
	private int  idRegion;
	/** nom : String*/
	private String nom;
	/** population : int*/
	private int population;
	
	/** villes : List<Ville>*/
	private List<Ville> villes = new ArrayList<>();
	
	/** Constructeur
	 * @param code code
	 * @param nom nom
	 */
	public Region(int idRegion, String nom) {
		super();
		this.idRegion = idRegion;
		this.nom = nom;
	}
	
	/** Ajoute une ville
	 * @param ville ville
	 */
	public void addVille(Ville ville){
		villes.add(ville);
		this.population=this.population+ville.getPopulation();
	}
	
	/** Getter
	 * @return the code
	 */
	public int getIdRegion() {
		return idRegion;
	}
	/** Setter
	 * @param code the code to set
	 */
	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}
	/** Setter
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	
}
