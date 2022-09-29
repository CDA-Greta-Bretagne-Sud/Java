package fr.cda.projet;

import java.util.ArrayList;
import java.util.Calendar;

public class Mediatheque {
    ArrayList<Media>listeMedias= new ArrayList<Media>();
    ArrayList<Emprunteur>listeEmprunteurs=new ArrayList<Emprunteur>();
    static int compteMedia=0;

    public ArrayList<Media> getListeMedias() {
        return listeMedias;
    }

    public void setListeMedias(ArrayList<Media> listeMedias) {
        this.listeMedias = listeMedias;
    }

    public ArrayList<Emprunteur> getListeEmprunteurs() {
        return listeEmprunteurs;
    }

    public void setListeEmprunteurs(ArrayList<Emprunteur> listeEmprunteurs) {
        this.listeEmprunteurs = listeEmprunteurs;
    }

    public static int getCompteMedia() {
        return compteMedia;
    }

    public static void setCompteMedia(int compteMedia) {
        Mediatheque.compteMedia = compteMedia;
    }


    public void ajouterMedia(Media m){                                                                                  //Ajout d'un media dans la médiathèque avec incrémentation du compteur de medias
        listeMedias.add(m);
        compteMedia++;
    }

    public void ajouterInscrit(Emprunteur e){                                                                           //Ajout d'un inscrit dans la liste des emprunteurs de la médiathèque
        listeEmprunteurs.add(e);
    }

    public String afficher(){                                                                                           //Affichage de la liste des médias et la liste des emprunteurs
        String res="";
        for (int i=0;i<listeMedias.size();i++){
            Media m= listeMedias.get(i);
            res+=m.toString()+"\n";
        }
        for (int i=0;i<listeEmprunteurs.size();i++){
            Emprunteur e= listeEmprunteurs.get(i);
            res+=e.toString()+"\n";
        }
        return res;
    }

    // A MODIFIER CAR CA NE MARCHE PAS
    public void emprunterModeConsole (int idEmprunteur,String idMedia){                                                  //Emprunter un média
        Emprunteur emp=new Emprunteur();
        for (int i=0;i<listeEmprunteurs.size();i++){
            Emprunteur e=listeEmprunteurs.get(i);
            if (idEmprunteur==e.getId()) {
                emp = e;
            }
        }
        Media med=new Media();
        for (int j=0;j<listeMedias.size();j++) {
            Media media = listeMedias.get(j);
            if (media.getIdentificateur().equals(idMedia)) {
                med = media;
            }
        }
        med.setIdEmprunteur(emp.getId());                                                                               //On change l'idEmprunteur du média et on ajoute le média dans la liste des médias empruntés par l'emprunteur
        emp.listeMedias.add(med);
        Calendar calendar= Calendar.getInstance();
        med.setDateEmprunt(calendar.getTime());                                                                         //On change la date d'emprunt pour la date du jour où le média est emprunté
    }
    public String chercherEmprunteur (String nom){
        String res="";
        for (int i=0;i<listeEmprunteurs.size();i++){
            Emprunteur e= listeEmprunteurs.get(i);
            String nomPrenom=e.getNom()+" "+e.getPrenom();
            if (nomPrenom.contains(nom)){
                res+=e.toString()+"\n";
            }
        }
        return res;
    }

    public String chercherMedia(String categorie){
        String res="";
        for (int i=0;i<listeMedias.size();i++){
            Media m=listeMedias.get(i);
            if (categorie.equals(m.getCategorie())){
                res+=m.toString()+"\n";
            }
        }
        return res;
    }

    public String[] tousEmprunteurs (){
        String[] emprunteurs = new String[listeEmprunteurs.size()];
        for (int i=0;i<listeEmprunteurs.size();i++){
            Emprunteur e=listeEmprunteurs.get(i);
            emprunteurs [i]=e.getNom()+" "+e.getPrenom()+" (id="+e.getId()+")";
        }
        return emprunteurs;
    }

    public String[] mediasDispos(){
        String[]medias=new String[listeMedias.size()];
        for (int i=0;i<listeMedias.size();i++){
            Media m=listeMedias.get(i);
            if (m.getIdEmprunteur()==0){
                medias[i]=m.getDescription()+" (Categorie: "+m.getCategorie()+" Sous-categorie:  "+m.getSousCategorie()+" id="+m.getIdentificateur()+")";
            }
        }
        return medias;
    }

    public void emprunter(Emprunteur emprunteur, Media media){
        media.setIdEmprunteur(emprunteur.getId());
        Calendar calendar= Calendar.getInstance();
        media.setDateEmprunt(calendar.getTime());
        emprunteur.listeMedias.add(media);
    }
    public Emprunteur chercherEmprunteurID (String id) {
        Emprunteur res= new Emprunteur();
        for (int i = 0; i < listeEmprunteurs.size(); i++) {
            Emprunteur e = listeEmprunteurs.get(i);
            if (id.equals(String.valueOf(e.getId()))) {
                res=e;
            }
        }
        return res;
    }
    public Media chercherMediaID (String id) {
        Media res= new Media();
        for (int i = 0; i < listeMedias.size(); i++) {
            Media m= listeMedias.get(i);
            if (m.getIdentificateur().equals(id)) {
                res=m;
            }
        }
        return res;
    }


}
