/**
 * 
 */
package fr.diginamic.jdbc.entites;

/**
 * @author driss
 *
 */
public class Fournisseur {
	private Integer id;
	private String nom;
	
	/** Constructor
	 * @param id
	 * @param nom
	 */
	public Fournisseur(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/** Getters
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setters
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	
}
