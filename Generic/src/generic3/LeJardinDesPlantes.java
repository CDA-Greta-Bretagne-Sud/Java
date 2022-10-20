package generic3;

public class LeJardinDesPlantes {
private String Adresse;
private String emplacement;



public String getAdresse() {
	return Adresse;
}

public void setAdresse(String adresse) {
	Adresse = adresse;
}

public String getEmplacement() {
	return emplacement;
}

public void setEmplacement(String emplacement) {
	this.emplacement = emplacement;
}

public LeJardinDesPlantes(String adresse, String emplacement) {
	super();
	Adresse = adresse;
	this.emplacement = emplacement;
}

@Override
public String toString() {
	return "LeJardinDesPlantes [Adresse=" + Adresse + ", emplacement=" + emplacement + "]";
}

}
