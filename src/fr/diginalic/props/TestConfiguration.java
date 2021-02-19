/**
 * 
 */
package fr.diginalic.props;

import java.util.ResourceBundle;

/**
 * @author Antoine
 *
 */
public class TestConfiguration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
		String prenom = monFichierConf.getString("database.prenom");
		System.out.println(prenom);
	}

}
