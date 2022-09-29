package fr.cda.projet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Emprunteur {
    int id;
    static int lastID=1;
    String nom;
    String prenom;
    Date dateNaissance;
    ArrayList<Media> listeMedias=new ArrayList<Media>();

    public Emprunteur(String nom, String prenom, Date dateNaissance){
        this.id=lastID++;
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance=dateNaissance;
    }
    public Emprunteur(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public ArrayList<Media> getListeMedias() {
        return listeMedias;
    }

    public void setListeMedias(ArrayList<Media> listeMedias) {
        this.listeMedias = listeMedias;
    }

    public String afficherMedia() {
        String res="";
        for (int i=0;i<listeMedias.size();i++){
            Media m=listeMedias.get(i);
            res+=m.toString()+"\n";
        }
        return res;
    }

    @Override
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        return "Emprunteur{" +
                "id=" + this.getId() +
                ", nom='" + this.getNom() + '\'' +
                ", prenom='" + this.getPrenom() + '\'' +
                ", dateNaissance=" + ft.format(this.getDateNaissance())+", listeMedias=" + this.afficherMedia() +
                "} \n ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
    }
}
