package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.bean.Abonne;

public class TestLecture {

	public static void main(String[] args) {

		ResourceBundle conf = ResourceBundle.getBundle("database");
		String driver = conf.getString("database.driver");
		String url = conf.getString("database.url.formation-sql");
		String user = conf.getString("database.user");
		String password = System.getProperty("password");
		List<Abonne> abonnes = new ArrayList<>();
		try {
			// étape 1 : charger le driver
			// DriverManager.registerDriver(new Driver());
			Class.forName(driver);
			// étape 2 : je demande au DriverManager de ma fournir une connexion à une base
			// MySQL
			Connection connetion = DriverManager.getConnection(url, user, password);
			// étape 3 : création du Statement
			Statement statement = connetion.createStatement();
			ResultSet curseur = statement.executeQuery("SELECT nom, prenom, adresse from abonne");
			while(curseur.next()) {
				abonnes.add(new Abonne(
					curseur.getString("nom"), 
					curseur.getString("prenom"), 
					curseur.getString("adresse")
				));
			}
			curseur.close();
			statement.close();
			connetion.close();
			System.out.println(connetion.isClosed());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		for (Abonne abonne : abonnes) {
			System.out.println(abonne);
		}
		
	}

}
