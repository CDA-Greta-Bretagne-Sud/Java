package fr.cda.projet;

import fr.cda.ihm.Formulaire;
import fr.cda.ihm.FormulaireInt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static fr.cda.util.DateString.toCalendar;

public class GUIAjoutInscrit implements FormulaireInt {
    private GUISite formPP; // Le formulaire principal du programme
    private Mediatheque m;

    public GUIAjoutInscrit (GUISite formPP,Mediatheque m){
        this.formPP=formPP;
        this.m=m;
        Formulaire form=new Formulaire("Ajout Emprunteur",this,320,260);
        form.setPosition(20, 10);
        form.addText("NOM", "Nom", true, "");
        form.addText("PRENOM", "Prénom", true, "");
        form.addText("DATE_NAISSANCE", "Date de naissance", true, "");
        form.addButton("VALIDER", "Valider");
        form.afficher();
    }


    @Override
    public void submit(Formulaire form, String nom) throws ParseException {
        if (nom.equals("VALIDER")){
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            Date date= ft.parse(form.getValeurChamp("DATE_NAISSANCE"));
            Emprunteur e=new Emprunteur(form.getValeurChamp("NOM"),form.getValeurChamp("PRENOM"),date);
            this.m.ajouterInscrit(e);
            this.formPP.AfficherResultat(this.m.afficher());
            form.fermer();
        }

    }
}
