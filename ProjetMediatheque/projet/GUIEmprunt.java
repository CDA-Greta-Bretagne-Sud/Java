package fr.cda.projet;

import fr.cda.ihm.Formulaire;
import fr.cda.ihm.FormulaireInt;

import java.text.ParseException;

public class GUIEmprunt implements FormulaireInt {
    private GUISite formPP; // Le formulaire principal du programme
    private Mediatheque mediatheque;

    public GUIEmprunt(GUISite formPP,Mediatheque m){
        this.formPP=formPP;
        this.mediatheque=m;
        Formulaire form = new Formulaire("Emprunt Media", this, 600, 260);
        form.setPosition(20, 10);
        form.addListScroll("LISTE_EMPRUNTEUR","Liste des emprunteurs",true,this.mediatheque.tousEmprunteurs(),300,100);
        form.addListScroll("LISTE_MEDIA","Liste des medias",true,this.mediatheque.mediasDispos(),300,100);
        form.addButton("VALIDER", "Valider");
        form.afficher();


    }
    @Override
    public void submit(Formulaire form, String nom)  {
        if (nom.equals("VALIDER")){
            String inscrit=form.getValeurChamp("LISTE_EMPRUNTEUR");
            int debut1=inscrit.indexOf("=")+1;
            int fin1=inscrit.length()-1;
            String idInscrit= inscrit.substring(debut1,fin1);
            Emprunteur e1=this.mediatheque.chercherEmprunteurID(idInscrit);
            String media=form.getValeurChamp("LISTE_MEDIA");
            int debut2=media.indexOf("=")+1;
            int fin2=media.length()-1;
            String idMedia= media.substring(debut2,fin2);
            Media m1=this.mediatheque.chercherMediaID(idMedia);
            this.mediatheque.emprunter(e1,m1);
            form.fermer();
        }

    }
}
