package fr.cda.projet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Media {
    String identificateur;
    static int lastID=0;
    String categorie;
    String sousCategorie;
    String description;
    int idEmprunteur=0;
    Date dateEmprunt;

    public Media (String identificateur, String categorie, String sousCategorie, String description){                   //Constructeur pour un media qui n'a pas été emprunté
        lastID++;
        this.identificateur=identificateur+"-"+String.valueOf(lastID);
        this.categorie=categorie;
        this.sousCategorie = sousCategorie;
        this.description=description;
    }
    public Media (){

    }

    public String getIdentificateur() {
        return identificateur;
    }

    public void setIdentificateur(String identificateur) {
        this.identificateur = identificateur;
    }


    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdEmprunteur() {
        return idEmprunteur;
    }

    public void setIdEmprunteur(int idEmprunteur) {
        this.idEmprunteur = idEmprunteur;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    @Override
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/YYYY hh:mm");
        String res= "Media{" +
                "identificateur='" + identificateur + '\'' +
                ", categorie='" + categorie + '\'' +
                ", sousCategorie='" + sousCategorie + '\'' +
                ", description='" + description + '\'' +
                ", idEmprunteur=" + idEmprunteur+"}";
                if (dateEmprunt!=null){
                    res+=", dateEmprunt=" + ft.format(dateEmprunt) +"}";

                }
                res+="\n ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
                return res;
    }
}
