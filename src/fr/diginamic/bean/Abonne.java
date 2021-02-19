package fr.diginamic.bean;

public class Abonne {

	private String nom;
	private String prenom;
	private String adresse;

	public Abonne(String nom, String prenom, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Abonne [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}

}
