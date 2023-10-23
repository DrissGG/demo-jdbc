package fr.diginamic.jdbc.entites;

/**
 * Représente une ville
 * 
 * @author DIGINAMIC
 *
 */
public class Ville {

	/** idRegion : id de la région */
	private int idRegion;
	/** idDepartement : id du département */
	private int idDepartement;
	/** id de la ville */
	private int idVille;
	/** nom de la ville */
	private String nom;
	/** population totale */
	private int population;

	/**
	 * Constructeur
	 * 
	 * @param idRegion id de la région
	 * @param idDepartement id du département
	 * @param idVille id de la ville
	 * @param nom nom de la ville
	 * @param population population totale
	 */
	public Ville(int idVille, String nom, int population, int idDepartement, int idRegion) {
		super();
		this.idVille = idVille;
		this.idRegion = idRegion;
		this.idDepartement = idDepartement;
		this.nom = nom;
		this.population = population;
	}

	@Override
	public String toString() {
		return "Ville [idRegion=" + idRegion + ", idDepartement=" + idDepartement + ", idVille=" + idVille + ", nom="
				+ nom + ", population=" + population + "]";
	}

	/** Getters
	 * @return the idRegion
	 */
	public int getIdRegion() {
		return idRegion;
	}

	/** Setters
	 * @param idRegion the idRegion to set
	 */
	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	/** Getters
	 * @return the idDepartement
	 */
	public int getIdDepartement() {
		return idDepartement;
	}

	/** Setters
	 * @param idDepartement the idDepartement to set
	 */
	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}

	/** Getters
	 * @return the idVille
	 */
	public int getIdVille() {
		return idVille;
	}

	/** Setters
	 * @param idVille the idVille to set
	 */
	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	/** Getters
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setters
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getters
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/** Setters
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	

}
