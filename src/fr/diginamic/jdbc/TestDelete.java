package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

	public static void main(String[] args) {

		ResourceBundle conf = ResourceBundle.getBundle("database");
		String driver = conf.getString("database.driver");
		String url = conf.getString("database.url");
		String user = conf.getString("database.user");
		String password = System.getProperty("password");
		try {
			// étape 1 : charger le driver
			// DriverManager.registerDriver(new Driver());
			Class.forName(driver);
			// étape 2 : je demande au DriverManager de ma fournir une connexion à une base
			// MySQL
			Connection connetion = DriverManager.getConnection(url, user, password);
			// étape 3 : création du Statement
			Statement statement = connetion.createStatement();
			statement.executeUpdate("DELETE FROM fournisseur WHERE id = 1");
			statement.close();
			connetion.close();
			System.out.println(connetion.isClosed());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
