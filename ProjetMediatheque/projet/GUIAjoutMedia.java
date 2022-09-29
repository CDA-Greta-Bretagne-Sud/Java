package fr.cda.projet;

import fr.cda.ihm.Formulaire;
import fr.cda.ihm.FormulaireInt;

import javax.swing.*;

public class GUIAjoutMedia implements FormulaireInt {
    private GUISite formPP; // Le formulaire principal du programme
    private Mediatheque mediatheque;

    public GUIAjoutMedia(GUISite formPP,
                         Mediatheque m) {
        this.formPP = formPP;
        this.mediatheque = m;
        Formulaire form = new Formulaire("Ajout Média", this, 320, 260);
        form.setPosition(20, 10);
        form.addText("DATE_PARUTION", "Date de Parution (\"AAAA-MM\")", true, "");
        form.addText("CATEGORIE", "Categorie", true, "");
        form.addText("SOUS_CATEGORIE", "Sous Categorie", true, "");
        form.addText("DESCRIPTION", "Description", true, "");
        form.addButton("VALIDER", "Valider");
        form.afficher();


    }

    @Override
    public void submit(Formulaire form, String nom) {
        if (nom.equals("VALIDER")) {
            Media m = new Media(form.getValeurChamp("DATE_PARUTION"), form.getValeurChamp("CATEGORIE"), form.getValeurChamp("SOUS_CATEGORIE"), form.getValeurChamp("DESCRIPTION"));
            this.mediatheque.ajouterMedia(m);
            this.formPP.AfficherResultat(this.mediatheque.afficher());
            form.fermer();
        }
    }
}
