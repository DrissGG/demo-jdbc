/**
 * 
 */
package fr.diginamic.jdbc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.DepartementDao;
import fr.diginamic.jdbc.dao.RegionDao;
import fr.diginamic.jdbc.dao.VilleDao;
import fr.diginamic.jdbc.dao.model.copy.DepartementDaoJdbc;
import fr.diginamic.jdbc.dao.model.copy.RegionDaoJdbc;
import fr.diginamic.jdbc.dao.model.copy.VilleDaoJdbc;
import fr.diginamic.jdbc.entites.Departement;
import fr.diginamic.jdbc.entites.Region;
import fr.diginamic.jdbc.entites.Ville;

/**
 * @author driss
 *
 */
public class TestDaoRecensement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/recensement" , "root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        ResourceBundle config = ResourceBundle.getBundle("database");
//		String driverName = config.getString("database.driver");
//		String url = config.getString("database.url");
//		String user = config.getString("database.user");
//		String pwd = config.getString("database.pwd");

        if (connection == null) {
            System.err.println("Impossible de se connecter à la base de données.");
            return;
        }
        

        // Créez les DAO
        RegionDao regionDao = new RegionDaoJdbc(connection);
        DepartementDao departementDao = new DepartementDaoJdbc(connection);
        VilleDao villeDao = new VilleDaoJdbc(connection);
        
        long debut = System.currentTimeMillis();
        try {
        	Path pathFile = Paths.get("C:/Users/driss/Documents/recensement.csv"); // emplacement du fichier 
    		List<String> lines = Files.readAllLines(pathFile, StandardCharsets.UTF_8);
    		lines.remove(0);
    		for (String line : lines) {
    	        String[] nextLine = line.split(";"); // Supposons que le CSV utilise des virgules comme séparateur

    	        String nomRegion = nextLine[1]; 
    	        String codeDepartement = nextLine[2];
    	        String nomVille = nextLine[6];
    	        int populationVille = Integer.parseInt(nextLine[9].replaceAll(" ", ""));

    	        Region region = regionDao.getRegionByNom(nomRegion);
    	        if (region == null) {
    	            region = new Region(0, nomRegion);    	            
    	            regionDao.insert(region);
    	            region = regionDao.getRegionByNom(nomRegion);
    	        }
    	        
    	        //System.out.println(region.getIdRegion());

    	        Departement departement = departementDao.getDepartementByCode(codeDepartement);
    	        if (departement == null) {
    	            departement = new Departement(0, codeDepartement);
    	            departementDao.insert(departement); 
    	            departement = departementDao.getDepartementByCode(codeDepartement);
    	        }
    	        

    	        // Vérifier si la ville existe pour le département donné
    	        Ville existingVille = villeDao.getVilleByNomAndDept(nomVille, departement.getIdDepartement());
    	        if (existingVille == null) {
    	            Ville ville = new Ville(1, nomVille, populationVille, departement.getIdDepartement(), region.getIdRegion());
    	            villeDao.insert(ville);
    	        } else {
    	            System.out.println("VILLE EST DEJA PRESENTE ");
    	        }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long fin = System.currentTimeMillis();
		
        long tempsEnSecondes = (fin - debut) / 1000;
        System.out.println("Temps écoulé en secondes : " + tempsEnSecondes);
        System.out.println("Temps écoulé en millisecondes :" + (fin - debut));
		System.out.println("Temps écoulé en minutes :" + (fin - debut)/60000);
        // Fermez la connexion à la base de données
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

}
