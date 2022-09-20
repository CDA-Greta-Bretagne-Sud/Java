
public class Personne {
private static int lastId=0;
private int Id;
private String Nom;
private String Prenom;
private Adresse adresse;
private String email;
public Personne(String nom, String prenom, Adresse adresse, String email) {
	Id=lastId++;
	Nom = nom;
	Prenom = prenom;
	this.adresse = adresse;
	this.email = email;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public String getPrenom() {
	return Prenom;
}
public void setPrenom(String prenom) {
	Prenom = prenom;
}
public Adresse getAdresse() {
	return adresse;
}
public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
@Override
public String toString() {
	return "Personne [id="+ getId() +" Nom="+ getNom() + ", getPrenom()=" + getPrenom() + ", getAdresse()=" + getAdresse()
			+ ", getEmail()=" + getEmail() + "]";
}

}
