package generic2;

public class Tomate {
private String variete;
private String couleur;


public Tomate(String variete, String couleur) {
	super();
	this.variete = variete;
	this.couleur = couleur;
}

public String getVariete() {
	return variete;
}
public void setVariete(String variete) {
	this.variete = variete;
}
public String getCouleur() {
	return couleur;
}
public void setCouleur(String couleur) {
	this.couleur = couleur;
}
@Override
public String toString() {
	return "Tomate [variete=" + variete + ", couleur=" + couleur + "]";
}

}
