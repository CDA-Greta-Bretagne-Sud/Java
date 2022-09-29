package fr.cda.projet;

import fr.cda.ihm.*;

// Classe de definition de l'IHM principale de l'application mediatheque
//
public class GUISite implements FormulaireInt
{
    private Mediatheque mediatheque;  // la mediatheque

    // Constructeur
    //
    Formulaire form;
    public GUISite(Mediatheque m)
    {
        this.mediatheque = m;

        // Creation du formulaire
         form = new Formulaire("Mediatheque",this,1100,730);
        
        //  Creation des elements de l'IHM
        //

        form.setPosition(20,10);
        form.addLabel("Afficher tous les medias et inscrits");
        form.addButton("AFF_MEDIAINSCRITS","Tous les médias et inscrits");
        form.addLabel("");
        form.addLabel("Ajouter un inscrit");
        form.addButton("AJOUT_INSCRIT","Ajouter un inscrit");
        form.addLabel("");
        form.addLabel("Ajouter un Media");
        form.addButton("AJOUT_MEDIA","Ajouter un media");
        form.addLabel("");
        form.addLabel("Emprunter un Media");
        form.addButton("EMPRUNT_MEDIA","Emprunter un Media");
        form.addLabel("");
        form.setPosition(350,10);
        form.addText("RECHERCHE_EMPRUNTEUR","Recherche d'un emprunteur",true,"");
        form.addButton("CHERCHER_EMPRUNTEUR","Chercher");
        form.setPosition(750,10);
        form.addText("RECHERCHE_MEDIA","Recherche d'un media",true,"");
        form.addButton("CHERCHER_MEDIA","Chercher");
        form.setPosition(40,350);
        form.addButton("FERMER","FERMER");
        form.setPosition(350,60);
        form.addZoneText("RESULTATS","Resultats",
                            false,
                            "",
                            700,700);

        // Affichage du formulaire
        form.afficher();
    }


    // Methode appellee quand on clique dans un bouton
    //
    public void submit(Formulaire form,String nomSubmit)
    {

        // Affichage de tous les medias et inscrits
        //
        if (nomSubmit.equals("AFF_MEDIAINSCRITS"))
            {
                form.setValeurChamp("RESULTATS", mediatheque.afficher());
            }

        // Ajout inscrit
        //
        if (nomSubmit.equals("AJOUT_INSCRIT"))
            {
                GUIAjoutInscrit ajoutInscrit= new GUIAjoutInscrit(this,this.mediatheque);
            }

        // Ajout media
        //
        if (nomSubmit.equals("AJOUT_MEDIA"))
            {

                GUIAjoutMedia ajoutMedia= new GUIAjoutMedia(this,this.mediatheque);
            }
        if (nomSubmit.equals("EMPRUNT_MEDIA")){

            GUIEmprunt emprunt = new GUIEmprunt(this,this.mediatheque);
        }

        if (nomSubmit.equals("CHERCHER_EMPRUNTEUR")){
            this.AfficherResultat(this.mediatheque.chercherEmprunteur(form.getValeurChamp("RECHERCHE_EMPRUNTEUR")));
        }

        if (nomSubmit.equals("CHERCHER_MEDIA")){
            this.AfficherResultat(this.mediatheque.chercherMedia(form.getValeurChamp("RECHERCHE_MEDIA")));
        }

        // fermer
        //
        if (nomSubmit.equals("FERMER"))
            {
             form.fermer();
            }

    }
    public void AfficherResultat(String res){
        form.setValeurChamp("RESULTATS",res);
    }


}