
public class Tomate implements Legume{
private String variete;
private String couleur;


public Tomate(String variete, String couleur) {
	super();
	this.variete = variete;
	this.couleur = couleur;
}
public String getLegume(){
	return this.getVariete();
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
