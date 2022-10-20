package generic2;

public class Garage {
public String Nom;
public int surface;
public String Adresse;



public Garage(String nom, int surface, String adresse) {
	super();
	Nom = nom;
	this.surface = surface;
	Adresse = adresse;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public int getSurface() {
	return surface;
}
public void setSurface(int surface) {
	this.surface = surface;
}
public String getAdresse() {
	return Adresse;
}
public void setAdresse(String adresse) {
	Adresse = adresse;
}
@Override
public String toString() {
	return "Garage [Nom=" + Nom + ", surface=" + surface + ", Adresse=" + Adresse + "]";
}


}
