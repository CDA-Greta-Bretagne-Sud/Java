package generic3;

public class Tomate<L,J> implements Legume<L,J> {
private L variete;
private J jardin;
private String couleur;


public Tomate( L v, J j, String couleur) {
	
	this.variete = v;
	this.jardin = j;
	this.couleur = couleur;
}

public L getLegume(){
	return this.variete;
}

public J getJardin(){
	return this.jardin;
}

public void setVariete(L variete) {
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
	return "Tomate [variete=" + variete + ", jardin=" + jardin + ", couleur=" + couleur + "]";
}


}
